package pl.coderslab.dao;

import pl.coderslab.model.Client;
import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DBUtil;

import java.sql.*;

public class ClientDao {
    private static ClientDao instance;

    public static ClientDao getInstance() {
        if (instance == null) {
            instance = new ClientDao();
        }

        return instance;
    }

    public void save(Client client) {

        if (client.getId() != 0) {
            return;
            //todo przesunięcie do update lub komunikat
        }

        try (Connection conn = DBUtil.getConn()) {

            PreparedStatement prepStm;
            String sql = "INSERT INTO clients (first_name, surname, birthday) VALUES (?, ?, ?)";
            String[] autoColumns = {"id"};
            prepStm = conn.prepareStatement(sql, autoColumns);
            prepStm.setString(1, client.getName());
            prepStm.setString(2, client.getSurname());
            prepStm.setDate(3, Date.valueOf(client.getBirthday()));
            prepStm.executeUpdate();
            ResultSet rs = prepStm.getGeneratedKeys();

            if (rs.next()) {
                client.setId(rs.getInt(1));
            }

            //todo sprawdzic zachowanie z pustymi i pełnymi datami


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Client loadById(int id){
        Client client = new Client();

        try(Connection conn = DBUtil.getConn()){
            String sql = "SELECT * FROM clients WHERE id = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setInt(1,id);
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();

            while(rs.next()){
                client.setName(rs.getString("first_name"));
                client.setSurname(rs.getString("surname"));
                client.setBirthday(rs.getDate("birthday").toLocalDate());
                client.setId(id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }
}