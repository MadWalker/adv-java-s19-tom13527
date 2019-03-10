package java112.project2;

import java.util.*;
import java112.utilities.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "propertiesServlet",
    urlPatterns = { "/propertiesServlet" }
)
public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {
    // Create instance variabes
    Properties properties = new Properties();
    public void init() {
        properties.loadProperties(project2.properties);
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
        out.print("<td>Email</td>");
        out.print("<td>Course</td>");
        out.print("<td>Meet Date and Time</td>");
        out.print("<td>Instructor</td>");
        out.print("<td>Project Description</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>" + properties.getProperty("author") + "</td>");
        out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("<td>" + properties.getProperty("course.meeting.date.and.time") + "</td>");
        out.print("<td>" + properties.getProperty("instructor.name") + "</td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</td>");
        out.print("</table>");
        out.print("<a href='/java112'>Back to home page</a>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
