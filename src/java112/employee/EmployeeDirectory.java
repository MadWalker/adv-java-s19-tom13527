package java112.employee;

import java.util.*;
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
    /**
     * Constructor to connect to properties file
     */
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
    /**
     * This method will add a new record to the Employee table in the database
     */
    public void addNewEmployeeToTable() {
        Employee employeeClass = new Employee();
        Connection connection = connectToDatabase();
        Statement statement = null;
        int rowsAffected = 0;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();

            String insertQueryString = "INSERT INTO employees VALUES (" + employeeClass.getFirstName() + ", "
                    + employeeClass.getLastName() + ", " + employeeClass.getSocialSecurityNumber()
                    + ", " + employeeClass.getDepartment() + ", " + employeeClass.getRoomNumber() + ", "
                    + employeeClass.getPhoneNumber() + ")";
            rowsAffected = statement.executeUpdate(insertQueryString);
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    /**
     * This method will be used to search the employee database
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        return new Search();
    }
    /**
     * This method will search the Employee database by an
     * employee id
     */
    private void searchEmployeeDatabaseById() {
        Search search = new Search();
        Connection connection = connectToDatabase();

    }
}
