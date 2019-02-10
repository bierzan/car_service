package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeOrders")
public class EmployeeOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empId = Integer.valueOf(request.getParameter("empId"));
        List<Order> orderList = OrderDao.getInstance().loadByEmployeeId(empId);
        request.setAttribute("orders", orderList);
        getServletContext().getRequestDispatcher("/ordersByEmployeeList.jsp").forward(request, response);

    }
}
