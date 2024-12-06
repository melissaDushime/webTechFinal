package SERVLET;

import DAO.TeacherDao;
import MODEL.Course;
import MODEL.EQualification;
import MODEL.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {

    private TeacherDao teacherDao;

    @Override
    public void init() throws ServletException {
        teacherDao = new TeacherDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Teacher
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String qualification = request.getParameter("qualification");
        Long courseId = Long.parseLong(request.getParameter("courseId"));

        // Create Teacher object
        Teacher teacher = new Teacher(firstName, lastName, EQualification.valueOf(qualification), new Course(courseId));

        // Perform insertion
        Teacher createdTeacher = teacherDao.createTeacher(teacher);

        // Send response to client
        PrintWriter out = response.getWriter();
        if (createdTeacher != null) {
            out.println("Teacher inserted successfully!");
        } else {
            out.println("Error inserting teacher!");
        }
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Teacher
        Long teacherId = Long.parseLong(request.getParameter("teacherId"));

        // Create Teacher object
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);

        // Perform deletion
        Teacher deletedTeacher = teacherDao.DeleteTeacher(teacher);

        // Send response to client
        PrintWriter out = response.getWriter();
        if (deletedTeacher != null) {
            out.println("Teacher deleted successfully!");
        } else {
            out.println("Error deleting teacher!");
        }
    }
}
