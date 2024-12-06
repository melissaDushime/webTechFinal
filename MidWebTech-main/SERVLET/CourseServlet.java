package SERVLET;

import DAO.CourseDao;
import MODEL.Course;
import MODEL.AcademicUnit;
import MODEL.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {

    private CourseDao courseDao;

    @Override
    public void init() throws ServletException {
        courseDao = new CourseDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Course
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        Long semesterId = Long.parseLong(request.getParameter("semesterId"));
        Long departmentId = Long.parseLong(request.getParameter("departmentId"));

        // Create Course object
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setSemester(new Semester(semesterId));
        course.setDepartment(new AcademicUnit(departmentId));

        // Perform insertion
        Course createdCourse = courseDao.createCourse(course);

        // Send response to client
        PrintWriter out = response.getWriter();
        if (createdCourse != null) {
            out.println("Course inserted successfully!");
        } else {
            out.println("Error inserting course!");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Course
        Long courseId = Long.parseLong(request.getParameter("courseId"));

        // Create Course object
        Course course = new Course();
        course.setId(courseId);

        // Perform deletion
        Course deletedCourse = courseDao.DeleteCourse(course);

        // Send response to client
        PrintWriter out = response.getWriter();
        if (deletedCourse != null) {
            out.println("Course deleted successfully!");
        } else {
            out.println("Error deleting course!");
        }
    }
}
