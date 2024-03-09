/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author AnataArisa
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private String unit;
    private Integer quantity;
    private Double price;

    public Product(String id, String name, String description, String unit, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }



    public Product(String id) {
        this.id = id;
    }

    public Product(String name, String description, String unit, Integer quantity, Double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean isLowProduct() {
        return this.quantity < 10;
    }
    
    
}
