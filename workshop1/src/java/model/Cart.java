/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author AnataArisa
 */
public class Cart implements ICookie<Cart>{
    private List<String> cartList = new ArrayList();
    private String userID;

    public Cart(String userID) {
        this.userID = userID;
    }

    public Cart() {
    }
    
    

    public List<String> getCartList() {
        return cartList;
    }

    public void setCartList(List<String> cartList) {
        this.cartList = cartList;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public void addCard(String mobileID){
        this.cartList.add(mobileID);
    }

    @Override
    public String createCookieString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.userID);
        for(String o: this.cartList){
            sb.append("+")
                    .append(o);
        }
        return sb.toString();
    }

    @Override
    public Cart decodeCookieString(String cookieString) {
        StringTokenizer st  = new StringTokenizer(cookieString, "+");
        this.userID = st.nextToken();
        while(st.hasMoreElements()){
            this.cartList.add(st.nextToken());
        }
        return this;
    }

    @Override
    public void loadData(Cart data) {
        this.cartList = data.cartList;
        this.userID  = data.userID;
    }
}
