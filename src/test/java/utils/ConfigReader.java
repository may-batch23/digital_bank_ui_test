package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private  static Properties properties;

    static {
        String filePath = "src/test/resources/properties/digitalbankui.properties";

        FileInputStream input = null;

        try {
            input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);
            input.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }
        finally {
            try {
                assert input != null;
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getPropertiesValue(String key) {


        return properties.getProperty(key);
    }
}


