package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    public void init() {
        ServletContext sc = getServletContext();
        Properties properties = new Properties();
        properties = loadProperties("/project4.properties");
        sc.setAttribute("project4Properties", properties);
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        sc.setAttribute("employeeDirectoryStartup", employeeDirectory);
    }
}
