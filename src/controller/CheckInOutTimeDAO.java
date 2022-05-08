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
import model.CheckInOutTime;

public class CheckInOutTimeDAO extends DAO{

    public CheckInOutTimeDAO() {
    }
    
    public Boolean insertCheckIn(CheckInOutTime checkInOutTime){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblCheckInOutTime(tblEmployeeId,checkInTime,day,shift) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, checkInOutTime.getTblEmployeeid());
            ps.setTimestamp(2, new java.sql.Timestamp(checkInOutTime.getDay().getTime()));
            ps.setDate(3, new java.sql.Date(checkInOutTime.getDay().getTime()));
            ps.setBoolean(4, checkInOutTime.getShift());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Boolean checkCheckIn(CheckInOutTime checkInOutTime) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblCheckInOutTime WHERE tblEmployeeId = ? AND day = ?");
            ps.setInt(1, checkInOutTime.getTblEmployeeid());
            ps.setDate(2, new java.sql.Date(checkInOutTime.getDay().getTime()));
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
    
    public Boolean updateCheckOut(CheckInOutTime checkInOutTime){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE tblCheckInOutTime SET checkOutTime = ? WHERE tblEmployeeId = ? AND day = ?");
            ps.setTimestamp(1, new java.sql.Timestamp(checkInOutTime.getDay().getTime()));
            ps.setInt(2, checkInOutTime.getTblEmployeeid());
            ps.setDate(3, new java.sql.Date(checkInOutTime.getDay().getTime()));
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public Boolean checkCheckOut(CheckInOutTime checkInOutTime) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblCheckInOutTime WHERE tblEmployeeId = ? AND day = ? ");
            ps.setInt(1, checkInOutTime.getTblEmployeeid());
            ps.setDate(2, new java.sql.Date(checkInOutTime.getDay().getTime()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("checkCheckOut -> true");
                return rs.getTime("checkOutTime") == null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
