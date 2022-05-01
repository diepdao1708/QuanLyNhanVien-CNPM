/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVien extends Nguoi{
    private int id;
    private BangLuong bangLuong;
    private List<CheckInOut> checkInOut;
    private List<LichDangKy> lichDangKy;

    public NhanVien() {
    }

    public NhanVien(int id, BangLuong bangLuong, List<CheckInOut> checkInOut, List<LichDangKy> lichDangKy) {
        this.id = id;
        this.bangLuong = bangLuong;
        this.checkInOut = checkInOut;
        this.lichDangKy = lichDangKy;
    }

    public NhanVien(int id, String ten, String email, String sdt, String diaChi) {
        super(ten, email, sdt, diaChi);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BangLuong getBangLuong() {
        return bangLuong;
    }

    public List<CheckInOut> getCheckInOut() {
        return checkInOut;
    }

    public List<LichDangKy> getLichDangKy() {
        return lichDangKy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBangLuong(BangLuong bangLuong) {
        this.bangLuong = bangLuong;
    }

    public void setCheckInOut(List<CheckInOut> checkInOut) {
        this.checkInOut = checkInOut;
    }

    public void setLichDangKy(List<LichDangKy> lichDangKy) {
        this.lichDangKy = lichDangKy;
    }
    
    public Object[] toObjects() {
        return new Object[] {
            id, super.getTen()
        };
    }
}
