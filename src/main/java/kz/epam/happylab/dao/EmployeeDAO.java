package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements DAO<Employee> {    
    private final String INSERT_QUERY = "INSERT INTO employees (`lastname`, `name`, `surname`, `positionId`, `assistant`, `signature`, `remark`) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE employees SET `lastname` = ?, `name` = ?, `surname` = ?, `positionId` = ?, `assistant` = ?, `signature` = ?, `remark` = ? WHERE `id` = ?";
    private final String UPDATE_ASSISTANT_QUERY = "UPDATE employees SET `assistant` = ? WHERE `id` = ?";
    private final String UPDATE_SIGNATURE_QUERY = "UPDATE employees SET `signature` = ? WHERE `id` = ?";
    private final String DELETE_SIGNATURE_QUERY = "UPDATE employees SET `signature` = 0";
    private final String DELETE_QUERY = "UPDATE employees SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT e.*, p.position " +
            "FROM employees AS e " +
            "LEFT JOIN positions AS p ON e.positionId=p.id " +
            "WHERE e.deleted = 0 ORDER BY e.lastname";
    private final String FINDALL_ASSISTANTS_QUERY = "SELECT e.*, p.position " +
            "FROM employees AS e " +
            "LEFT JOIN positions AS p ON e.positionId=p.id " +
            "WHERE e.deleted = 0 AND e.assistant = -1 ORDER BY e.lastname";
    private final String FINDBYID_QUERY = "SELECT e.*, p.position " +
            "FROM employees AS e " +
            "LEFT JOIN positions AS p ON e.positionId=p.id " +
            "WHERE e.deleted = 0 AND e.id = ?";

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        if(employee.getSignature() == -1){
            deleteSignature();
        }

        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, employee.getLastname());
        stmt.setString(2, employee.getName());
        stmt.setString(3, employee.getSurname());
        stmt.setInt(4, employee.getPositionId());
        stmt.setInt(5, employee.getAssistant());
        stmt.setInt(6, employee.getSignature());
        stmt.setString(7, employee.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        if(employee.getSignature() == -1){
            deleteSignature();
        }

        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setString(1, employee.getLastname());
        stmt.setString(2, employee.getName());
        stmt.setString(3, employee.getSurname());
        stmt.setInt(4, employee.getPositionId());
        stmt.setInt(5, employee.getAssistant());
        stmt.setInt(6, employee.getSignature());
        stmt.setString(7, employee.getRemark());
        stmt.setInt(8, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateAssistant(Employee employee) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_ASSISTANT_QUERY);
        stmt.setInt(1, employee.getAssistant());
        stmt.setInt(2, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deleteSignature() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_SIGNATURE_QUERY);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateSignature(Employee employee) throws SQLException {
        deleteSignature();
        PreparedStatement stmt = connection.prepareStatement(UPDATE_SIGNATURE_QUERY);
        stmt.setInt(1, employee.getSignature());
        stmt.setInt(2, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList();

        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Employee employee = new Employee(rs);
            employees.add(employee);
        }

        rs.close();
        stmt.close();
        return employees;
    }

    @Override
    public Employee findById(int id) throws SQLException {
        Employee employee = new Employee();

        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            employee = new Employee(rs);
        }

        rs.close();
        stmt.close();
        return employee;
    }

    public List<Employee> findAllAssistant() throws SQLException {
        List<Employee> employees = new ArrayList();

        PreparedStatement stmt = connection.prepareStatement(FINDALL_ASSISTANTS_QUERY);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Employee employee = new Employee(rs);
            employees.add(employee);
        }

        rs.close();
        stmt.close();
        return employees;
    }

}
