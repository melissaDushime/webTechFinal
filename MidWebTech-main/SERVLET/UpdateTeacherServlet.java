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

@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {

    private TeacherDao teacherDao;
    private boolean updated;

    @Override
    public void init() throws ServletException {
        teacherDao = new TeacherDao();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update Teacher
        Long teacherId = Long.parseLong(request.getParameter("teacherId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String qualification = request.getParameter("qualification");
        Long courseId = Long.parseLong(request.getParameter("courseId"));

        // Create Teacher object
        Teacher teacher = new Teacher(teacherId, firstName, lastName, EQualification.valueOf(qualification), new Course(courseId));

        // Perform update
         Teacher updatedTeacher = teacherDao.updateTeacher(teacher);
        // Send response to client
        PrintWriter out = response.getWriter();
        if (updated) {
            out.println("Teacher updated successfully!");
        } else {
            out.println("Error updating teacher!");
        }
    }
}
