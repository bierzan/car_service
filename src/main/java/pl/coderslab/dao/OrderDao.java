package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static OrderDao instance;

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }

        return instance;
    }

    public List<Order> loadAllByStatus(Status status) {

        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBUtil.getConn()) {
            String sql = "SELECT * FROM orders WHERE order_status = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setString(1, status.getDisplayStatus());
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();
            Order order = new Order();
            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setOrderDate(LocalDateTime.ofInstant(rs.getDate("order_date")
                        .toInstant(), ZoneId.systemDefault()));
                order.setPlannedRepairStart(rs.getDate("planned_repair_start").toLocalDate());
                order.setRepairStart(LocalDateTime.ofInstant(rs.getDate("repair_start")
                        .toInstant(), ZoneId.systemDefault()));
                order.setEmployee(EmployeeDao.getInstance().loadById(rs.getInt("worker_id")));
                order.setProblemDescription(rs.getString("problem_desc"));
                order.setRepairDescription(rs.getString("repair_desc"));
                order.setStatus(status);
                order.setVehicle(VehicleDao.getInstance().loadById(rs.getInt("car_id")));
                order.setRepairCost(rs.getBigDecimal("repair_cost"));
                order.setPartsCost(rs.getBigDecimal("parts_cost"));
                order.setWorkingHours(rs.getInt("working_hours"));
                order.setRepairEnd(rs.getDate("repair_end").toLocalDate());

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}