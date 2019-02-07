/**
    Description

    @author Tom Good
*/
package java112.labs1;
import java.io.*;

public class LabSix
{

    /**
        Description

        @param args command line arguements
    */
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Please enter two arguements on the command line, "
            + "an input file name and an output file name");
        }
        else
        {
            LabSix labSix = new LabSix();

            labSix.run(args[0], args[1]);
        }
    }
}
