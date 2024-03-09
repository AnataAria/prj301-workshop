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
import model.Order;
import my.utils.SQLConnection;

/**
 *
 * @author AnataArisa
 */
public class OrderDAO implements IDAO<Order> {

    @Override
    public List<Order> getAll() {
        Connection connection = SQLConnection.Instance().getConnection();
        List<Order> dataList = null;
        if (connection != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Order;");
            try {
                Statement sm = connection.createStatement();
                ResultSet rs = sm.executeQuery(sb.toString());
                dataList = new ArrayList<>();
                Order data = null;
                while (rs.next()) {
                    data = new Order(
                            rs.getString("orderId"),
                            rs.getString("userId"),
                            rs.getString("mobileId"),
                            rs.getDate("orderdate")
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
    public boolean create(Order data) {
        StringBuilder sb = new StringBuilder();
        try {
            Connection connection = SQLConnection.Instance().getConnection();
            Statement sm = connection.createStatement();
            sb.append("INSERT INTO [Order] VALUES ('")
                    .append(data.getOrderId())
                    .append("','")
                    .append(data.getUserId())
                    .append("','")
                    .append(data.getMobileId())
                    .append("','")
                    .append(data.getOrderDate())
                    .append("');");
            System.out.println(sb.toString());
            sm.executeUpdate(sb.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order read(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Order data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
