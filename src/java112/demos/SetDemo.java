package java112.demos;

import java.util.*;

/**
    Demonstrate the Set Interface and Hashset concrete class

    @author Tom Good
*/

public class SetDemo
{

    /**
        Create set, add strings, display set
    */
    public void run()
    {
        Set<String> set = new HashSet();

        set.add("one");
        set.add("one");
        set.add("one");
        set.add("abc");
        set.add("1234");
        set.add("three");
        set.add("three");
        set.add("one");

        // Remember to use ofter to debug
        System.out.println(set);

        // should display as "[123, abc, one, three]

        // enhanced for loop
        // each loop through set, give element variable
        for (String element : set)
        {
            System.out.println("the element is " + element);

            // should display as "the element is: 123, the element is: abc, etc..."
        }
    }

    /**
        instantiate Demo class and start running

        @param args command line arguement (not used in this case)
    */
    public static void main(String[] args)
    {
        SetDemo demo = new SetDemo()
        {

        }
    }
}
