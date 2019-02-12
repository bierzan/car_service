package pl.coderslab.dao;

import pl.coderslab.model.Client;
import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static VehicleDao instance;

    public static VehicleDao getInstance() {
        if (instance == null) {
            instance = new VehicleDao();
        }

        return instance;
    }

    public Vehicle loadById(int id) {
        Vehicle vehicle = new Vehicle();

        try (Connection conn = DBUtil.getConn()) {
            String sql = "SELECT * FROM vehicles WHERE id = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setInt(1, id);
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();

            while (rs.next()) {
                vehicle.setClient(ClientDao.getInstance().loadById(rs.getInt("client_id")));
                vehicle.setBrand("brand");
                vehicle.setModel("model");
                vehicle.setProductionYear(rs.getInt("production_year"));
                vehicle.setRegNumber(rs.getString("reg_number"));
                vehicle.setNextService(rs.getDate("next_service").toLocalDate());
                vehicle.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public List<Vehicle> loadByClientId(int id) {

        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = DBUtil.getConn()) {
            String sql = "SELECT * FROM vehicles WHERE client_id = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setInt(1, id);
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setClient(ClientDao.getInstance().loadById(id));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setProductionYear(rs.getInt("production_year"));
                vehicle.setRegNumber(rs.getString("reg_number"));
                vehicle.setNextService(rs.getDate("next_service").toLocalDate());
                vehicle.setId(rs.getInt("id"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public void save(Vehicle vehicle) {

        if (vehicle.getId() != 0) {
            return;
        }

        try (Connection conn = DBUtil.getConn()) {

            PreparedStatement prepStm;
            String sql = "INSERT INTO vehicles (client_id, brand, model, production_year, reg_number, next_service) VALUES (?, ?, ?,?,?,?)";
            String[] autoColumns = {"id"};
            prepStm = conn.prepareStatement(sql, autoColumns);
            prepStm.setInt(1, vehicle.getClient().getId());
            prepStm.setString(2, vehicle.getBrand());
            prepStm.setString(3, vehicle.getModel());
            prepStm.setString(4, String.valueOf(vehicle.getProductionYear()));
            prepStm.setString(5, vehicle.getRegNumber());
            prepStm.setDate(6, Date.valueOf(vehicle.getNextService()));
            prepStm.executeUpdate();
            ResultSet rs = prepStm.getGeneratedKeys();

            if (rs.next()) {
                vehicle.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}