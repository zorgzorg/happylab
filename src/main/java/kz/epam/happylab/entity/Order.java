package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class Order{
    private static final String PROBES_QUANTITY = "probesQuantity";
    private int id;
    private String number;
    private int customerId;
    private String name;
    private Date date;
    private String remark;
    private int probesQuantity;
    private List<Customer> customers;
    private List<Order> orders;
    private int filter;

    public Order() {
    }

    public Order(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.number = rs.getString(NUMBER);
        this.customerId = rs.getInt(CUSTOMER_ID);
        this.name = rs.getString(NAME);
        this.date = rs.getDate(DATE);
        this.probesQuantity = rs.getInt(PROBES_QUANTITY);
        this.remark = rs.getString(REMARK);
    }

    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getProbesQuantity() {
        return probesQuantity;
    }

    public void setProbesQuantity(int probesQuantity) {
        this.probesQuantity = probesQuantity;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }
}
