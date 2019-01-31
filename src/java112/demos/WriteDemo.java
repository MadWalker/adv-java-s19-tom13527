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
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
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
    }
}
