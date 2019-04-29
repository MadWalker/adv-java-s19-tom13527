package java112.employee;
/**
 * This class will
 *
 * Created: 4/27/2019
 *
 * @author Tom Good
 */
import java.sql.*;
import java.util.*;

public class EmployeeDirectory {
    private Properties properties;
    public EmployeeDirectory(Properties properties) {}

    /**
     * This method will establish a connection to the employee database
     */
    private Connection connectToDatabase() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }
}
