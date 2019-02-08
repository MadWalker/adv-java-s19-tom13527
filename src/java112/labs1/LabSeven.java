/**


    @author Tom Good
*/

package java112.labs1;
import java.io.*;
import java.util.*;

public class LabSeven
{
    public ArrayList<String> listOfStrings;

    public void run()
    {
        ArrayList listOfStrings = new ArrayList();

        listOfStrings.add("one");
        listOfStrings.add("two");
        listOfStrings.add("three");
        listOfStrings.add("four");
        listOfStrings.add("five");
        listOfStrings.add("six");
        listOfStrings.add("seven");
        listOfStrings.add("eight");
        listOfStrings.add("nine");
        listOfStrings.add("ten");

        //writeListToOutputFile(outputName);
    }

    public void writeListToOutputFile(String outputName)
    {
        PrintWriter writer = null;
        // Need to check permissions to write and such
        try
        {
            // Instantiate file and write to it
            // * WILL WRITE BRAND NEW FILE EVERY TIME
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputName)));
            //writer.println(message);
        }
        // Catch your permission to wrtie file
        catch (IOException iOException)
        {
            System.out.println("There was a problem writing the file.");
            iOException.printStackTrace();
        }
        // Catch general exceptions
        catch (Exception exception)
        {
            System.out.println("There was a problem...");
            exception.printStackTrace();
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }
    }

    /**
        Main method

        @param args command line arguements
    */
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Please enter one argument on the command line, "
            + "an output file name");
        }
        else
        {
            LabSeven labSeven = new LabSeven();
            labSeven.run();
        }
    }
}
