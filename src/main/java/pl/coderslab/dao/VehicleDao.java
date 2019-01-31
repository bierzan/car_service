package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleDao {
    private static VehicleDao instance;

    public static VehicleDao getInstance() {
        if (instance == null) {
            instance = new VehicleDao();
        }

        return instance;
    }

    public Vehicle loadById(int id){
        Vehicle vehicle = new Vehicle();

        try(Connection conn = DBUtil.getConn()){
            String sql = "SELECT * FROM vehicles WHERE id = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setInt(1,id);
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();

            while(rs.next()){
                vehicle.setClient(ClientDao.getInstance().loadById(rs.getInt("client_id")));
                vehicle.setBrand("brand");
                vehicle.setModel("model");
                vehicle.setProductionYear(rs.getInt("production_year"));
                vehicle.setRegNumber(rs.getString("reg_number"));
                vehicle.setNextService(rs.getDate("next_service").toLocalDate());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }
}