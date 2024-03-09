/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import my.utils.SQLConnection;

/**
 *
 * @author AnataArisa
 */
public class UserDAO implements IDAO<User> {

    @Override
    public List<User> getAll() {
        Connection connection = SQLConnection.Instance().getConnection();
        List<User> dataList = null;
        if (connection != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM [User];");
            try {
                Statement sm = connection.createStatement();
                ResultSet rs = sm.executeQuery(sb.toString());
                dataList = new ArrayList<>();
                User data = null;
                while (rs.next()) {
                    data = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("fullName"),
                            rs.getInt("role")
                    );
                    dataList.add(data);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return dataList;
    }

    @Override
    public boolean create(User data) {
        StringBuilder sb = new StringBuilder();
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            sb.append("INSERT INTO [User] VALUES ('")
                    .append(data.getUsername())
                    .append("','")
                    .append(data.getPassword())
                    .append("','")
                    .append(data.getFullName())
                    .append("','")
                    .append(data.getRole())
                    .append("');");
            sm.executeUpdate(sb.toString());
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public User read(String ID) {
        User data = null;
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM [User] WHERE userId =  '")
                    .append(ID)
                    .append("';");
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(sb.toString());
            if (rs.next()) {
                data = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        rs.getInt("role")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean update(User data) {
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE [User] SET ")
                    .append("password = '")
                    .append(data.getPassword())
                    .append("',fullName = '")
                    .append(data.getFullName())
                    .append("',role = '")
                    .append(data.getRole())
                    .append("' WHERE userId = '")
                    .append(data.getUsername())
                    .append("';");
            sm.executeUpdate(sb.toString());
            return true;
        } catch (SQLException ex) {

        }finally{
            
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try{
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            StringBuilder sb  = new StringBuilder();
            sb.append("DELETE [User] WHERE userId = '")
                    .append(id)
                    .append("';");
            sm.executeUpdate(sb.toString());
            return true;
        }catch(SQLException ex){
            
        }
        return false;
    }
}
