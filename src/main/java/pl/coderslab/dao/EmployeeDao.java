package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static EmployeeDao instance;

    public static EmployeeDao getInstance() {
        if (instance == null) {
            instance = new EmployeeDao();
        }

        return instance;
    }

    public List<Employee> loadAll() {
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DBUtil.getConn()) {
            String sql = "SELECT * FROM staff";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                Employee employee = new Employee();
                int id = rs.getInt("id");
                employee.setId(id);
                employee.setName(rs.getString("first_name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getInt("phone"));
                employee.setNote(rs.getString("note"));
                employee.setWorkingHourCost(rs.getBigDecimal("working_hour_cost"));

                employees.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee loadById(int id) {
        Employee employee = new Employee();
        try (Connection conn = DBUtil.getConn()) {
            String sql = "SELECT * FROM staff WHERE id = ?";
            PreparedStatement prepStm = conn.prepareStatement(sql);
            prepStm.setInt(1, id);
            prepStm.executeQuery();
            ResultSet rs = prepStm.getResultSet();

            while (rs.next()) {
                employee.setId(id);
                employee.setName(rs.getString("first_name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getInt("phone"));
                employee.setNote(rs.getString("note"));
                employee.setWorkingHourCost(rs.getBigDecimal("working_hour_cost"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}