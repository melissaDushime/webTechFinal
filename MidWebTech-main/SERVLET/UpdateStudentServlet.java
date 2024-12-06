package SERVLET;

import DAO.StudentDao;
import MODEL.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Student
        Long studentId = Long.parseLong(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student(studentId, firstName, lastName, dateOfBirth);
        boolean updated = studentDao.updateStudent(student);

        PrintWriter out = response.getWriter();
        if (updated) {
            out.println("Student updated successfully!");
        } else {
            out.println("Error updating student!");
        }
    }
}
