/**
    Class: First112Servlet
    Author: Tom Good
    Create date: 3/10/2019
*/
package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This servlet will display some information about myself, the author, to the webpage
 *
 *@author    Tom Good
 */
@WebServlet(
    name = "firstServlet",
    urlPatterns = { "/firstServlet" }
)
public class First112Servlet extends HttpServlet {
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
        out.print("<h1>Tom Good</h1>");
        out.print("<h2>Advanced Java Spring 2019</h2>");
        out.print("<img src='images/image6.jpg' alt='Programmer photo'>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}
