package java112.employee;

import java.util.*;

/**
 * This class will hold the search type and term, the results, and boolean value for no
 * found matches when searching through the employee database
 *
 * Created: 4/27/2019
 *
 * @author Tom Good
 */

public class Search {
    private String searchType;
    private String searchTerm;
    private List<Employee> results = new ArrayList<>();
    private boolean foundEmployeesBoolean;
    /**
     * Gets search type.
     *
     * @return the search type
     */
    public String getSearchType() {
        return searchType;
    }
    /**
     * Sets search type.
     *
     * @param searchType the search type
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    /**
     * Gets search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }
    /**
     * Sets search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Employee> getResults() {
        return results;
    }
    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<Employee> results) {
        this.results = results;
    }
    /**
     * Gets found employees boolean.
     *
     * @return the found employees boolean
     */
    public boolean isFoundEmployeesBoolean() {
        return this.foundEmployeesBoolean;
    }
    /**
     * Sets found employees boolean.
     *
     * @param foundEmployeesBoolean the found employees boolean
     */
    public void setFoundEmployeesBoolean(boolean foundEmployeesBoolean) {
        this.foundEmployeesBoolean = foundEmployeesBoolean;
    }
    /**
     * Empty constructor
     */
    public Search(){}
    /**
     * This method will add the employee object to the list
     * of found employee objects
     *
     * @param employee instances of found employees
     */
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }
}
