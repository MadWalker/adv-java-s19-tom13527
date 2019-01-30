package java112.labs1;

public class LabThree
{

    public void run(String input)
    {
            System.out.println("input: test");
    }

    public static void main(String[] args)
    {
        LabThree output = new LabThree();

        if (args.length != 1)
        {
            System.out.println("Please enter one argument on the command line");
        }
        else
        {
            output.run("some string");
        }
    }
}
