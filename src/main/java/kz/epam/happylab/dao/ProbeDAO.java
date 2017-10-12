package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Probe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static kz.epam.happylab.util.Constant.ZERO;

public class ProbeDAO implements DAO<Probe> {
    private final String INSERT_QUERY = "INSERT INTO probes (`orderId`, `numberLab`, `numberCustomer`, `dateReceiving`, " +
            "`pointSampling`, `dateSampling`, `remark`) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE probes SET `orderId` = ?, `numberLab` = ?, `numberCustomer` = ?, " +
            "`dateReceiving` = ?, `pointSampling` = ?, `dateSampling` = ?, `remark` = ? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE probes SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT p.*, c.name, o.number " +
            "FROM probes AS p " +
            "INNER JOIN orders AS o ON p.orderId=o.id " +
            "INNER JOIN customers AS c ON c.id=o.customerId " +
            "WHERE p.deleted = 0 " +
            "ORDER BY p.numberLab";
    private final String FINDALL_ORDERID_QUERY = "SELECT p.*, c.name, o.number " +
            "FROM probes AS p " +
            "INNER JOIN orders AS o ON p.orderId=o.id " +
            "INNER JOIN customers AS c ON c.id=o.customerId " +
            "WHERE p.deleted = 0 AND p.orderId = ? " +
            "ORDER BY p.numberLab";
    private final String FINDBYID_QUERY = "SELECT p.*, c.name, o.number " +
            "FROM probes AS p " +
            "INNER JOIN orders AS o ON p.orderId=o.id " +
            "INNER JOIN customers AS c ON c.id=o.customerId " +
            "WHERE p.deleted = 0 AND p.id = ? " +
            "ORDER BY p.numberLab";
    private final String FINDBYID_REPORT_QUERY = "SELECT p.*, c.name, o.number " +
            "FROM probes AS p " +
            "INNER JOIN orders AS o ON p.orderId=o.id " +
            "INNER JOIN customers AS c ON c.id=o.customerId " +
            "WHERE p.deleted = 0 AND p.id = ?";

    private Connection connection;

    public ProbeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Probe probe) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, probe.getOrderId());
        stmt.setInt(2, probe.getNumberLab());
        stmt.setInt(3, probe.getNumberCustomer());
        stmt.setDate(4, (Date) probe.getDateReceiving());
        stmt.setString(5, probe.getPointSampling());
        stmt.setDate(6, (Date) probe.getDateSampling());
        stmt.setString(7, probe.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Probe probe) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setInt(1, probe.getOrderId());
        stmt.setInt(2, probe.getNumberLab());
        stmt.setInt(3, probe.getNumberCustomer());
        stmt.setDate(4, (Date) probe.getDateReceiving());
        stmt.setString(5, probe.getPointSampling());
        stmt.setDate(6, (Date) probe.getDateSampling());
        stmt.setString(7, probe.getRemark());
        stmt.setInt(8, probe.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Probe probe) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, probe.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Probe> findAll() throws SQLException {
        return findAll(ZERO);
    }

    public List<Probe> findAll(int orderId) throws SQLException{
        List<Probe> probes = new ArrayList();
        PreparedStatement stmt;

        if (orderId == ZERO) {
            stmt = connection.prepareStatement(FINDALL_QUERY);
        } else {
            stmt = connection.prepareStatement(FINDALL_ORDERID_QUERY);
            stmt.setInt(1, orderId);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Probe probe = new Probe(rs);
            probes.add(probe);;
        }

        rs.close();
        stmt.close();
        return probes;
    }
    @Override
    public Probe findById(int id) throws SQLException {
        Probe probe = new Probe();

        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            probe = new Probe(rs);
        }

        rs.close();
        stmt.close();
        return probe;
    }

    public Probe findByIdReport(int id) throws SQLException {
        Probe probe = new Probe();

        PreparedStatement stmt = connection.prepareStatement(FINDBYID_REPORT_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            probe = new Probe(rs);
        }

        rs.close();
        stmt.close();
        return probe;
    }
}
