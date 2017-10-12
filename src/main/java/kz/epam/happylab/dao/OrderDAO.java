package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static kz.epam.happylab.util.Constant.ZERO;

public class OrderDAO implements DAO<Order> {
    private final String INSERT_QUERY = "INSERT INTO orders (`number`, `customerId`, `date`, `remark`) " +
            "VALUES(?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE orders " +
            "SET `number` = ?, `customerId` = ?, `date` = ?, `remark` = ? " +
            "WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE orders " +
            "SET `deleted` = -1 " +
            "WHERE `id` = ?";
    private final String FINDALL_QUERY = "SELECT o.id, o.number, o.customerId, " +
            "o.date, o.remark, c.name, count(p.orderId) as probesQuantity " +
            "FROM orders AS o " +
            "INNER JOIN customers AS c ON o.customerId = c.id " +
            "LEFT JOIN probes AS p ON o.id = p.orderId " +
            "WHERE o.deleted = 0 AND c.deleted = 0 " +
            "GROUP BY o.id " +
            "ORDER BY o.number";
    private final String FINDALL_CUSTOMERID_QUERY = "SELECT o.id, o.number, o.customerId, " +
            "o.date, o.remark, c.name, count(p.orderId) as probesQuantity " +
            "FROM orders AS o " +
            "INNER JOIN customers AS c ON o.customerId = c.id " +
            "LEFT JOIN probes AS p ON o.id = p.orderId " +
            "WHERE o.deleted = 0 AND c.deleted = 0 AND o.customerID = ? " +
            "GROUP BY o.id " +
            "ORDER BY o.number";
    private final String FINDBYKEY_QUERY = "SELECT o.id, o.number, o.customerId, " +
            "o.date, o.remark, c.name, count(p.orderId) as probesQuantity " +
            "FROM orders AS o " +
            "INNER JOIN customers AS c ON o.customerId = c.id " +
            "LEFT JOIN probes AS p ON o.id = p.orderId " +
            "WHERE o.deleted = 0 AND c.deleted = 0 AND o.id = ? " +
            "GROUP BY o.id " +
            "ORDER BY o.number";

    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Order order) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, order.getNumber());
        stmt.setInt(2, order.getCustomerId());
        stmt.setDate(3, (Date) order.getDate());
        stmt.setString(4, order.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Order order) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setString(1, order.getNumber());
        stmt.setInt(2, order.getCustomerId());
        stmt.setDate(3, (Date) order.getDate());
        stmt.setString(4, order.getRemark());
        stmt.setInt(5, order.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Order order) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, order.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Order> findAll() throws SQLException{
        return findAll(ZERO);
    }


    public List<Order> findAll(int customerId) throws SQLException{
        List<Order> orders = new ArrayList();
        PreparedStatement stmt;

        if (customerId == ZERO) {
            stmt = connection.prepareStatement(FINDALL_QUERY);
        } else {
            stmt = connection.prepareStatement(FINDALL_CUSTOMERID_QUERY);
            stmt.setInt(1, customerId);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Order order = new Order(rs);
            orders.add(order);
        }

        rs.close();
        stmt.close();
        return orders;
    }

    @Override
    public Order findById(int id) throws SQLException  {
        Order order = new Order();
        PreparedStatement stmt = connection.prepareStatement(FINDBYKEY_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            order = new Order(rs);
        }

        rs.close();
        stmt.close();
        return order;
    }
}
