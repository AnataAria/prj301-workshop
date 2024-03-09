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

/**
 *
 * @author AnataArisa
 */
public class RemoveServlet extends HttpServlet {

    MobileController mc = new MobileController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mobileId = request.getParameter("deviceid");
        if (mc.removeMobileDevice(mobileId)) {
            response.sendRedirect("home");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
       out.println("alert('Delete mobile device failed !!!');");
       out.println("</script>");
       response.sendRedirect("home");
        }
    }
}
