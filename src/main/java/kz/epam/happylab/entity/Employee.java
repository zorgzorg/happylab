package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kz.epam.happylab.util.Constant.*;

public class Employee {
    private int id;
    private String lastname;
    private String name;
    private String surname;
    private int positionId;
    private String position;
    private int assistant;
    private int signature;
    private String remark;
    private List<Employee> employees;
    private List<Position> positions;

    public Employee() {
    }

    public Employee(ResultSet rs) throws SQLException {
        this.id = rs.getInt(ID);
        this.lastname = rs.getString(LASTNAME);
        this.name = rs.getString(NAME);
        this.surname = rs.getString(SURNAME);
        this.positionId = rs.getInt(POSITION_ID);
        this.position = rs.getString(POSITION);
        this.assistant = rs.getInt(ASSISTANT);
        this.signature = rs.getInt(SIGNATURE);
        this.remark = rs.getString(REMARK);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAssistant() {
        return assistant;
    }

    public void setAssistant(int assistant) {
        this.assistant = assistant;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
