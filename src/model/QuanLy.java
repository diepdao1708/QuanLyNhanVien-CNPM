/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class QuanLy {
    private int id;
    private String matKhau;
    private String tenDangNhap;

    public QuanLy() {
    }
    
    public QuanLy(int id, String matKhau, String tenDangNhap) {
        this.id = id;
        this.matKhau = matKhau;
        this.tenDangNhap = tenDangNhap;
    }

    public int getId() {
        return id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
}
