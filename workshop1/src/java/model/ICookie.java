/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author AnataArisa
 */
public interface ICookie<T> {
    public String createCookieString();
    public T decodeCookieString(String cookieString);
    public void loadData(T data);
}
