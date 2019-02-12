package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OrdersByClient")
public class OrdersByClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("cliId"));
        List<Order> orders = new ArrayList();
        List<Vehicle> vehicles = VehicleDao.getInstance().loadByClientId(id);

        for (Vehicle veh : vehicles) {
            orders.addAll(OrderDao.getInstance().loadByVehicleId(veh.getId()));
        }

        request.setAttribute("orders", orders);

        getServletContext().getRequestDispatcher("/ordersByClient.jsp").forward(request, response);
    }
}
