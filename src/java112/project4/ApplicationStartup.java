package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 * This servlet will take care of some initializing for the project 4 program, like
 * adding the employee directory and properties files to attribute
 *
 * @author Tom Good
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    public void init() {
        ServletContext servletContext = getServletContext();
        Properties properties = new Properties();
        properties = loadProperties("/project4.properties");
        servletContext.setAttribute("project4Properties", properties);
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        servletContext.setAttribute("employeeDirectoryStartup", employeeDirectory);
    }
}
