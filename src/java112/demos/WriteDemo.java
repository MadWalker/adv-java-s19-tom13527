/**
    Demonstrate writing a file

    @author Tom Good
*/

package java112.demos;
import java.io.*;

public class WriteDemo
{
    /**
        Create af file, write to the file

        @param args command line args
    */
    public static void main(String[] args)
    {
        PrintWriter writer = null;
        // Need to check permissions to write and such
        try
        {
            // Instantiate file and write to it
            // * WILL WRITE BRAND NEW FILE EVERY TIME
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            writer.println("A first line in new file");
            writer.println("A second line in new file");
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
}
