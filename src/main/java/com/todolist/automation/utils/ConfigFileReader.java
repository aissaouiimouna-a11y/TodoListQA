package com.todolist.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String CONFIG_PATH =
        "src/test/resources/configs/configFile.properties";

    public ConfigFileReader() {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(
                "Fichier de configuration introuvable : " + CONFIG_PATH
            );
        }
    }

    public String getProperties(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(
                "Propriété introuvable : " + key
            );
        }
        return value;
    }
}