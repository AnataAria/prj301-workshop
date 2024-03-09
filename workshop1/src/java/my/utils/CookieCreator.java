/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.utils;

import enums.CookieType;
import factory.CookieFactory;
import javax.servlet.http.Cookie;
import model.ICookie;

/**
 *
 * @author AnataArisa
 */
public class CookieCreator {

    private static CookieCreator instance = null;
    private CookieFactory cf = new CookieFactory();

    public static CookieCreator Instance() {
        if (instance == null) {
            instance = new CookieCreator();
        }
        return instance;
    }

    public <T> Cookie createCookie(T data, CookieType type) {
        ICookie<T> ic = cf.getCookie(type);
        ic.loadData(data);
        Cookie cookie = new Cookie(type.name().toLowerCase(), ic.createCookieString());
        return cookie;
    }

    public <T> T decodeObject(CookieType type, Cookie[] cookieList) {
        if (cookieList != null) {
            for (Cookie c : cookieList) {
                if(c.getName().equals(type.name().toLowerCase())){
                    ICookie<T> ic = cf.getCookie(type);
                    return ic.decodeCookieString(c.getValue());
                }
            }
        }
        return null;
    }
}
