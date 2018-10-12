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
import java.util.ArrayList;

/**
 *
 * @author harshita
 */
@WebServlet(urlPatterns = {"/Payment"})
public class Payment extends HttpServlet {

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
        String usr=req.getParameter("x");
        String amount=req.getParameter("y");
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from user_details where user_id='"+usr+"'");
               if(rs.next()){
                   String acnumber=rs.getString("account_number");
                    ArrayList al=new ArrayList();
                    al.add(acnumber);
                     String n=(String)al.get(0);
                      out.println("<html><body><form action=FinalPayment>");
                       out.println("<table align=center>");
                       
                   Statement stm1=cn.createStatement();
                   ResultSet rs1=stm1.executeQuery("select * from bankdetails where account_number='"+n+"'");
                   if(rs1.next())
                   {
                       String av_amount=rs1.getString("balance");
                      String ac_number=rs1.getString("account_number");
                      
                       out.println("<tr><td>Available balance:</td><td><input type=text value="+av_amount+" name=avl></td></tr>");
                       out.println("<tr><td><input type=text value="+ac_number+" name=acn hidden=true></td></tr>");
                   }
                   out.println("<tr><td>Amount to pay:</td><td><input type=text value="+amount+" name=amn></td></tr>");
                       out.println("<tr><td><input type=submit value=\"proceed to pay\"></td></tr>");
                       out.println("</form></table></body></html>");
                   
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
