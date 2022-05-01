/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends DAO{

    public NhanVienDAO() {
    }
    
    public ArrayList<NhanVien> getNhanViens(String name) {
        ArrayList<NhanVien> nhanViens = new ArrayList<NhanVien>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM nhan_vien WHERE ten LIKE ?");
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id") + " - " + "Tên: " + rs.getString("ten"));
                NhanVien nhanVien = new NhanVien(rs.getInt("id"),rs.getString("ten"),rs.getString("email"),rs.getString("sdt"), rs.getString("dia_chi"));
                nhanViens.add(nhanVien);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanViens;
    }
    
    public NhanVien getNhanVienById(int id) {
        NhanVien nhanVien = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM nhan_vien WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id: " + rs.getInt("id") + " - " + "Tên: " + rs.getString("ten"));
                nhanVien = new NhanVien(rs.getInt("id"),rs.getString("ten"),rs.getString("email"),rs.getString("sdt"), rs.getString("dia_chi"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }
}
