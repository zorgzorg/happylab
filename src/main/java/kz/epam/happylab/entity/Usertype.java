package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.util.Constant.ID;
import static kz.epam.happylab.util.Constant.USERTYPE;

public class Usertype {
    private int id;
    private String usertype;

    public Usertype(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.usertype = rs.getString(USERTYPE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
