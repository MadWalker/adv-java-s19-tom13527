package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  lab 2 unit 4 servlet
 *
 *@author    eknapp
 */
@WebServlet(
        name = "jstlServlet",
        urlPatterns = { "/jstlServlet" }
)
public class JSTLLab1Servlet extends HttpServlet {

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
        List<String> someList = new ArrayList<String>();
        someList.add("blah");
        someList.add("beep");
        someList.add("boop");
        request.setAttribute("listOfBops", someList);
        String url = "/jstl-lab2.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

