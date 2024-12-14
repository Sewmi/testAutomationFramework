package com.guru99.demo.utitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {

    private Properties getDataFromPropertyFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName+".properties").getFile());
        FileInputStream fileInput = null;
        try{
            fileInput = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try{
            properties.load(fileInput);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public String getProperty(String fileName, String key){
        return getDataFromPropertyFile(fileName).getProperty(key);
    }

    public void setProperty(String fileName, String key, String value){
        getDataFromPropertyFile(fileName).setProperty(key,value);
    }

}
