/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.UUID;

/**
 *
 * @author AnataArisa
 */
public class Book {
    private String id;
    private String name;
    private String des;
    private String author;
    private Date publicDate;

    public Book(String id) {
        this.id = id;
    }

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public Book(String id, String name, String des, String author, Date publicDate) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.author = author;
        this.publicDate = publicDate;
    }

    public Book(String name, String des, String author, Date publicDate) {
        this();
        this.name = name;
        this.des = des;
        this.author = author;
        this.publicDate = publicDate;
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

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }
}
