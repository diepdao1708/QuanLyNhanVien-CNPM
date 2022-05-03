/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.CheckInOut;

/**
 *
 * @author Admin
 */
public class CheckInOutDAO extends DAO{

    public CheckInOutDAO() {
    }
    
    public Boolean insertCheckIn(CheckInOut checkInOut){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO check_in_out(id_nhan_vien,gio_check_in,ngay) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, checkInOut.getNhanVien().getId());
            ps.setString(2, String.valueOf(checkInOut.getGioCheckIn()));
            ps.setDate(3, new java.sql.Date(checkInOut.getNgay().getTime()));
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Boolean checkCheckIn(CheckInOut checkInOut) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM check_in_out WHERE id_nhan_vien = ? AND ngay = ?");
            ps.setInt(1, checkInOut.getNhanVien().getId());
            ps.setDate(2, new java.sql.Date(checkInOut.getNgay().getTime()));
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
    
    public Boolean updateCheckOut(CheckInOut checkInOut){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE check_in_out SET gio_check_out = ? WHERE id_nhan_vien = ? AND ngay = ?");
            ps.setString(1, String.valueOf(checkInOut.getGioCheckOut()));
            ps.setInt(2, checkInOut.getNhanVien().getId());
            ps.setDate(3, new java.sql.Date(checkInOut.getNgay().getTime()));
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Boolean checkCheckOut(CheckInOut checkInOut) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM check_in_out WHERE id_nhan_vien = ? AND ngay = ? ");
            ps.setInt(1, checkInOut.getNhanVien().getId());
            ps.setDate(2, new java.sql.Date(checkInOut.getNgay().getTime()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("gio_check_out") == null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return false;
    }
}
