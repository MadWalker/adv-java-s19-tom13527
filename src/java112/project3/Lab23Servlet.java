package java112.project3;

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
    name = "Lab2-3",
    urlPatterns = { "/lab2-3" }
)
public class Lab23Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>Lab 2-3</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<ul><li>Locale: " + request.getLocale() + "</li>");
        out.print("<li>Context Path: " + request.getContextPath() + "</li>");
        out.print("<li>Local Name of Server: " + request.getServerName() + "</li>");
        out.print("<li>Scheme: " + request.getScheme() + "</li>");
        out.print("</ul>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
