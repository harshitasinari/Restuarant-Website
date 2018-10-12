/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

/**
 *
 * @author harshita
 */
@WebServlet(urlPatterns = {"/DeleteCart"})
public class DeleteCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String on=req.getParameter("x");
        String ds=req.getParameter("y");
        
        try  {
            /* TODO output your page here. You may use following sample code. */
             Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from user_cart where order_number='"+on+"' and dish_name='"+ds+"'");
             if(rs.next())
             {
                 String dn=rs.getString("dish_name");
                 String un=rs.getString("user_id");
                 String qu=rs.getString("quantity");
                 String tp=rs.getString("total_price");
                 String or=rs.getString("order_number");
                 out.println("<html><body><form action=DeleteDish>");
                 out.println("<table>");
                 out.println("<tr><td>dish name:</td><td><input type=text value="+dn+" name=dsh></td></tr>");
                 out.println("<tr><td>user name:</td><td><input type=text value="+un+" name=usr></td></tr>");
                 out.println("<tr><td>number of plates:</td><td><input type=text value="+qu+" name=qua></td></tr>");
                 out.println("<tr><td>total price:</td><td><input type=text value="+tp+" name=pr></td></tr>");
                 out.println("<tr><td>order number:</td><td><input type=text value="+or+" name=od></td></tr>");
                 out.println("<tr><td>are you sure want to delete it from cart?</td><td align=center><input type=submit name=sub value=delete></td></tr>");
                 out.println("</table></form></body></html>");
             }
            
           
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
