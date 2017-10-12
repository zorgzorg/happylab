package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String usertype;
    private Date dateRegistration;
    private int block;
    private String remark;
    private List<User> users;
    private List<Usertype> usertypes;

    public User() {
    }

    public User(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.name = rs.getString(NAME);
        this.username = rs.getString(USERNAME);
        this.email = rs.getString(EMAIL);
        this.password = rs.getString(PASSWORD);
        this.usertype = rs.getString(USERTYPE);
        this.dateRegistration = rs.getDate(DATE_REGISTRATION);
        this.block = rs.getInt(BLOCK);
        this.remark = rs.getString(REMARK);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Usertype> getUsertypes() {
        return usertypes;
    }

    public void setUsertypes(List<Usertype> usertypes) {
        this.usertypes = usertypes;
    }
}
