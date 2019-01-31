package java112.labs1;

public class LabFour
{
    public static void main(String[] args)
    {
        LabFour labFour = new LabFour();

        if (args.length != 1)
        {
            System.out.println("Please enter one argument on the command line");
            break;
        }
        else
        {
            labFour.run();
        }
    }
}
