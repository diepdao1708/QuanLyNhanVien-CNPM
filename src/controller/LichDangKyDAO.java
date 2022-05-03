package controller;


import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import model.LichDangKy;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class LichDangKyDAO extends DAO{

    public LichDangKyDAO() {
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
            return false;
        }
    }
    
    public Boolean checkLichDangKy(int idNhanVien, Date ngay) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM lich_dang_ki WHERE id_nhan_vien = ? AND ngay = ?");
            ps.setInt(1, idNhanVien);
            ps.setDate(2, new java.sql.Date(ngay.getTime()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return false;
    }
}
