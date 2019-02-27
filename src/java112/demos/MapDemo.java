package java112.demos;

import java.util.*;
import java.io.*;

public class MapDemo {
    public static void main(String[] args) {
        MapDemo demo = new MapDemo();
        demo.run();
    }
    public void run() {
        // Map must not be primitive type
        Map<Integer, String> myMap = new HashMap<Integer, String>();

        // add some key/values
        myMap.put(2, "two");
        myMap.put(1, "one");
        myMap.put(10, "ten");
        System.out.println(myMap);

        // for each "thing" in my "collection" do "something"
        // entrySet returns a set of map.entry (which is a key/value pair)
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
