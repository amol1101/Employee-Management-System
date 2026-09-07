package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Employee;

@WebServlet("/find")
public class FindEmpServlet extends HttpServlet {

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

        int id = Integer.parseInt(req.getParameter("id"));

        Employee emp = dao.findEmp(id);

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
        out.print("width: 70%;");
        out.print("margin: auto;");
        out.print("border-collapse: collapse;");
        out.print("background-color: white;");
        out.print("box-shadow: 0 4px 12px rgba(0,0,0,0.1);");
        out.print("}");

        out.print("th {");
        out.print("background-color: #333;");
        out.print("color: white;");
        out.print("padding: 14px;");
        out.print("}");

        out.print("td {");
        out.print("padding: 14px;");
        out.print("text-align: center;");
        out.print("border-bottom: 1px solid #ddd;");
        out.print("}");

        out.print("tr:hover {");
        out.print("background-color: #f1f1f1;");
        out.print("}");

        out.print(".not-found {");
        out.print("text-align: center;");
        out.print("color: red;");
        out.print("font-size: 20px;");
        out.print("font-weight: bold;");
        out.print("}");

        out.print("</style>");

        out.print("</head>");

        out.print("<body>");

        if (emp == null) {

            out.print("<h1 class='not-found'>Record Not Found</h1>");

        } else {

            out.print("<h1>Employee Details</h1>");

            out.print("<table>");

            out.print("<tr>");
            out.print("<th>Employee ID</th>");
            out.print("<th>Employee Name</th>");
            out.print("<th>Employee Salary</th>");
            out.print("</tr>");

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

            out.print("</table>");
        }

        out.print("</body>");
        out.print("</html>");
    }
}