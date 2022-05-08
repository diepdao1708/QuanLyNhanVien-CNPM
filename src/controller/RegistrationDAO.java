package controller;

import static controller.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Employee;
import model.Registration;

public class RegistrationDAO extends DAO{

    public RegistrationDAO() {
    }
    
    public boolean addRegistration(Registration registration){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblRegistration(tblEmployeeId,morningShift,nightShift,day,accepted) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, registration.getTblEmployeeid());
            ps.setBoolean(2, registration.getMorningShift());
            ps.setBoolean(3, registration.getNightShift());
            ps.setDate(4, new java.sql.Date(registration.getDay().getTime()));
            ps.setBoolean(5, registration.getAccepted());
           
            ps.executeUpdate();
            System.out.println("addRegistration -> true");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public ArrayList<Registration> checkRegistration(Employee employee, Date firstDayNextWeek, Date lastDayNextWeek) {
        ArrayList<Registration> registrations = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblRegistration WHERE tblEmployeeId = ? AND day >= ? AND day <= ?");
            ps.setInt(1, employee.getId());
            ps.setDate(2, new java.sql.Date(firstDayNextWeek.getTime()));
            ps.setDate(3, new java.sql.Date(lastDayNextWeek.getTime()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Registration registration = new Registration(rs.getInt("id"), rs.getInt("tblEmployeeId"), rs.getBoolean("morningShift"), rs.getBoolean("nightShift"), rs.getDate("day"), rs.getBoolean("accepted"));
                registrations.add(registration);
            }
            System.out.println("checkRegistration -> true");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return registrations;
    }
}
