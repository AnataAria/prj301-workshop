/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.UserController;
import enums.CookieType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import my.utils.*;

/**
 *
 * @author AnataArisa
 */
public class RegisterServlet extends HttpServlet {

    private UserController lc = new UserController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String note = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        User userIn = new User(username, password, fullname, 0);
        if(username.isEmpty() || password.isEmpty()){
            note = "username, password is empty, please check again !!!";
        }else if(lc.checkUserPass(userIn)){
            note = "username is already existed, please choice other name";
        }else{
            lc.createUser(userIn);
            Cookie o = CookieCreator.Instance().createCookie(userIn, CookieType.USER);
            response.addCookie(o);
            response.sendRedirect("home");
            return;
        }
        request.setAttribute("signupnote", note);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
