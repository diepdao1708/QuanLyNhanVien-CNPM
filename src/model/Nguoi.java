/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Nguoi {
    private String ten;
    private String email;
    private String sdt;
    private String diaChi;

    public Nguoi() {
    }

    public Nguoi(String ten, String email, String sdt, String diaChi) {
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
