package java112.labs1;
import java.io.*;

public class LabFour
{

    public void run(String input)
    {
        BufferedReader inputReader = null;

        try
        {
            inputReader = new BufferedReader(new FileReader(input));

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
    }

    public static void main(String[] args)
    {
        LabFour labFour = new LabFour();

        if (args.length != 1)
        {
            System.out.println("Please enter one argument on the command line");
        }
        else
        {
            labFour.run(args[0]);
        }
    }

}
