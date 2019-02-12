/**
    This program will create a tree set and output it to a new file. Output will
    be in order from first letter of alphabet to last, no repeated strings.

    @author Tom Good
*/
package java112.labs1;
import java.io.*;
import java.util.*;

public class LabEight
{
    // Create instance variable
    public Set<String> sortedSetOfStrings;

    /**
        Create the set

        @param outputFilePath
    */
    public void run(String outputFilePath)
    {
        sortedSetOfStrings = new TreeSet();

        sortedSetOfStrings.add("one");
        sortedSetOfStrings.add("one");
        sortedSetOfStrings.add("five");
        sortedSetOfStrings.add("two");
        sortedSetOfStrings.add("four");
        sortedSetOfStrings.add("two");
        sortedSetOfStrings.add("three");
        sortedSetOfStrings.add("three");
        sortedSetOfStrings.add("four");
        sortedSetOfStrings.add("three");

        this.writeSetToOutputFile(outputFilePath);
    }

    public void writeSetToOutputFile(String outputName)
    {
        PrintWriter writer = null;
        // Need to check permissions to write and such
        try
        {
            // Instantiate file and write to it
            // * WILL WRITE BRAND NEW FILE EVERY TIME
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputName)));

            for (String set : sortedSetOfStrings)
                writer.println(set);
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
        Main method of lab eight class

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
            LabEight labEight = new LabEight();
            labEight.run(args[0]);
        }
    }
}
