package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VehiclesByClient")
public class VehiclesByClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("cliId"));
        request.setAttribute("client", id);
        request.setAttribute("vehicles", VehicleDao.getInstance().loadByClientId(id));
        getServletContext().getRequestDispatcher("/vehiclesByClient.jsp").forward(request, response);
    }
}
