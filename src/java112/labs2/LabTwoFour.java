package java112.labs2;
import java.util.*;
import java.io.*;

public class LabTwoFour {
    public static void main(String[] args) {
        LabTwoFour lab24 = new LabTwoFour();
        lab24.run();
    }
    Map<String, Integer> map;

    public void run() {
        map = new HashMap<String, Integer>();

        map.put("One", 1);
        map.put("Two", 2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
        if (map.containsKey("Three")) {
            System.out.println("Key three was found");
        } else {
            System.out.println("Error, map does not contain key three");
        }
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("Two", 2);
        map.put("One", 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
