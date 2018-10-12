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
@WebServlet(urlPatterns = {"/Sign"})
public class Sign extends HttpServlet {

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
        String fname=req.getParameter("fn");
        String lname=req.getParameter("ln");
        String address=req.getParameter("ad");
        String pin=req.getParameter("pc");
        String contact=req.getParameter("cn");
        String email=req.getParameter("em");
        String userid=req.getParameter("uid");
        String password=req.getParameter("upass");
        String repassword=req.getParameter("repass");
        String acnumber=req.getParameter("ac");
        String acname=req.getParameter("an");
        String bankname=req.getParameter("bn");
        String ifsc=req.getParameter("ic");
        String bl=req.getParameter("ab");
        try  {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                int x=stm.executeUpdate("insert into user_details(first_name,last_name,address,pin_code,contact_number,email_id,user_id,account_number,password,repassword) values('"+fname+"','"+lname+"','"+address+"','"+pin+"','"+contact+"','"+email+"','"+userid+"','"+acnumber+"','"+password+"','"+repassword+"')");
           /* if(x>0)
           {
               res.sendRedirect("login.html");
               
           }
           else
           {
               out.println("not inserted");
           } */
           Statement stm1=cn.createStatement();
           int x1=stm1.executeUpdate("insert into bankdetails(account_number,account_name,bank_name,ifsc_code,balance) values('"+acnumber+"','"+acname+"','"+bankname+"','"+ifsc+"','"+bl+"')");
            if(x1>0&&x>0)
            {
               res.sendRedirect("login.html");
            }
             else
           {
               out.println("not inserted");
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
