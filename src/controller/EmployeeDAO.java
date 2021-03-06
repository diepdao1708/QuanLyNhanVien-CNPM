/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Employee;

public class EmployeeDAO extends DAO {

    public EmployeeDAO() {
    }
    
    public ArrayList<Employee> searchEmployee(String name) {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblEmployee WHERE name LIKE ?");
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employee employee = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNumber"), rs.getString("address"));
                listEmployee.add(employee);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listEmployee;
    }
    
    public Boolean checkEmployeeById(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblEmployee WHERE id = ?");
            ps.setInt(1, id);
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
