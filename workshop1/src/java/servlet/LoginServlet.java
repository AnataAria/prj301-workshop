/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.UserController;
import enums.CookieType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import my.utils.CookieCreator;

/**
 *
 * @author AnataArisa
 */
public class LoginServlet extends HttpServlet {
    UserController uc = new UserController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookieList = request.getCookies();
        User usr = CookieCreator.Instance().decodeObject(CookieType.USER, cookieList);
        if(usr == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            response.addCookie(CookieCreator.Instance().createCookie(usr, CookieType.USER));
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User usr  = new User(username, password);
        if(uc.checkUserPass(usr)){
            User current =  uc.readUser(username);
            Cookie cookie = CookieCreator.Instance().createCookie(current, CookieType.USER);
            response.addCookie(cookie);
            response.sendRedirect("home");
        }else{
            request.setAttribute("signinnote", "Username or password is incorrect, please check again");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }


}
