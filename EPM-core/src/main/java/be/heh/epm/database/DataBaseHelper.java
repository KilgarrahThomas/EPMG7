package be.heh.epm.database;

import be.heh.epm.application.Employee;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseHelper {

    private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private String user = "postgres";
    private String password = "root";
    private Connection connection = null;
    private Statement stmt;

    public DataBaseHelper() {
        Connect();
    }

    private Connection Connect() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Connected to database successfully");
            stmt = this.connection.createStatement();
            String sql = "CREATE TABLE employees " +
                    "(idemp SERIAL PRIMARY KEY ," +
                    " name           TEXT    NOT NULL UNIQUE, " +
                    " address        CHAR(50), " +
                    " salary         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database\n" + e.getMessage());
        }
        return this.connection;
    }

    public Employee addEmployee(Employee employee) {
        String sql = "INSERT INTO employees(name, address) VALUES (?, ?)";
        try (PreparedStatement ps = this.connection.prepareStatement(sql, new String[] { "idemp" })) {
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeeAddress());
            int id = ps.executeUpdate();
            if (id > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        employee.setEmployeeId(rs.getInt("idemp"));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE idemp=?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee " + getEmployee(id).getEmployeeName() + " deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee getEmployee(int id) {
        String sql = "SELECT * FROM employees WHERE idemp=?";
        Employee emp = new Employee();
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;
            while (rs.next()) {
                emp.setEmployeeId(rs.getInt("idemp"));
                emp.setEmployeeName(rs.getString("name"));
                emp.setEmployeeAddress(rs.getString("address"));
            }
            if (emp.getEmployeeName() == null) {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    public ArrayList getEmployees() {
        Employee employee = null;
        ArrayList<Employee> listEmp = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false)
                return null;
            else do{
                listEmp.add(employee = new Employee(rs.getInt("idemp"), rs.getString("name"), rs.getString("address")));
            }while(rs.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listEmp;
    }

}