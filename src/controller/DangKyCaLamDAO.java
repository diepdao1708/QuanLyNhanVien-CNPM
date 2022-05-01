package controller;


import controller.DAO;
import static controller.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.LichDangKy;
import model.NhanVien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DangKyCaLamDAO extends DAO{

    public DangKyCaLamDAO() {
    }
    
    public boolean insertLichDangKy(LichDangKy lichDangKy){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO lich_dang_ki(id_nhan_vien,ca_sang,ca_toi,ngay,chap_nhan) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lichDangKy.getNhanVien().getId());
            ps.setBoolean(2, lichDangKy.getCaSang());
            ps.setBoolean(3, lichDangKy.getCaToi());
            ps.setDate(4, new java.sql.Date(lichDangKy.getNgay().getTime()));
            ps.setBoolean(5, lichDangKy.getChapNhan());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
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
