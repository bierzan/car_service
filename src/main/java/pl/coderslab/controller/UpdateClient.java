package pl.coderslab.controller;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        int id = Integer.valueOf(request.getParameter("sendId"));

        Client client = ClientDao.getInstance().loadById(id);
        client.setName(name);
        client.setSurname(surname);
        client.setBirthday(birthday);

        ClientDao.getInstance().update(client);

        response.sendRedirect("/ClientsList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
