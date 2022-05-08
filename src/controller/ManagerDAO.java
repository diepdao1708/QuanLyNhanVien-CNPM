/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Manager;

/**
 *
 * @author Admin
 */
public class ManagerDAO extends DAO {

    public ManagerDAO() {
    }
    
    public boolean checkLogin(Manager quanLy){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblManager WHERE username = ? AND password = ?");
            ps.setString(1, quanLy.getUsername());
            ps.setString(2, quanLy.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("checkLogin -> true");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return false;
    }
    
}
