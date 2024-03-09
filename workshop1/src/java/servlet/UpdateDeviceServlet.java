/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import controller.MobileController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mobile;

/**
 *
 * @author AnataArisa
 */
public class UpdateDeviceServlet extends HttpServlet {

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

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deviceId = request.getParameter("deviceid");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        String name = request.getParameter("mobilename");
        int year = Integer.parseInt(request.getParameter("yearproduction"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean sale = Boolean.parseBoolean(request.getParameter("sale"));
        Mobile mobile = new Mobile(deviceId, description, price, name, year, quantity, sale);
        if (mc.updateMobileDevice(mobile)) {
            response.sendRedirect("home");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update mobile device failed !!!');");
            out.println("</script>");
            response.sendRedirect("home");
        }
    }
}
