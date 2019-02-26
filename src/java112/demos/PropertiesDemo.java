package java112.demos;

import java.util.*;
import java.io.*;

public class PropertiesDemo {

    public static void main(String[] args) {
        PropertiesDemo demo = new PropertiesDemo();
        demo.run();
    }
    public void run() {
        Properties properties = new Properties();
        try {
            // getResourceAsStream will search path for passed in resource
            properties.load(this.getClass().getResourceAsStream("/demo.properties"));
        } catch (IOException ioException) {
            System.out.println("problem read properties files");
            ioException.printStackTrace();
        } catch (Exception Exception) {
            System.out.println("problem");
            Exception.printStackTrace();
        }

        // display author property
        System.out.println("Author property is: " + properties.getProperty("author"));

        // get all properties
        Set<String> propertyNames = properties.stringPropertyNames();
        // display Properties
        System.out.println("set of property names: " + propertyNames);
        System.out.println("");

        // display the key value pairs (property name and its corresponding value)
        for (String key : propertyNames) {
            System.out.println("The key is: " + key + "the value is: " + properties.getProperty(key));
        }
    }
}
