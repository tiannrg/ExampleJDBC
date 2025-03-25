/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *fecha: 20/3/2025
 * @author rojas
 * objetivo: representa la tabla record
 */
public class Record {
    private int id;
    private String dateRecord;
    private String startTime;
    private String endTime;
    private Employee employeeId;
    private Key keyId;
    private String status;

    public Record() {
    }

    public Record(int id, String date_record, String start_time, String end_time, Employee employee, Key key, String status) {
        this.id = id;
        this.dateRecord = date_record;
        this.startTime = start_time;
        this.endTime = end_time;
        this.employeeId = employee;
        this.keyId = key;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(String dateRecord) {
        this.dateRecord = dateRecord;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Key getKeyId() {
        return keyId;
    }

    public void setKeyId(Key keyId) {
        this.keyId = keyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    
}
