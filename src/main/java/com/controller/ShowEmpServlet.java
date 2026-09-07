package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Employee;

@WebServlet("/show")
public class ShowEmpServlet extends HttpServlet {

    EmployeeDao dao;

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        List<Employee> emplist = dao.showEmpList();

        // HTML + CSS
        out.print("<html>");
        out.print("<head>");

        out.print("<style>");

        out.print("body {");
        out.print("font-family: Arial, sans-serif;");
        out.print("background-color: #f4f6f8;");
        out.print("margin: 0;");
        out.print("padding: 40px;");
        out.print("}");

        out.print("h1 {");
        out.print("text-align: center;");
        out.print("color: #333;");
        out.print("margin-bottom: 30px;");
        out.print("}");

        out.print("table {");
        out.print("width: 80%;");
        out.print("margin: auto;");
        out.print("border-collapse: collapse;");
        out.print("background-color: white;");
        out.print("box-shadow: 0 4px 12px rgba(0,0,0,0.1);");
        out.print("}");

        out.print("th {");
        out.print("background-color: #333;");
        out.print("color: white;");
        out.print("padding: 14px;");
        out.print("text-align: center;");
        out.print("}");

        out.print("td {");
        out.print("padding: 12px;");
        out.print("text-align: center;");
        out.print("border-bottom: 1px solid #ddd;");
        out.print("}");

        out.print("tr:hover {");
        out.print("background-color: #f1f1f1;");
        out.print("}");

        out.print("</style>");

        out.print("</head>");

        out.print("<body>");

        out.print("<h1>Employee Details</h1>");

        out.print("<table>");

        out.print("<tr>");
        out.print("<th>Employee ID</th>");
        out.print("<th>Employee Name</th>");
        out.print("<th>Employee Salary</th>");
        out.print("</tr>");

        for (Employee emp : emplist) {

            out.print("<tr>");

            out.print("<td>");
            out.print(emp.getId());
            out.print("</td>");

            out.print("<td>");
            out.print(emp.getName());
            out.print("</td>");

            out.print("<td>");
            out.print(emp.getSalery());
            out.print("</td>");

            out.print("</tr>");
        }

        out.print("</table>");

        out.print("</body>");
        out.print("</html>");
    }
}