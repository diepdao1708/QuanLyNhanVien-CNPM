/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection con;

    public DAO() {
        if(con == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=quanly;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
                con = DriverManager.getConnection(url);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}