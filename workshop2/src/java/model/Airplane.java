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
public class Airplane {
    private String ID;
    private String flightNumber;
    private String destination;
    private Date depart;
    private Integer status;//1 = onboard, 2 = departure, 3 == delayed

    public Airplane(String ID, String flightNumber, String destination, Date depart, Integer status) {
        this.ID = ID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.depart = depart;
        this.status = status;
    }

    public Airplane(String flightNumber, String destination, Date depart, Integer status) {
        this();
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.depart = depart;
        this.status = status;
    }

   public Airplane(String id){
       this.ID = id;
   }

    public Airplane() {
        this.ID = UUID.randomUUID().toString();
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
