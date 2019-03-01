package java112.labs2;
import java.io.*;
import java.util.*;

public class LabThree {
    public static void main(String[] args) {
        LabThree lab3 = new LabThree();
        lab3.run(args[0]);
    }
    Properties properties;

    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    public void run(String propertiesFilePath) {
        loadProperties(propertiesFilePath);
        System.out.println("Property is: " + properties.getProperty("author"));
    }
}
