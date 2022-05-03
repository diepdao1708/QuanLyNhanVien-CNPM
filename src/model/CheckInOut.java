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
public class CheckInOut {
    private int id;
    private NhanVien nhanVien;
    private Date gioCheckIn;
    private Date gioCheckOut;
    private Date ngay;

    public CheckInOut() {
    }

    public CheckInOut(NhanVien nhanVien, Date gioCheckIn, Date gioCheckOut, Date ngay) {
        this.nhanVien = nhanVien;
        this.gioCheckIn = gioCheckIn;
        this.gioCheckOut = gioCheckOut;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public Date getGioCheckIn() {
        return gioCheckIn;
    }

    public Date getGioCheckOut() {
        return gioCheckOut;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setGioCheckIn(Date gioCheckIn) {
        this.gioCheckIn = gioCheckIn;
    }

    public void setGioCheckOut(Date gioCheckOut) {
        this.gioCheckOut = gioCheckOut;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    
}
