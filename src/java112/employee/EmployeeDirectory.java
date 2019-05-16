package java112.employee;

import java.util.*;
import java.sql.*;
/**
 * This class will hold the methods that will open a connection to the database and
 * perform query statements, returning those statements as variables to be seen as results
 *
 * Created: 4/27/2019
 *
 * @author Tom Good
 */
import java.sql.*;

public class EmployeeDirectory {
    Properties properties;
    /**
     * Constructor to connect to properties file
     *
     * @param properties the properties file object
     */
    public EmployeeDirectory(Properties properties) {}
    /**
     * This method will establish a connection to the employee database\
     *
     * @return Connection connection to database
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
     * This method will be used to search the employee database
     * @return Search search results
     * @param searchTerm the search term
     * @param searchType the search type
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);
        if (search.getSearchType().equals("id")) {
            searchEmployeeDatabaseById(search);
        }
        if (search.getSearchType().equals("lastName")) {
            searchEmployeeDatabaseByLastName(search);
        }
        if (search.getSearchType().equals("firstName")) {
            searchEmployeeDatabaseByFirstName(search);
        }
        return search;
    }
    /**
     * This method will search the Employee database by an
     * employee id
     *
     * @param search instance of the search object
     */
    private void searchEmployeeDatabaseById(Search search) {
        String employeeId = search.getSearchTerm();
        Connection connection = connectToDatabase();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectToDatabase();
            statement = connection.createStatement();
            String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
                    + "WHERE emp_id='" + employeeId + "';";
            resultSet = statement.executeQuery(queryString);
            if (resultSet.isBeforeFirst()) {
                search.setFoundEmployeesBoolean(true);
            } else {
                search.setFoundEmployeesBoolean(false);
            }
            if (search.isFoundEmployeesBoolean()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(resultSet.getString("emp_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setSocialSecurityNumber(resultSet.getString("ssn"));
                    employee.setDepartment(resultSet.getString("dept"));
                    employee.setRoomNumber(resultSet.getString("room"));
                    employee.setPhoneNumber(resultSet.getString("phone"));
                    search.addFoundEmployee(employee);
                }
            }
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
     * This method will search the Employee database by an
     * employee last name
     *
     * @param search instance of the search object
     */
    private void searchEmployeeDatabaseByLastName(Search search) {
        String lastName = search.getSearchTerm();
        Connection connection = connectToDatabase();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectToDatabase();
            statement = connection.createStatement();

            String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
                    + "WHERE last_name='" + lastName + "'";

            System.out.println("calling the database with " + queryString);
            resultSet = statement.executeQuery(queryString);
            if (resultSet.isBeforeFirst()) {
                search.setFoundEmployeesBoolean(true);
            } else {
                search.setFoundEmployeesBoolean(false);
            }
            System.out.println(search.isFoundEmployeesBoolean());
            if (search.isFoundEmployeesBoolean()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    System.out.println("EMPLOYEE ID:" + resultSet.getString("emp_id"));
                    employee.setEmployeeId(resultSet.getString("emp_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setSocialSecurityNumber(resultSet.getString("ssn"));
                    employee.setDepartment(resultSet.getString("dept"));
                    employee.setRoomNumber(resultSet.getString("room"));
                    employee.setPhoneNumber(resultSet.getString("phone"));
                    search.addFoundEmployee(employee);
                }
            }
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
     * This method will search the Employee database by an
     * employee first name
     *
     * @param search instance of the search object
     */
    private void searchEmployeeDatabaseByFirstName(Search search) {
        String firstName = search.getSearchTerm();
        Connection connection = connectToDatabase();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectToDatabase();
            statement = connection.createStatement();
            String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone FROM employees "
                    + "WHERE first_name='" + firstName + "'";
            resultSet = statement.executeQuery(queryString);
            if (resultSet.isBeforeFirst()) {
                search.setFoundEmployeesBoolean(true);
            } else {
                search.setFoundEmployeesBoolean(false);
            }
            if (search.isFoundEmployeesBoolean()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(resultSet.getString("emp_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setSocialSecurityNumber(resultSet.getString("ssn"));
                    employee.setDepartment(resultSet.getString("dept"));
                    employee.setRoomNumber(resultSet.getString("room"));
                    employee.setPhoneNumber(resultSet.getString("phone"));
                    search.addFoundEmployee(employee);
                }
            }
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
}
