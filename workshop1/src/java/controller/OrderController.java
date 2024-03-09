/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.IDAO;
import dao.OrderDAO;
import model.Order;

/**
 *
 * @author AnataArisa
 */
public class OrderController {
    IDAO<Order> orderDAO = new OrderDAO();
    public boolean createOrder(Order data){
        return orderDAO.create(data);
    }
}
