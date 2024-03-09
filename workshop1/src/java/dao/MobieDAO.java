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
import model.Mobile;
import model.User;
import my.utils.SQLConnection;

/**
 *
 * @author AnataArisa
 */
public class MobieDAO implements IDAO<Mobile> {

    @Override
    public List<Mobile> getAll() {
        Connection connection = SQLConnection.Instance().getConnection();
        List<Mobile> dataList = null;
        if (connection != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Mobile;");
            try {
                Statement sm = connection.createStatement();
                ResultSet rs = sm.executeQuery(sb.toString());
                dataList = new ArrayList<>();
                Mobile data = null;
                while (rs.next()) {
                    data = new Mobile(
                            rs.getString("mobileId"),
                            rs.getString("description"),
                            rs.getFloat("price"),
                            rs.getString("mobileName"),
                            rs.getInt("yearOfProduction"),
                            rs.getInt("quantity"),
                            rs.getBoolean("notSale")
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
    public boolean create(Mobile data) {
        StringBuilder sb = new StringBuilder();
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            sb.append("INSERT INTO Mobile VALUES ('")
                    .append(data.getMobileId())
                    .append("','")
                    .append(data.getDescription())
                    .append("','")
                    .append(data.getPrice())
                    .append("','")
                    .append(data.getMobileName())
                    .append("','")
                    .append(data.getYearOfProduction())
                    .append("','")
                    .append(data.getQuantity())
                    .append("','")
                    .append(data.isSale())
                    .append("');");
            sm.executeUpdate(sb.toString());
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public Mobile read(String ID) {
        Mobile data = null;
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Mobile WHERE mobileId =  '")
                    .append(ID)
                    .append("';");
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(sb.toString());
            if (rs.next()) {
                data = new Mobile(
                        rs.getString("mobileId"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("mobileName"),
                        rs.getInt("yearOfProduction"),
                        rs.getInt("quantity"),
                        rs.getBoolean("notSale")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean update(Mobile data) {
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE Mobile SET ")
                    .append("description = '")
                    .append(data.getDescription())
                    .append("',price = '")
                    .append(data.getPrice())
                    .append("',mobileName = '")
                    .append(data.getMobileName())
                    .append("',yearOfProduction = '")
                    .append(data.getYearOfProduction())
                    .append("',quantity = '")
                    .append(data.getQuantity())
                    .append("',notSale = '")
                    .append(data.isSale())
                    .append("' WHERE mobileId = '")
                    .append(data.getMobileId())
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
            sb.append("DELETE Mobile WHERE mobileId = '")
                    .append(id)
                    .append("';");
            sm.executeUpdate(sb.toString());
            return true;
        }catch(SQLException ex){
            
        }
        return false;
    }

}
