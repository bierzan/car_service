package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VehicleToEdit")
public class VehicleToEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("vehId"));
        request.setAttribute("vehicle", VehicleDao.getInstance().loadById(id));
        getServletContext().getRequestDispatcher("/forms/editVehicle.jsp").forward(request, response);
    }
}
