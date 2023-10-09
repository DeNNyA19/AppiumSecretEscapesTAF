package com.secretescapes.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    public static String readProperty(String property) {
        return getProperties().getProperty(property);
    }

    private static Properties getProperties() {
        if (properties == null) {
            try (InputStream input = DriverManager.class.getClassLoader().getResourceAsStream("config.properties")) {
                properties = new Properties();
                properties.load(input);
                return properties;
            } catch (IOException e) {
                throw new RuntimeException("config.property can't be accessed", e);
            }
        }
        return properties;
    }
}
