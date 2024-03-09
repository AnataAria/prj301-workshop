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
import model.Airplane;
import model.Book;
import utils.DBUtils;
/**
 *
 * @author AnataArisa
 */
public class AirplaneDAO implements IDAO<Airplane>{

    @Override
    public List<Airplane> getAll() {
String sql = "select * from PLANES;";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        List<Airplane> productList = null;
        Airplane temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            productList = new ArrayList<>();
            while(rs.next()){
                temp = new Airplane(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5)
                );
                productList.add(temp);
            }
        }catch(SQLException | ClassNotFoundException e){
            productList = null;
        }
        return productList;
    }

    @Override
    public Airplane create(Airplane data) {
String sql = "insert into PLANES values (?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement sm = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.prepareStatement(sql);
            sm.setString(1, data.getID());
            sm.setString(2, data.getFlightNumber());
            sm.setString(3, data.getDestination());
            sm.setDate(4, data.getDepart());
            sm.setInt(5, data.getStatus());
            if(sm.execute()){
                return data;
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airplane read(Airplane data) {
String sql = "select * from PLANES where id = ';" + data.getID() + "';";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        Airplane temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            while(rs.next()){
                temp = new Airplane(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5)
                );
            }
        }catch(SQLException | ClassNotFoundException e){
        }
        return temp;
    }

    @Override
    public Airplane update(Airplane data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Airplane delete(Airplane data) {
        String sql = "delete from PLANES where id = '" + data.getID()+ "';";
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
