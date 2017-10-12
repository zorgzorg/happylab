package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class Customer {
    private int id;
    private String name;
    private String city;
    private String remark;
    private List<Customer> customers;

    public Customer() {
    }

    public Customer(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.name = rs.getString(NAME);
        this.city = rs.getString(CITY);
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Collection getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
