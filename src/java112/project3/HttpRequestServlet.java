package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.lang.*;

/**


    @author Tom Good
 */
@WebServlet(
    name = "requestServlet",
    urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData requestBean = new HttpRequestData();

        requestBean.setRemoteComputerName(request.getRemoteHost());
        requestBean.setAddressOfRemoteComputer(request.getRemoteAddr());
        requestBean.setHttpMethodOfRequest(request.getMethod());
        requestBean.setRequestURI(request.getRequestURI());
        requestBean.setRequestURL(request.getRequestURL().toString());
        requestBean.setProtocolOfRequest(request.getProtocol());
        requestBean.setServerName(request.getServerName());
        requestBean.setServerPortNumber(request.getServerPort());
        //requestBean.setLocaleOfServer(request.getLocale());
        requestBean.setQueryString(request.getQueryString());
        //requestBean.setQueryParameter(request.getQueryParameter());
        //requestBean.setRequestHeader(request.getRequestHeader());


        request.setAttribute("myRequestBean", requestBean);

        String url = "/project3HttpRequest.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
