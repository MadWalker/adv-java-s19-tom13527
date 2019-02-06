/**


    @author Tom Good
*/

package java112.demos;
import java.io.*;

public class LabFive
{

    public void run(String outputName, String message)
    {
        PrintWriter writer = null;
        // Need to check permissions to write and such
        try
        {
            // Instantiate file and write to it
            // * WILL WRITE BRAND NEW FILE EVERY TIME
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputName)));
            writer.println(message);
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
        Check to make sure there are two command line arguements, then run
        the run method

        @param args command line arguements
    */
    public static void main(String[] args)
    {
        LabFive labFive = new labFive();

        if (args.length != 2)
        {
            System.out.println("Please enter two arguments on the command line,
                    a file name and a message")
        }
        else
        {
            labFive.run(args[0,1]);
        }
    }

}
