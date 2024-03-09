/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Song;
import utils.DBUtils;
/**
 *
 * @author AnataArisa
 */
public class ProductDAO implements IDAO<Product>{

    @Override
    public List<Product> getAll() {
        String sql = "select * from PRODUCT;";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        List<Product> productList = null;
        Product temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            productList = new ArrayList<>();
            while(rs.next()){
                temp = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6)
                );
                productList.add(temp);
            }
        }catch(SQLException | ClassNotFoundException e){
            productList = null;
        }
        return productList;
    }

    @Override
    public Product create(Product data) {
        String sql = "insert into PRODUCT values (?,?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement sm = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.prepareStatement(sql);
            sm.setString(1, data.getId());
            sm.setString(2, data.getName());
            sm.setString(3, data.getDescription());
            sm.setString(4, data.getUnit());
            sm.setInt(5, data.getQuantity());
            sm.setDouble(6, data.getPrice());
            if(sm.execute()){
                return data;
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product read(Product data) {
        String sql = "select * from PRODUCT where id = ';" + data.getId() + "';";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        Product temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            while(rs.next()){
                temp = new Product(
                       rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6)
                );
            }
        }catch(SQLException | ClassNotFoundException e){
        }
        return temp;
    }

    @Override
    public Product update(Product data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Product delete(Product data) {
        String sql = "delete from PRODUCT where id = '" + data.getId() + "';";
        Connection conn = null;
        Statement sm = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            int row = sm.executeUpdate(sql);
            System.out.println(sql);
            if(row != 0){
                return data;
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
