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
import model.Song;
import utils.DBUtils;
/**
 *
 * @author AnataArisa
 */
public class SongDAO implements IDAO<Song> {

    @Override
    public List<Song> getAll() {
        String sql = "select * from SONG;";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        List<Song> songList = null;
        Song temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            songList = new ArrayList<>();
            while(rs.next()){
                temp = new Song(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)
                );
                songList.add(temp);
            }
        }catch(SQLException | ClassNotFoundException e){
            songList = null;
        }
        return songList;
    }

    @Override
    public Song create(Song data) {
        String sql = "insert into SONG values (?,?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement sm = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.prepareStatement(sql);
            sm.setString(1, data.getId());
            sm.setString(2, data.getName());
            sm.setString(3, data.getDes());
            sm.setString(4, data.getAuthor());
            sm.setString(5, data.getLink());
            sm.setString(6, data.getCreateDate().toString());
            if(sm.execute()){
                return data;
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Song read(Song data) {
        String sql = "select * from SONG where id = ';" + data.getId() + "';";
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        Song temp = null;
        try{
            conn = DBUtils.getConnection();
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
            while(rs.next()){
                temp = new Song(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)
                );
            }
        }catch(SQLException | ClassNotFoundException e){
        }
        return temp;
    }

    @Override
    public Song update(Song data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Song delete(Song data) {
        String sql = "delete from SONG where id = '" + data.getId() + "';";
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
