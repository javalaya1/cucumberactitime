package com.envision.actitime.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyFileReader {

    private static Map<Object, Object> all_config_and_properties_data = new HashMap<Object, Object>();


    static {
        if (all_config_and_properties_data.size() == 0) {
            readProperties();
        }
    }


    private static void readProperties() {
        File file_or_folder = new File("actitime_testdata");
        if (file_or_folder.isDirectory()) {
            List<File> allFilesAndFolder = Arrays.asList(file_or_folder.listFiles());
            for (File eachFileAndFolder : allFilesAndFolder) {
                if (eachFileAndFolder.getName().endsWith(".properties")) {
                    try {
                        FileInputStream fis = new FileInputStream(eachFileAndFolder);
                        Properties p = new Properties();
                        p.load(fis);
                        all_config_and_properties_data.putAll(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }

    public static String getPropertyValue(String propertyName) {

        return all_config_and_properties_data.get(propertyName).toString();
    }


}
