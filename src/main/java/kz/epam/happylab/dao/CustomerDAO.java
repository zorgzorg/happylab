package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer> {
    private final String INSERT_QUERY = "INSERT INTO customers (`name`, `city`, `remark`) VALUES (?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE customers SET `name` = ?, `city` = ?, `remark` = ? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE customers SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT `id`, `name`, `city`, `remark` FROM customers WHERE `deleted` = 0 ORDER BY `name`";
    private final String FINDBYID_QUERY = "SELECT `id`, `name`, `city`, `remark` FROM customers WHERE `deleted` = 0 AND `id` = ?";

    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Customer customer) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, customer.getName());
        stmt.setString(2, customer.getCity());
        stmt.setString(3, customer.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Customer customer) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setString(1, customer.getName());
        stmt.setString(2, customer.getCity());
        stmt.setString(3, customer.getRemark());
        stmt.setInt(4, customer.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Customer customer) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, customer.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Customer> findAll() throws SQLException{
        List<Customer> customers = new ArrayList();

        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Customer customer = new Customer(rs);
            customers.add(customer);
        }

        rs.close();
        stmt.close();
        return customers;
    }

    @Override
    public Customer findById(int id) throws SQLException  {
        Customer customer = new Customer();

        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            customer = new Customer(rs);
        }

        rs.close();
        stmt.close();
        return customer;
    }

}
