/**
    Description

    @author Tom Good
*/
package java112.labs1;
import java.util.*;
import java.io.*;

public class LabSix
{
    // Description
    public void run(String inputFilePath, String outputFilePath)
    {
        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        )
        {
            while (input.ready())
            {
                output.println(input.readLine());
            }
        }
            catch (FileNotFoundException fileNotFound)
            {
                fileNotFound.printStackTrace();
            }
            catch (IOException inputOutputException)
            {
                inputOutputException.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
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
