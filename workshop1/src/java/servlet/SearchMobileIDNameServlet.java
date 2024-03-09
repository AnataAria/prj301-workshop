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
import model.Mobile;
import model.User;
import my.utils.CookieCreator;

/**
 *
 * @author AnataArisa
 */
public class SearchMobileIDNameServlet extends HttpServlet {

    MobileController mc = new MobileController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookieList = req.getCookies();
        User acc = CookieCreator.Instance().decodeObject(CookieType.USER, cookieList);
        if (acc != null) {
            if (acc.getRole() != 0) {
                String mobileId = req.getParameter("searchinput");
                req.setAttribute("adminui", "inline-block");
                req.setAttribute("userui", "none");
                List<Mobile> mobileList = mc.searchByIDOrName(mobileId);
                if(mobileList != null){
                    req.setAttribute("deviceList", mobileList);
                }
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
        }
        resp.sendRedirect("login");
    }

}
