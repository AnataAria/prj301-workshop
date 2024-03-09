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
public class Order {
    private String orderId;
    private String userId;
    private String mobileId;
    private Date orderDate;

    public Order(String orderId, String userId, String mobileId, Date orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.mobileId = mobileId;
        this.orderDate = orderDate;
    }

    public Order(String userId, String mobileId) {
        this.userId = userId;
        this.mobileId = mobileId;
        this.orderId = UUID.randomUUID().toString();
        this.orderDate = Date.valueOf(LocalDate.now());
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
