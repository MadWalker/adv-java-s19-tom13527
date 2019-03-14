/**
    Class: Project2PropertiesServlet
    Author: Tom Good
    Create date: 3/10/2019
*/
package java112.project2;

import java.util.*;
import java112.utilities.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This servlet will recieve a properties file with information about the
    project and display that information to the web page within a table
 *
 *  @author    Tom Good
 */
@WebServlet(
    name = "propertiesServlet",
    urlPatterns = { "/propertiesServlet" }
)
public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {
    // Create instance variabes
    private Properties properties;
    // Opens in properties file
    public void init() {
        properties = loadProperties("/project2.properties");
    }
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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Tom Good</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Project 2 Properties Servlet</h1>");
        out.print("<table>");
        out.print("<tr>");
        out.print("<td>Author</td>");
        out.print("<td>" + properties.getProperty("author") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Email</td>");
        out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Course</td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Meet Date and Time</td>");
        out.print("<td>" + properties.getProperty("course.meeting.date.and.time") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Instructor</td>");
        out.print("<td>" + properties.getProperty("instructor.name") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Project Description</td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<a href='/java112'>Back to home page</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
