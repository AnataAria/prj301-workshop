/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.IDAO;
import dao.UserDAO;
import model.User;

/**
 *
 * @author AnataArisa
 */
public class UserController {
    IDAO<User> usrDAO = new UserDAO();
    
    public boolean checkUserPass(User acc){
        if (acc != null) {
            String username = acc.getUsername();
            String password = acc.getPassword();
            User accQuery = usrDAO.read(username);
            if (accQuery != null) {
                if (accQuery.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public User readUser(String username){
        return usrDAO.read(username);
    }
    
    public boolean createUser(User user){
        return usrDAO.create(user);
    }
}
