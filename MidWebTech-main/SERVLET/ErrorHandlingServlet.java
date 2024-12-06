package SERVLET;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandlingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Determine the type of error
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        // Write error message based on status code
        if (statusCode == 404) {
            response.getWriter().println("<h2>Error 404 - Page Not Found</h2>");
            response.getWriter().println("<p>The requested resource was not found on this server.</p>");
        } else if (statusCode == 500) {
            response.getWriter().println("<h2>Error 500 - Internal Server Error</h2>");
            response.getWriter().println("<p>Sorry, an unexpected error occurred on the server.</p>");
        } else {
            // For other error codes, provide a generic error message
            response.getWriter().println("<h2>Error " + statusCode + "</h2>");
            response.getWriter().println("<p>Sorry, an error occurred on the server.</p>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Error Handling Servlet";
    }
}
