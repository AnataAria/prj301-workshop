/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.StringTokenizer;
import java.util.UUID;

/**
 *
 * @author AnataArisa
 */
public class User implements ICookie<User> {
    private String username;
    private String password;
    private String fullName;
    private int role;
    
    public User(){
    }

    public User(String username, String password, String fullName, int role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String createCookieString() {
        return getUsername() + "+"
                + getRole() + "+"
                + getFullName().replaceAll("\\s", "");
    }

    @Override
    public User decodeCookieString(String cookieString) {
        StringTokenizer st = new StringTokenizer(cookieString, "+");
        this.username = st.nextToken();
        this.role = Integer.parseInt(st.nextToken());
        this.fullName = st.nextToken();
        return this;
    }

    @Override
    public void loadData(User data) {
        this.username = data.getUsername();
        this.password = data.getPassword();
        this.fullName = data.getFullName();
        this.role = data.getRole();
    }
}
