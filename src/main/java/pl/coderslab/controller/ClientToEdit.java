package pl.coderslab.controller;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ClientToEdit")
public class ClientToEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("cliId"));
        Client client = ClientDao.getInstance().loadById(id);
        request.setAttribute("client", client);
        getServletContext().getRequestDispatcher("/forms/editClient.jsp").forward(request, response);
    }
}
