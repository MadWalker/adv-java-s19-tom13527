/**
    The brains of this program
*/
import java.util.*;

public class Controller
{
    ArrayList<IRobot> robots = null;

    public void start()
    {
        for (IRobot robot : robots)
        {
            robot.startup();
        }
    }

    public void loadUpAllRobots()
    {
        robots.add(new AutomatedSawRobot());
    }
}
