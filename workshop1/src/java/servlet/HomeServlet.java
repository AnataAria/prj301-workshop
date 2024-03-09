/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.MobileController;
import enums.CookieType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Mobile;
import model.User;
import my.utils.CookieCreator;

/**
 *
 * @author AnataArisa
 */
public class HomeServlet extends HttpServlet {
    MobileController mc = new MobileController();
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookieList = request.getCookies();
        User acc = CookieCreator.Instance().decodeObject(CookieType.USER, cookieList);
        if(acc != null){
            request.setAttribute("username", acc.getUsername().toUpperCase());
            if(acc.getRole() != 0){
                request.setAttribute("adminui", "inline-block");
                request.setAttribute("userui", "none");
                List<Mobile> mobileList = mc.getAllMobileList();
                if(mobileList != null){
                    request.setAttribute("deviceList", mobileList);
                }
            }else{
                Cart cart = (Cart)request.getSession().getAttribute("cart");
                if(cart != null){
                    if(cart.getUserID().equals(acc.getUsername())){
                        List<Mobile> cartList = mc.searchMobileByID(cart.getCartList());
                        request.setAttribute("deviceListcad", cartList);
                    }
                }
                request.setAttribute("userui", "inline-block");
                request.setAttribute("adminui", "none");
                List<Mobile> mobileList = mc.getAllMobileList();
                if(mobileList != null){
                    request.setAttribute("deviceList", mobileList);
                }
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
