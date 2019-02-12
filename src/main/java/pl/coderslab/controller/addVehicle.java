package pl.coderslab.controller;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addVehicle")
public class addVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = Integer.valueOf(request.getParameter("sendId"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int productionYear = Integer.valueOf(request.getParameter("prodYear"));
        String regNumber = request.getParameter("reg");
        LocalDate nextService = LocalDate.parse(request.getParameter("nextService"));

        Vehicle vehicle = new Vehicle(ClientDao.getInstance().loadById(clientId),
                brand, model, productionYear, regNumber, nextService);

        VehicleDao.getInstance().save(vehicle);

        response.sendRedirect("/VehiclesByClient?cliId="+clientId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
