package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  creates students puts them in lists forwards to jsp display
 *
 *@author    eknapp
 */
@WebServlet(
        name = "studentServlet",
        urlPatterns = { "/createStudents" }
)
public class CreateStudentServlet extends HttpServlet {

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
        Student student1 = new Student("Tom", "Good", 1);
        Student student2 = new Student("Mot", "Bad", 2);
        Student student3 = new Student("Mom", "Doog", 3);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        request.setAttribute("listOfStudents", studentList);
        String url = "/displayStudents.jsp";
        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

