package java112.demos;

import java.util.*;
import java.io.*;

public class PropertiesDemo {

    public static void main(String[] args) {

    }
    public void run() {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/demo.properties"))
    }
}
