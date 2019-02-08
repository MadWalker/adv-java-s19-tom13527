/**
    Description

    @author Tom Good
*/
package java112.labs1;
import java.io.*;

public class LabSix
{
    // Description
    public void run(String inputFilePath, String outputFilePath)
    {
        /**
            ***** Input file path
        */

        BufferedReader inputReader = null;
        try
        {
            inputReader = new BufferedReader(new FileReader(inputFilePath));

            // Code to process the input file
            // Declare a String variable to hold the current line

            String line = null;

            // Read the file
            while (inputReader.ready())
            {
                // Read each line in here
                line = inputReader.readLine();

                // Now Process the line in some way
                // This will usually be in another method that we
                // pass the line to
                System.out.println(line);
            }
        }
        // Creating an exception object for if the file is not found
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.printStackTrace();
        }
        // Creating an exception if file cannot be read
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        // Close the resource back up
        finally
        {
            try
            {
                if (inputReader != null)
                {
                    inputReader.close();
                }
            }
            // Catches everything else if the first 2 expceptions are not caught
            // File was found and read, but something else happened
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        /**
            **** Output file path
        */

        PrintWriter writer = null;
        // Need to check permissions to write and such
        try
        {
            // Instantiate file and write to it
            // * WILL WRITE BRAND NEW FILE EVERY TIME
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));
            writer.println(inputFilePath);
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
        Description

        @param args command line arguements
    */
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Please enter two arguments on the command line, "
            + "an input file name and an output file name");
        }
        else
        {
            LabSix labSix = new LabSix();

            labSix.run(args[0], args[1]);
        }
    }
}
