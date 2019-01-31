package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class Homepage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Status status = Status.inRepair;
        System.out.println(status.getDisplayStatus());
        System.out.println(status);
//        List<Order> orders = OrderDao.getInstance().loadAllByStatus(status);
//        request.setAttribute("orders", orders);
//        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);


    }
}
