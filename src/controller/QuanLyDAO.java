/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.QuanLy;

/**
 *
 * @author Admin
 */
public class QuanLyDAO extends DAO {

    public QuanLyDAO() {
    }
    
    public boolean checkLogin(QuanLy quanLy){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM quan_ly WHERE tai_khoan = ? AND mat_khau = ?");
            ps.setString(1, quanLy.getTenDangNhap());
            ps.setString(2, quanLy.getMatKhau());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Tài khoản: " + rs.getString("tai_khoan") + " - " + "Mật khẩu: " + rs.getString("mat_khau"));
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    
}
