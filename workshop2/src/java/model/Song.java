/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author AnataArisa
 */
public class Song {
    private String id;
    private String name;
    private String des;
    private String author;
    private String link;
    private Date createDate;

    public Song(String name, String des, String author, String link) {
        this();
        this.name = name;
        this.des = des;
        this.author = author;
        this.link = link;
        this.createDate = Date.valueOf(LocalDate.now());
    }

    public Song(String id, String name, String des, String author, String link, Date createDate) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.author = author;
        this.link = link;
        this.createDate = createDate;
    }
    
    public Song(String id){
        this.id = id;
    }

    public Song() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
