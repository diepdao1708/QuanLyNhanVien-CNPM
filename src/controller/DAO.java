/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public static Connection con;

    public DAO() {
        if(con == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=cnpm;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
