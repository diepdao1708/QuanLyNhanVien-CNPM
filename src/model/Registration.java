/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Registration {
    private int id;
    private int tblEmployeeid;
    private Boolean morningShift;
    private Boolean nightShift;
    private Date day;
    private Boolean accepted;

    public Registration(int id, int tblEmployeeid, Boolean morningShift, Boolean nightShift, Date day, Boolean accepted) {
        this.id = id;
        this.tblEmployeeid = tblEmployeeid;
        this.morningShift = morningShift;
        this.nightShift = nightShift;
        this.day = day;
        this.accepted = accepted;
    }

    public Registration(int tblEmployeeid, Boolean morningShift, Boolean nightShift, Date day, Boolean accepted) {
        this.tblEmployeeid = tblEmployeeid;
        this.morningShift = morningShift;
        this.nightShift = nightShift;
        this.day = day;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public int getTblEmployeeid() {
        return tblEmployeeid;
    }

    public Boolean getMorningShift() {
        return morningShift;
    }

    public Boolean getNightShift() {
        return nightShift;
    }

    public Date getDay() {
        return day;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTblEmployeeid(int tblEmployeeid) {
        this.tblEmployeeid = tblEmployeeid;
    }

    public void setMorningShift(Boolean morningShift) {
        this.morningShift = morningShift;
    }

    public void setNightShift(Boolean nightShift) {
        this.nightShift = nightShift;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
