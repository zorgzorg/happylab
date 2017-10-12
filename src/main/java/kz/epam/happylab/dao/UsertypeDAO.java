package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Usertype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsertypeDAO implements DAO<Usertype> {
    private final String FINDALL_QUERY = "SELECT * FROM usertype ORDER BY `usertype`";
    private Connection connection;

    public UsertypeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Usertype usertype) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Usertype usertype) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Usertype usertype) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Usertype> findAll() throws SQLException {
        List<Usertype> usertypes = new ArrayList();

        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usertype usertype = new Usertype(rs);
            usertypes.add(usertype);
        }

        rs.close();
        stmt.close();
        return usertypes;
    }

    @Override
    public Usertype findById(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
