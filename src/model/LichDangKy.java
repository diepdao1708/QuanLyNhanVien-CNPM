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
public class LichDangKy {
    private int id;
    private NhanVien nhanVien;
    private Boolean caSang;
    private Boolean caToi;
    private Date ngay;
    private Boolean chapNhan;

    public LichDangKy() {
    }
    
    public LichDangKy( NhanVien nhanVien, Boolean caSang, Boolean caToi, Date ngay, Boolean chapNhan) {
        this.nhanVien = nhanVien;
        this.caSang = caSang;
        this.caToi = caToi;
        this.ngay = ngay;
        this.chapNhan = chapNhan;
    }

    public LichDangKy(int id, NhanVien nhanVien, Boolean caSang, Boolean caToi, Date ngay, Boolean chapNhan) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.caSang = caSang;
        this.caToi = caToi;
        this.ngay = ngay;
        this.chapNhan = chapNhan;
    }

    public int getId() {
        return id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public Boolean getCaSang() {
        return caSang;
    }

    public Boolean getCaToi() {
        return caToi;
    }

    public Date getNgay() {
        return ngay;
    }

    public Boolean getChapNhan() {
        return chapNhan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setCaSang(Boolean caSang) {
        this.caSang = caSang;
    }

    public void setCaToi(Boolean caToi) {
        this.caToi = caToi;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public void setChapNhan(Boolean chapNhan) {
        this.chapNhan = chapNhan;
    }
    
    
}
