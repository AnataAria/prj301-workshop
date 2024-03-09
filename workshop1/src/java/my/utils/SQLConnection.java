/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AnataArisa
 */
public class SQLConnection {
    private Connection conn = null;
    private static SQLConnection instance;
    
    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(getURL(), MyConfig.USERNAME, MyConfig.PASSWORD);
            System.out.println("Connection successfully");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Connection failed");
        }
        return con;
    }
    public static SQLConnection Instance(){
        if(instance == null){
            instance = new SQLConnection();
        }
        return instance;
    }
    
    private String getURL(){
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:sqlserver://")
                .append(MyConfig.IP)
                .append(":")
                .append(MyConfig.PORT)
                .append(";databaseName=")
                .append(MyConfig.DB_NAME);
        return sb.toString();
    }
}
