package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.utils.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
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
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                Timestamp timestamp = rs.getTimestamp("order_date");
                LocalDateTime ldt = timestamp.toLocalDateTime();

                order.setOrderDate(ldt);
                order.setPlannedRepairStart(rs.getDate("planned_repair_start").toLocalDate());


                order.setRepairStart(rs.getTimestamp("repair_start").toLocalDateTime());
                order.setEmployee(EmployeeDao.getInstance().loadById(rs.getInt("worker_id")));
                order.setProblemDescription(rs.getString("problem_desc"));
                order.setRepairDescription(rs.getString("repair_desc"));
                order.setStatus(status);
                order.setVehicle(VehicleDao.getInstance().loadById(rs.getInt("car_id")));
                order.setRepairCost(rs.getBigDecimal("repair_cost"));
                order.setPartsCost(rs.getBigDecimal("parts_cost"));
                order.setWorkingHours(rs.getInt("working_hours"));
                if (rs.getDate("repair_end") != null) {

                    order.setRepairEnd(rs.getDate("repair_end").toLocalDate());
                }

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}