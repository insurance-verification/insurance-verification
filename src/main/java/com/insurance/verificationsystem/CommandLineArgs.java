package com.insurance.verificationsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.insurance.verificationsystem.cache.Vehicle;
import com.insurance.verificationsystem.cache.VehiclesCacheLoader;
import com.insurance.verificationsystem.config.UpdateProperty;

@Component
public class CommandLineArgs implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineArgs.class);
    @Autowired
    ApplicationContext context;

    @Autowired
    StringEncryptor encryptor;
    
    @Autowired 
    VehiclesCacheLoader vehiclesCacheLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.getOptionNames().size() > 0) {
            logger.info("Your application started with option names : {}", args.getOptionNames());
            final Queue<String> argStack = new LinkedList<>();
            argStack.addAll(Arrays.asList(args.getSourceArgs()));
            while(argStack.peek()!=null && argStack.peek().startsWith("--"))
                argStack.poll();
            if (args.containsOption("wizard")) {
                wizard(argStack);
            } else if (args.containsOption("db-wizard")) {
                dbWizard(argStack);
            } else if (args.containsOption("load-vehicles")) {
                loadVehicles(argStack);
            } else if (args.containsOption("service-wizard")) {
                serviceWizard(argStack);
            } else if (args.containsOption("activate")) {
                addProfile(args.getOptionValues("activate"));
            } else if (args.containsOption("help") || args.containsOption("h")) {
                System.out.println("Run app with ");
                System.out.println("  java -jar ok-ivs-0.1.0.jar");
                System.out.println("Run ");
                System.out.println("  java -jar ok-ivs-0.1.0.jar --spring.profiles.active=default --wizard");
                System.out.println("to leverage the automatic setup");
                System.out.println("Run ");
                System.out.println("  java -jar ok-ivs-0.1.0.jar --spring.profiles.active=default --service-wizard");
                System.out.println("to configure the windows service");
                System.out.println("Run ");
                System.out.println("  java -jar ok-ivs-0.1.0.jar --spring.profiles.active=default --db-wizard");
                System.out.println("to configure the db userid/password");
            }else{
                return;
            }
            SpringApplication.exit(context);
        }
    }
    
    private void wizard(final Queue<String> argStack) throws IOException {
        final PrintStream out = System.out;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            out.println("Initializing app");
            final boolean force = "overwrite".equals(argStack.peek());
            if(force)
                argStack.poll();
            
            final String profile = readNext("Which profile ? [secure]", out, r, "secure",argStack);
            final File f = new File("application-" + profile + ".yaml");
            final boolean exists = f.exists();
            if (exists && !force) {
                final String overwrite = readNext("File " + f.getName() + " exists, overwrite? [N]", out, r, "N");
                if (!overwrite.startsWith("Y")) {
                    return;
                }
            }
            final String port = readNext("Which port? [8443]", out, r, "8443", argStack);
            final boolean https_flag = readNext("Use HTTPS [Y]", out, r, "Y", argStack).toUpperCase().startsWith("Y");

            final StringBuilder sb = new StringBuilder();
            sb.append("server:\r\n");
            if (!port.isEmpty()) {
                sb.append("    port: ").append(port).append("\r\n");
            }
            if (https_flag) {
                final String key_store = readNext("Key store file [keystore.jks]", out, r, "keystore.jks", argStack);
                final String key_store_pass = readNext("Key store password []", out, r, "", argStack);
                final String key_store_type = readNext("Key store type (PKCS12) []", out, r, "", argStack);
                final String key_store_alias = readNext("Key store cert alias []", out, r, "", argStack);
                final String trust_store = readNext("Trust store file [trust.jks]", out, r, "trust.jks", argStack);
                final String trust_store_pass = readNext("Trust store password []", out, r, "", argStack);
                final String client_cert = readNext("Client cert (need,want) []", out, r, "", argStack);
                sb.append("    ssl:\r\n");
                sb.append("      key-store: ").append(key_store).append("\r\n");
                if (!key_store_pass.isEmpty()) {
                    sb.append("      key-store-password: ").append(key_store_pass).append("\r\n");
                }
                if (!key_store_type.isEmpty()) {
                    sb.append("      key-store-type: ").append(key_store_type).append("\r\n");
                }
                if (!key_store_alias.isEmpty()) {
                    sb.append("      key-alias: ").append(key_store_alias).append("\r\n");
                }
                sb.append("      trust-store: ").append(trust_store).append("\r\n");
                if (!trust_store_pass.isEmpty()) {
                    sb.append("      trust-store-password: ").append(trust_store_pass).append("\r\n");
                }
                if (!client_cert.isEmpty()) {
                    sb.append("      client-auth: ").append(client_cert).append("\r\n");
                }
            }
            final FileOutputStream fos = new FileOutputStream(f);
            fos.write(sb.toString().getBytes());
            fos.close();
            System.out.println("File " + f.getName() + (exists ? " replaced" : " created"));
            final File f2 = new File("application.properties");
            final String profiles = f2.exists()?UpdateProperty.get(f2, "spring.profiles.active"):null;
            final boolean exists2 = profiles != null && profiles.trim().length() > 0;
            if (exists2) {
                if (!Arrays.asList(profiles.split(",")).contains(profile)) {
                    UpdateProperty.alterProp(f2, "spring.profiles.active", profiles + "," + profile);
                    System.out.println("Updated spring.profiles.active in file " + f2.getName());
                }
            } else {
                UpdateProperty.alterProp(f2, "spring.profiles.active", profile);
                System.out.println("Added spring.profiles.active to file " + f2.getName());
            }
        }
    }
    private String readNext(final String query, final PrintStream out, final BufferedReader r,
            final String defaultVal, final Queue<String> args) throws IOException {
        if (args!=null && !args.isEmpty()) {
            String val = args.poll();
            out.println(query + " " + val);
            return val;
        }
        return readNext(query, out, r, defaultVal);
    }

    private String readNext(final String query, final PrintStream out, final BufferedReader r,
            final String defaultVal) throws IOException {
        out.print(query);
        String nextLine = r.readLine();
        if (nextLine == null) {
            throw new IOException("Done");
        }
        if (nextLine.trim().length() == 0) {
            nextLine = defaultVal;
        }

        return nextLine;
    }

    private void dbWizard(final Queue<String> argStack) throws IOException {
        final PrintStream out = System.out;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            out.println("Creating service definition");
            final File f2 = new File("application.properties");
            final String username = readNext("Source DB User name: ", out, r, "", argStack);
            UpdateProperty.alterProp(f2, "verificationsystem.db.datasource.username", username);
            final String freepassword = readNext("Source DB User password: ", out, r, "", argStack);
            final String password =encryptor.encrypt(freepassword);
            UpdateProperty.alterProp(f2, "verificationsystem.db.datasource.password",
                    String.format("ENC(%s)", password));
            final String username2 = readNext("Audit DB User name: ", out, r, "", argStack);
            UpdateProperty.alterProp(f2, "verificationsystem.audit.datasource.username", username2);
            final String freepassword2 = readNext("Audit DB User password:", out, r, "", argStack);
            final String password2 =encryptor.encrypt(freepassword2);
            UpdateProperty.alterProp(f2, "verificationsystem.audit.datasource.password",
                    String.format("ENC(%s)", password2));
            System.out.print("Properties written to " + f2.getName());
        }
    }
    private void loadVehicles(final Queue<String> argStack) throws IOException {
    	List<Vehicle> vehicles = vehiclesCacheLoader.load();
    	RestTemplate restTemplate = new RestTemplate();
    	String resourceUrl = argStack.poll();
    	ResponseEntity<String> response
    	  = restTemplate.postForEntity(resourceUrl, vehicles, String.class);
    	System.out.println(response.getBody());
    }
    private void serviceWizard(final Queue<String> argStack) throws IOException {
        final PrintStream out = System.out;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            out.println("Creating service definition");
            final String id = readNext("Service ID [okivs]", out, r, "okivs", argStack);
            final String name = readNext("Service Name [OK-IVS]", out, r, "OK-IVS", argStack);
            final String desc = readNext("Service Description [OK Insurance Verification]", out, r,
                    "OK Insurance Verification", argStack);
            final StringBuilder sb = new StringBuilder();
            sb.append("<service>\r\n");
            sb.append(String.format("  <id>%s</id>\r\n", id));
            sb.append(String.format("  <name>%s</name>\r\n", name));
            sb.append(String.format("  <description>%s</description>\r\n", desc));
            sb.append("  <executable>java</executable>\r\n");
            String jarPath = InsuranceVerificationSystemApplication.class.getProtectionDomain().getCodeSource()
                    .getLocation().toString();
            jarPath = jarPath.replaceAll("(.*[.]jar).*", "$1");
            final String jarName = jarPath.substring(jarPath.lastIndexOf("/") + 1);
            StringBuilder otherArgs = new StringBuilder();
            while(!argStack.isEmpty()){
                otherArgs.append(argStack.poll()).append(" ");
            }
            sb.append(String.format("  <arguments>-jar %s %s</arguments>\r\n", jarName, otherArgs.toString().trim()));
            sb.append("</service>");
            final FileOutputStream fos = new FileOutputStream(id + ".xml");
            fos.write(sb.toString().getBytes());
            fos.close();
            
            File serviceF = new File("WinSW.NET2.exe");
            if(serviceF.exists()){
                File target = new File(id +".exe");
                serviceF.renameTo(target);
                out.println("Renamed " + serviceF + " to " + target);
            }else{
                out.println("Create a WinSW file " + id + ".exe in this directory and run " + id + ".exe install");
                out.println("See https://github.com/kohsuke/winsw/releases");
            }
        }
    }
    
    private void addProfile(final List<String> list) throws IOException {
        final PrintStream out = System.out;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            out.println("Adding profile");
            StringBuilder sb = null;
            if(list!=null && !list.isEmpty()){
                sb=new StringBuilder();
                for(String item: list){
                    if(sb.length()>0)
                        sb.append(",");
                    sb.append(item);
                }
            }
            final String profile = sb!=null?sb.toString():readNext("Profile to add [memoryDB]", out, r, "memoryDB", null);
            final File f2 = new File("application.properties");
            final String profiles = f2.exists()?UpdateProperty.get(f2, "spring.profiles.active"):null;
            final boolean exists2 = profiles != null && profiles.trim().length() > 0;
            if (exists2) {
                if (!Arrays.asList(profiles.split(",")).contains(profile)) {
                    UpdateProperty.alterProp(f2, "spring.profiles.active", profiles + "," + profile);
                    System.out.println("Updated spring.profiles.active in file " + f2.getName());
                }
            } else {
                UpdateProperty.alterProp(f2, "spring.profiles.active", profile);
                System.out.println("Added spring.profiles.active to file " + f2.getName());
            }
        }
    }


}