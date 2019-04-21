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

            // display statement
            System.out.println("queryString: " + queryString);
            // execute statement
            rowsAffected = statement.executeUpdate(queryString);

            //System.out.println();
            // display results
            /**while (rowsAffected.next()) {
                firstName = rowsAffected.getString("first_name");
                lastName = rowsAffected.getString("last_name");
                ssn = rowsAffected.getString("ssn");
                department = rowsAffected.getString("dept");
                room = rowsAffected.getString("room");
                phone = rowsAffected.getString("phone");
                System.out.println(" Row: " + employeeId + " "
                            + firstName + " " + lastName + " " + ssn + " "
                            + department + " " + room + " " + phone);
            }*/
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                /**if (rowsAffected != 0) {
                    rowsAffected.close();
                }*/
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
