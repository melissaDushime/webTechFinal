package SERVLET;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import DAO.UserzDao;
import MODEL.Userr;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String email = request.getParameter("s-email");
        String password = request.getParameter("s-password");
        String role = request.getParameter("role");

        // Check for empty fields
        if (email == null || email.isEmpty() || password == null || password.isEmpty() || role == null || role.isEmpty()) {
            // Redirect back to signup page with an error message
            response.sendRedirect("SignUp.html?error=empty_fields");
            return;
        }

        // Create a new Userr instance
        Userr user = new Userr();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        // Instantiate UserzDao
        UserzDao userDao = new UserzDao();

        // Check if the user already exists
        Userr existingUser = userDao.findByEmail(email);
        if (existingUser != null) {
            // User already exists, redirect back to signup page with an error message
            response.sendRedirect("SignUp.html?error=user_exists");
            return;
        }

        // Create the user
        Userr createdUser = userDao.createUser(user);
        if (createdUser != null) {
            // User created successfully, redirect to login page
            response.sendRedirect("Login.html");
        } else {
            // Failed to create user, redirect back to signup page with an error message
            response.sendRedirect("signup.html?error=signup_failed");
        }
    }
}
