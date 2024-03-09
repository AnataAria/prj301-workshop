/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import enums.CookieType;
import model.*;
import model.ICookie;
/**
 *
 * @author AnataArisa
 */
public class CookieFactory {
    
    public ICookie getCookie(CookieType type){
        ICookie temp = null;
        switch(type){
            case USER:
                temp = new User();
                break;
                
            case MOBILE:
                
                break;
                
            case CART:
                temp = new Cart();
                break;
        }
        return temp;
    }
}
