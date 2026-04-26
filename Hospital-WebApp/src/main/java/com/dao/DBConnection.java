package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_db",
                "root",
                "password"   // change password if needed
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
 }
    
