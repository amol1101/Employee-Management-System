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

@WebServlet("/delete")
public class DeleteEmpServlet extends HttpServlet {

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

        int res = dao.deleteEmployee(id);

        out.print("<html>");
        out.print("<head>");

        out.print("<style>");

        out.print("body {");
        out.print("font-family: Arial, sans-serif;");
        out.print("background-color: #f4f6f8;");
        out.print("display: flex;");
        out.print("justify-content: center;");
        out.print("align-items: center;");
        out.print("height: 100vh;");
        out.print("margin: 0;");
        out.print("}");

        out.print(".message {");
        out.print("background-color: white;");
        out.print("padding: 40px;");
        out.print("border-radius: 10px;");
        out.print("box-shadow: 0 4px 15px rgba(0,0,0,0.15);");
        out.print("text-align: center;");
        out.print("}");

        out.print(".success {");
        out.print("color: green;");
        out.print("}");

        out.print(".failed {");
        out.print("color: red;");
        out.print("}");

        out.print("</style>");

        out.print("</head>");

        out.print("<body>");

        out.print("<div class='message'>");

        if (res > 0) {
            out.print("<h1 class='success'>Employee Deleted Successfully!</h1>");
        } else {
            out.print("<h1 class='failed'>Employee Not Found!</h1>");
        }

        out.print("</div>");

        out.print("</body>");

        out.print("</html>");
    }
}