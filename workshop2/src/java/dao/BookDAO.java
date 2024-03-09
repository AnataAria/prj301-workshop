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
import model.Book;
import model.Product;
import utils.DBUtils;

/**
 *
 * @author AnataArisa
 */
public class BookDAO implements IDAO<Book>{

    @Override
    public List<Book> getAll() {
        String sql = "select * from BOOK;";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        List<Book> productList = null;
        Book temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            productList = new ArrayList<>();
            while(rs.next()){
                temp = new Book(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5)
                );
                productList.add(temp);
            }
        }catch(SQLException | ClassNotFoundException e){
            productList = null;
        }
        return productList;
    }

    @Override
    public Book create(Book data) {
        String sql = "insert into BOOK values (?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement sm = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.prepareStatement(sql);
            sm.setString(1, data.getId());
            sm.setString(2, data.getName());
            sm.setString(3, data.getDes());
            sm.setString(4, data.getAuthor());
            sm.setDate(5, data.getPublicDate());
            if(sm.execute()){
                return data;
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book read(Book data) {
        String sql = "select * from PRODUCT where id = ';" + data.getId() + "';";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        Book temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            while(rs.next()){
                temp = new Book(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5)
                );
            }
        }catch(SQLException | ClassNotFoundException e){
        }
        return temp;
    }

    @Override
    public Book update(Book data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Book delete(Book data) {
        String sql = "delete from BOOK where id = '" + data.getId() + "';";
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
