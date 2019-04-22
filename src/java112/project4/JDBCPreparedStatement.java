package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     Eric Knapp
 *
 */
public class JDBCPreparedStatement {

    public void runSample(String[] arguements) {

        Connection connection = null;
        PreparedStatement statement = null;
        Statement statement2 = null;
        ResultSet resultSet = null; // new
        // load the JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // define connection URL
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
            // create prepared statement objects
            statement = connection.prepareStatement(
                    "insert into employees  values(?,?,?,?,?,?,?)");
            // insert user arguements to prepared statement
            statement.setInt(1,Integer.parseInt(arguements[0]));
            statement.setString(2,arguements[1]);
            statement.setString(3,arguements[2]);
            statement.setString(4,arguements[3]);
            statement.setString(5,arguements[4]);
            statement.setString(6,arguements[5]);
            statement.setString(7,arguements[6]);
            statement.executeUpdate();
            // create displays
            String queryString = "INSERT INTO employees VALUES (" + arguements[0] + ", "
                    + arguements[1] + ", " + arguements[2] + ", " + arguements[3] + ", "
                    + arguements[4] + ", " + arguements[5] + ", " + arguements[5] + ")";
            String queryString2 = "SELECT * FROM employees WHERE emp_id="
                    + Integer.parseInt(arguements[0]);
            System.out.println("queryString: " + queryString);
            // execute statement for display query
            resultSet = statement.executeQuery(queryString2);
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

        JDBCPreparedStatement employees = new JDBCPreparedStatement();

        employees.runSample(args);

        }
        }
