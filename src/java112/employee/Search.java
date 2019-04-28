package java112.employee;

import java.util.List;

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
    //private List<Employee> results;
    private String foundEmployeesBoolean;
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
     *
    public List<String> getResults() {
        return results;
    }*/
    /**
     * Sets results.
     *
     * @param results the results
     *
    public void setResults(List<String> results) {
        this.results = results;
    }*/
    /**
     * Gets found employees boolean.
     *
     * @return the found employees boolean
     */
    public String getFoundEmployeesBoolean() {
        return foundEmployeesBoolean;
    }
    /**
     * Sets found employees boolean.
     *
     * @param foundEmployeesBoolean the found employees boolean
     */
    public void setFoundEmployeesBoolean(String foundEmployeesBoolean) {
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
     * @param employee
     *
    public void addFoundEmployee(Employee employee) {
        results = new ArrayList<Employee>();
    }*/
}
