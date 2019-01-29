package java112.labs1;

public class MysteryClassOne
{
    public int mysteryMethodOne()
    {
        return 1;
    }

    public static void main(String[] args)
    {
        MysteryClassOne lab = new MysteryClassOne();
        System.out.println("The method returned " + lab.mysteryMethodOne());
    }
}
