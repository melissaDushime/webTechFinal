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

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Student
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student(firstName, lastName, dateOfBirth);
        Student createdStudent = studentDao.createStudent(student);

        PrintWriter out = response.getWriter();
        if (createdStudent != null) {
            out.println("Student inserted successfully!");
        } else {
            out.println("Error inserting student!");
        }
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Student
        Long studentId = Long.parseLong(request.getParameter("studentId"));

        Student student = new Student();
        student.setStudentId(studentId);
        boolean deleted = studentDao.deleteStudent(student);

        PrintWriter out = response.getWriter();
        if (deleted) {
            out.println("Student deleted successfully!");
        } else {
            out.println("Error deleting student!");
        }
    }
}
