package java112.project4;

import java112.employee.EmployeeDirectory;

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
        ServletContext context = getServletContext();
        context.getAttribute("employeeDirectoryStartup");
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        HttpSession session = request.getSession();
        session.setAttribute("attribute", object);
        String url = "/employeeSearchResults.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

