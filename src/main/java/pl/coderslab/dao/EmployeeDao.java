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

    public void save(Employee employee) throws SQLException {
        Connection conn = DBUtil.getConn();
        if (employee.getId() == 0) {
            String sql = "INSERT INTO staff (first_name, surname, address, phone, note, working_hour_cost ) VALUES (?, ?,?,?,?,?)";
            String[] generatedColumns = {"id"};
            PreparedStatement prepStm = conn.prepareStatement(sql, generatedColumns);
            prepStm.setString(1, employee.getName());
            prepStm.setString(2, employee.getSurname());
            prepStm.setString(3, employee.getAddress());
            prepStm.setInt(4, employee.getPhone());
            prepStm.setString(5, employee.getNote());
            prepStm.setBigDecimal(6, employee.getWorkingHourCost());
            prepStm.executeUpdate();
            ResultSet rs = prepStm.getGeneratedKeys();

            if (rs.next()) {
                employee.setId(rs.getInt(1));
            }
        } else {
            update(employee);
        }
    }

    public void update(Employee employee) {

        try (Connection conn = DBUtil.getConn()) {
            if (employee.getId() > 0) {
                String sql = "UPDATE staff SET first_name = ?, surname = ?, address = ?, phone = ?, note = ?, working_hour_cost=? WHERE id = ?";
                PreparedStatement prepStm = conn.prepareStatement(sql);
                prepStm.setString(1, employee.getName());
                prepStm.setString(2, employee.getSurname());
                prepStm.setString(3, employee.getAddress());
                prepStm.setInt(4, employee.getPhone());
                prepStm.setString(5, employee.getNote());
                prepStm.setBigDecimal(6, employee.getWorkingHourCost());

                prepStm.setInt(7, employee.getId());
                prepStm.executeUpdate();
            } else {
                System.out.println("Taki pracownik nie istnieje w bazie danych");
                //todo przerobic na komunikat na stronie
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}