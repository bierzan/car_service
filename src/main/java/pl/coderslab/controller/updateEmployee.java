package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/updateEmployee")
public class updateEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.valueOf(request.getParameter("sendId"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        int phone = Integer.valueOf(request.getParameter("phone"));
        String note = request.getParameter("note");
        BigDecimal workingHourCost = new BigDecimal(request.getParameter("whc"));

        Employee employee = EmployeeDao.getInstance().loadById(empId);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setNote(note);
        employee.setWorkingHourCost(workingHourCost);

        EmployeeDao.getInstance().update(employee);
        response.sendRedirect("/EmployeesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
