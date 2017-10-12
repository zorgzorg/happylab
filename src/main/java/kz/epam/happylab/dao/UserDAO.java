package kz.epam.happylab.dao;

import kz.epam.happylab.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    private final String INSERT_QUERY = "INSERT INTO users (`name`, `username`, `email`, `password`, `usertype`, " +
            "`dateRegistration`, `block`, `remark`) VALUES(?, ?, ?, md5(?), ?, ?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE users SET `name` = ?, `username` = ?, `email` = ?, " +
            "`password` = md5(?), `usertype` = ?, `dateRegistration` = ?, `block` = ?, " +
            "`remark` = ? WHERE `id` = ?";
    private final String UPDATEPROFILE_QUERY = "UPDATE users SET `name` = ?, `username` = ?, `email` = ?, " +
            "`password` = md5(?) WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE users SET `deleted` = -1 WHERE `id` =  ?";
    private final String BLOCK_QUERY = "UPDATE users SET `block` = ? WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT * FROM users WHERE `deleted` = 0 ORDER BY username";
    private final String FINDBYKEY_QUERY = "SELECT * FROM users WHERE `id` = ? AND `deleted` = 0";
    private final String FINDBYLOGIN_QUERY = "SELECT * FROM users WHERE `username` = ? AND `password` = md5(?) AND `deleted` = 0";

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getUsertype());
        stmt.setDate(6, (Date) user.getDateRegistration());
        stmt.setInt(7, user.getBlock());
        stmt.setString(8, user.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getUsertype());
        stmt.setDate(6, (Date) user.getDateRegistration());
        stmt.setInt(7, user.getBlock());
        stmt.setString(8, user.getRemark());
        stmt.setInt(9, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateProfile(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATEPROFILE_QUERY);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setInt(5, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateBlock(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(BLOCK_QUERY);
        stmt.setInt(1, user.getBlock());
        stmt.setInt(2, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            User user = new User(rs);
            users.add(user);
        }

        rs.close();
        stmt.close();
        return users;
    }

    @Override
    public User findById(int id) throws SQLException {
        User user = new User();

        PreparedStatement stmt = connection.prepareStatement(FINDBYKEY_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            user = new User(rs);
        }

        rs.close();
        stmt.close();
        return user;
    }


    public User findByLogin(String login, String password) throws SQLException {
        User user = new User();

        PreparedStatement stmt = connection.prepareStatement(FINDBYLOGIN_QUERY);
        stmt.setString(1, login);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            user = new User(rs);
        }

        rs.close();
        stmt.close();
        return user;
    }
}
