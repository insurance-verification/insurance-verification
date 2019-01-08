package com.insurance.verificationsystem.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UpdateProperty {

    public static String get(final File f, final String key) throws IOException {
        try (final FileInputStream in = new FileInputStream(f)) {
            final Properties props = new Properties();
            props.load(in);
            return props.getProperty(key);
        }
    }

    public static void alterProp(final File f, final String propKey, final String propVal) throws IOException {
        final Properties props = new Properties();
        try (final FileInputStream in = new FileInputStream(f)) {
            props.load(in);
        }catch(FileNotFoundException e){}
        try (final FileOutputStream out = new FileOutputStream(f)) {
            props.setProperty(propKey, propVal);
            props.store(out, null);
        }

    }
}