<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="MODEL.Course, MODEL.Semester, MODEL.AcademicUnit" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin-bottom: 20px;
        }
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Course Management</h2>

    <form action="course" method="post">
        <input type="hidden" name="action" value="save">
        <label for="code">Course Code:</label>
        <input type="text" id="code" name="code" required>
        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="semesterId">Semester ID:</label>
        <input type="text" id="semesterId" name="semesterId" required>
        <label for="academicUnitId">Academic Unit ID:</label>
        <input type="text" id="academicUnitId" name="academicUnitId" required>
        <input type="submit" value="Add Course">
    </form>

    <table>
        <tr>
            <th>Course Code</th>
            <th>Course Name</th>
            <th>Semester</th>
            <th>Academic Unit</th>
            <th>Actions</th>
        </tr>
        <% 
            List<Course> courses = (List<Course>) request.getAttribute("courses");
            if (courses != null) {
                for (Course course : courses) {
        %>
        <tr>
            <td><%= course.getCourseDefinition().getCode() %></td>
            <td><%= course.getCourseDefinition().getName() %></td>
            <td><%= course.getSemester().getId() %></td>
            <td><%= course.getAcademicUnit().getId() %></td>
            <td>
                <a href="course?action=edit&id=<%= course.getId() %>">Edit</a>
                <a href="course?action=delete&id=<%= course.getId() %>" onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
            </td>
        </tr>
        <% 
                }
            }
        %>
    </table>
</body>
</html>
