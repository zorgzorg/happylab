package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class Position {
    private int id;
    private String position;
    private String remark;
    private List<Position> positions;

    public Position() {
    }

    public Position(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.position = rs.getString(POSITION);
        this.remark = rs.getString(REMARK);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
