package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeToEdit")
public class employeeToEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.valueOf(request.getParameter("empId"));
        Employee emp = EmployeeDao.getInstance().loadById(empId);
        request.setAttribute("employee", emp);
        getServletContext().getRequestDispatcher("/forms/editEmployee.jsp").forward(request, response);
    }
}
