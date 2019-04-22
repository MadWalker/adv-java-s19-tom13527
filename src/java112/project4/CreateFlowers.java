package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Demonstrating use of jstl
 *
 *@author    tgood
 */
@WebServlet(
    name = "jstlFlowerDemo",
    urlPatterns = { "/createFlowers" }
)
public class CreateFlowers extends HttpServlet {
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

    HttpSession  session  = request.getSession();

    List flowers = new ArrayList();
    flowers.add("Tulip");
    flowers.add("Rose");
    flowers.add("Daffodil");
    flowers.add("Petunia");
    flowers.add("Lily");

    session.setAttribute("flowersList", flowers);
    }
}
