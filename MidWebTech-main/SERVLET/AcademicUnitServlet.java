package SERVLET;

import DAO.AcademicUnitDao;
import MODEL.AcademicUnit;
import MODEL.EAcademicUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AcademicUnitServlet")
public class AcademicUnitServlet extends HttpServlet {

    private AcademicUnitDao academicUnitDao;

    @Override
    public void init() throws ServletException {
        academicUnitDao = new AcademicUnitDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If needed, implement handling for GET requests here
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String academicUnitName = request.getParameter("academicUnitName");
            EAcademicUnit academicUnitType = EAcademicUnit.valueOf(request.getParameter("academicUnitType"));
            String parentId = request.getParameter("parentId");

            AcademicUnit parentAcademicUnit = null;
            if (parentId != null && !parentId.isEmpty()) {
                Long parentIdValue = Long.parseLong(parentId);
                parentAcademicUnit = academicUnitDao.createAcademicUnit(parentAcademicUnit);
            }

            AcademicUnit academicUnit = new AcademicUnit(academicUnitName, academicUnitType, parentAcademicUnit);
            academicUnitDao.createAcademicUnit(academicUnit);

            PrintWriter out = response.getWriter();
            out.println("Academic Unit inserted successfully!");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inserting academic unit: " + e.getMessage());
        }
    }

  
}
