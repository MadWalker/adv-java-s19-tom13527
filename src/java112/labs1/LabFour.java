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

            while (inputReader.ready())
            {
                // Read each line in here
                line = inputReader.readLine();

                // Now Process the line in some way
                // This will usually be in another method that we
                // pass the line to
            }
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                if (inputReader != null)
                {
                    inputReader.close();
                }
            }
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
