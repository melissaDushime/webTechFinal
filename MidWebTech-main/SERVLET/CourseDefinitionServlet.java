package SERVLET;

import DAO.CourseDefinitionDao;
import MODEL.Course;
import MODEL.CourseDefinition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CourseDefinitionServlet")
public class CourseDefinitionServlet extends HttpServlet {

    private CourseDefinitionDao courseDefinitionDao;

    @Override
    public void init() throws ServletException {
        courseDefinitionDao = new CourseDefinitionDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Insert Course Definition
        String description = request.getParameter("description");
        Long courseId = Long.parseLong(request.getParameter("courseId"));

        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setDescription(description);
        courseDefinition.setCourse(new Course(courseId));

        CourseDefinition createdCourseDefinition = courseDefinitionDao.createCourseDefinition(courseDefinition);

        PrintWriter out = response.getWriter();
        if (createdCourseDefinition != null) {
            out.println("Course definition inserted successfully!");
        } else {
            out.println("Error inserting course definition!");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Course Definition
        Long courseDefinitionId = Long.parseLong(request.getParameter("courseDefinitionId"));

        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setId(courseDefinitionId);

        CourseDefinition deletedCourseDefinition = courseDefinitionDao.DeleteCourseDefinition(courseDefinition);

        PrintWriter out = response.getWriter();
        if (deletedCourseDefinition != null) {
            out.println("Course definition deleted successfully!");
        } else {
            out.println("Error deleting course definition!");
        }
    }
}
