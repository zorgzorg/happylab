package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements DAO<Position> {
    private final String INSERT_QUERY = "INSERT INTO positions (`position`, `remark`) VALUES(?, ?)";
    private final String UPDATE_QUERY = "UPDATE positions SET `position` = ?, `remark` = ? WHERE `id` = ?";
    private final String DELETE_QUERY = "UPDATE positions SET `deleted` = -1 WHERE `id` =  ?";
    private final String FINDALL_QUERY = "SELECT * FROM positions WHERE `deleted` = 0 ORDER BY `position`";
    private final String FINDBYID_QUERY = "SELECT * FROM positions WHERE `deleted` = 0 AND `id` = ?";

    private Connection connection;

    public PositionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Position position) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, position.getPosition());
        stmt.setString(2, position.getRemark());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();
        return lastId;
    }

    @Override
    public void update(Position position) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
        stmt.setString(1, position.getPosition());
        stmt.setString(2, position.getRemark());
        stmt.setInt(3, position.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void delete(Position position) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
        stmt.setInt(1, position.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Position> findAll() throws SQLException {
        List<Position> positions = new ArrayList();

        PreparedStatement stmt = connection.prepareStatement(FINDALL_QUERY);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Position position = new Position(rs);
            positions.add(position);
        }

        rs.close();
        stmt.close();
        return positions;
    }

    @Override
    public Position findById(int id) throws SQLException {
        Position position = new Position();

        PreparedStatement stmt = connection.prepareStatement(FINDBYID_QUERY);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            position = new Position(rs);
        }

        rs.close();
        stmt.close();
        return position;
    }
}
