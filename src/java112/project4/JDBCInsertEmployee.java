package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     Eric Knapp
 *
 */
public class JDBCInsertEmployee {

    public void runSample(String[] arguements) {

        Connection connection = null;
        Statement statement = null;
        int rowsAffected = 0;
        ResultSet resultSet = null; // new
        // load the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // define connection URL
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
            // create statement object
            statement = connection.createStatement();
            // sql statement creation
            int employeeId = Integer.parseInt(arguements[0]);
            String firstName = "'" + arguements[1] + "'";
            String lastName = "'" + arguements[2] + "'";
            String ssn = "'" + arguements[3] + "'";
            String department = "'" + arguements[4] + "'";
            String room = "'" + arguements[5] + "'";
            String phone = "'" + arguements[6] + "'";
            String queryString = "INSERT INTO employees VALUES (" + employeeId + ", " + firstName + ", "
                    + lastName + ", " + ssn + ", " + department + ", " + room + ", "
                    + phone + ")";
            // create display string
            String queryString2 = "SELECT * FROM employees WHERE emp_id="
                    + Integer.parseInt(arguements[0]);
            // display statement
            System.out.println("queryString: " + queryString);
            // execute statements
            rowsAffected = statement.executeUpdate(queryString);
            resultSet = statement.executeQuery(queryString2);
            System.out.println();
            // display results
            while (resultSet.next()) {
                String employeeIdDisplay = resultSet.getString("emp_id");
                String firstNameDisplay = resultSet.getString("first_name");
                String lastNameDisplay = resultSet.getString("last_name");
                String ssnDisplay = resultSet.getString("ssn");
                String departmentDisplay = resultSet.getString("dept");
                String roomDisplay = resultSet.getString("room");
                String phoneDisplay = resultSet.getString("phone");
                System.out.println("Inserted row: " + employeeIdDisplay + " " + firstNameDisplay
                        + " " + lastNameDisplay + " " + ssnDisplay + " " + departmentDisplay
                        + " " + roomDisplay + " " + phoneDisplay);
            }
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {

        JDBCInsertEmployee employees = new JDBCInsertEmployee();

        employees.runSample(args);

    }
}
