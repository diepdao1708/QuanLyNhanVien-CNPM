/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class CheckInOutTime {
    private int id;
    private int tblEmployeeid;
    private Date checkInTime;
    private Date checkOutTime;
    private Date day;
    private Boolean shift;
    
    public CheckInOutTime() {
    }

    public CheckInOutTime(int id, int tblEmployeeid, Date checkInTime, Date checkOutTime, Date day, Boolean shift) {
        this.id = id;
        this.tblEmployeeid = tblEmployeeid;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.day = day;
        this.shift = shift;
    }

    public CheckInOutTime(int tblEmployeeid, Date checkInTime, Date day, Boolean shift) {
        this.tblEmployeeid = tblEmployeeid;
        this.checkInTime = checkInTime;
        this.day = day;
        this.shift = shift;
    }

    public CheckInOutTime(int tblEmployeeid, Date checkOutTime, Date day) {
        this.tblEmployeeid = tblEmployeeid;
        this.checkOutTime = checkOutTime;
        this.day = day;
    }
    
    public int getId() {
        return id;
    }

    public int getTblEmployeeid() {
        return tblEmployeeid;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public Date getDay() {
        return day;
    }

    public Boolean getShift() {
        return shift;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTblEmployeeid(int tblEmployeeid) {
        this.tblEmployeeid = tblEmployeeid;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setDay(Date date) {
        this.day = date;
    }

    public void setShift(Boolean shift) {
        this.shift = shift;
    }
}
