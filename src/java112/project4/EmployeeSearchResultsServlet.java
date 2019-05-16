package java112.project4;

import java112.employee.Employee;
import java112.employee.EmployeeDirectory;
import java112.employee.Search;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This servlet will generate the search type and search terms, access the appropriate entries
 *  from the database, then forward them results to the display jsp
 *
 *@author    Tom Good
 */
@WebServlet(
        name = "employeeSearchResultsServlet",
        urlPatterns = { "/searchEmployeesResults" }
)
public class EmployeeSearchResultsServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get servlet context
        ServletContext context = getServletContext();
        // Get the attribute for the EmployeeDirectory class
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDirectoryStartup");
        // Get both of the search terms from the search jsp form
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        Search search = employeeDirectory.searchEmployeeDatabase(searchTerm, searchType);

        HttpSession session = request.getSession();
        session.setAttribute("employeeSearchResults", search.getResults());

        HttpSession session2 = request.getSession();
        System.out.println(search.isFoundEmployeesBoolean());
        session2.setAttribute("foundBoolean", search.isFoundEmployeesBoolean());
        String url = "/employeeSearchResults.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

