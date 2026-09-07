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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

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
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salery"));

        Employee emp = new Employee(id, name, salary);

        int res = dao.updateEmployee(emp);

        // CSS
        out.print("<style>");

        out.print("body {");
        out.print("margin: 0;");
        out.print("padding: 0;");
        out.print("background-color: #f4f6f8;");
        out.print("font-family: Arial, sans-serif;");
        out.print("display: flex;");
        out.print("justify-content: center;");
        out.print("align-items: center;");
        out.print("height: 100vh;");
        out.print("}");

        out.print(".box {");
        out.print("background-color: white;");
        out.print("padding: 60px;");
        out.print("width: 650px;");
        out.print("text-align: center;");
        out.print("border-radius: 15px;");
        out.print("box-shadow: 0 5px 20px rgba(0,0,0,0.15);");
        out.print("}");

        out.print("h1 {");
        out.print("color: green;");
        out.print("font-size: 42px;");
        out.print("margin: 0;");
        out.print("}");

        out.print("</style>");

        out.print("<div class='box'>");

        if (res > 0)
            out.print("<h1>Employee Updated Successfully!</h1>");
        else
            out.print("<h1>Update Failed !!!</h1>");

        out.print("</div>");
    }
}