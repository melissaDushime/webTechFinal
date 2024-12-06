package SERVLET;

import MODEL.Semester;
import DAO.SemesterDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/semester")
public class SemesterServlet extends HttpServlet {

    private SemesterDAO semesterDAO;

    public void init() {
        semesterDAO = new SemesterDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createSemester(request, response);
                break;
            case "delete":
                deleteSemester(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "edit":
                // Handle edit functionality if needed
                break;
            case "list":
            default:
                listSemesters(request, response);
                break;
        }
    }

    private void createSemester(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String semesterName = request.getParameter("semesterName");
        String startingDateStr = request.getParameter("startingDate");
        String endDateStr = request.getParameter("endDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startingDate;
        Date endDate;

        try {
            startingDate = dateFormat.parse(startingDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        Semester semester = new Semester(semesterName, startingDate, endDate);
        semesterDAO.saveOrUpdateSemester(semester);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String semesterIdStr = request.getParameter("semesterId");

        if (semesterIdStr != null) {
            Long semesterId = Long.parseLong(semesterIdStr);
            semesterDAO.deleteSemester(semesterId);
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void listSemesters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Semester> semesters = semesterDAO.getAllSemesters();
        request.setAttribute("semesters", semesters);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
