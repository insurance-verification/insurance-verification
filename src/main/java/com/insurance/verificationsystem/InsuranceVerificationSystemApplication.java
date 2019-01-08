package com.insurance.verificationsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.ehcache.Cache;
import org.ehcache.Cache.Entry;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.insurance.verificationsystem.config.UpdateProperty;

@SpringBootApplication
public class InsuranceVerificationSystemApplication {

    public static void main(final String[] args) throws Exception {
//        if (1 == 1) {
//            System.out.println(Timestamp.valueOf(LocalDateTime.now().format(formatter)));
//            return;
//        }
        System.setProperty("net.sf.ehcache.enableShutdownHook", "true");
        try {
            SpringApplication.run(InsuranceVerificationSystemApplication.class, args);
        } catch (final Throwable t) {
            t.printStackTrace();
        }
    }

}
