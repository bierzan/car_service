package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/UpdateVehicle")
public class UpdateVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("sendId"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int productionYear = Integer.valueOf(request.getParameter("prodYear"));
        String regNumber = request.getParameter("reg");
        LocalDate nextService = LocalDate.parse(request.getParameter("nextService"));

        Vehicle vehicle = VehicleDao.getInstance().loadById(id);
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setProductionYear(productionYear);
        vehicle.setRegNumber(regNumber);
        vehicle.setNextService(nextService);

        VehicleDao.getInstance().update(vehicle);

        response.sendRedirect("/VehiclesByClient?cliId=" + vehicle.getClient().getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
