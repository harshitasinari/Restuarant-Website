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
@WebServlet(urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

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
        String id=req.getParameter("x");
        
       
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from user_details where user_id='"+id+"' ");
           if(rs.next())
           {
               String fn=rs.getString("first_name");
               String ln=rs.getString("last_name");
               String address=rs.getString("address");
               String contact=rs.getString("contact_number");
               String email=rs.getString("email_id");
               String pin=rs.getString("pin_code");
               String uid=rs.getString("user_id");
               String passwd=rs.getString("password");
               String repass=rs.getString("repassword");
                String account=rs.getString("account_number");
               out.println("<html><body><form>");
               out.println("<table border=\"1\" align=\"center\" width=\"100%\" height=\"250\">\n" +
"<tr><td style=\"background-color: antiquewhite\">\n" +
"<h1 align=\"center\" ><font color=\"red\">Welcome to Restaurant</font></h1></td></tr>\n" +
"</table><table align=\"center\" width=\"50%\">\n" +
"<tr>\n" +
"                    <td>\n" +
"                        First Name:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"fname\" value='"+fn+"' disabled=true></td>\n" +
"</tr>\n" +
"<tr>\n" +
"                    <td>\n" +
"                        Last Name:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"lname\" value='"+ln+"' disabled=true></td>\n" +
"</tr>\n" +
"<tr>\n" +
"                    <td>\n" +
"                        Address:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"addrss\" value='"+address+"' disabled=true></td>\n" +
"</tr>\n" +
"<tr>\n" +
"                    <td>\n" +
"                        pin code:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"pinc\" value='"+pin+"' disabled=true></td>\n" +
"</tr>\n" +
"\n" +
"<tr>\n" +
"                    <td>\n" +
"                        Contact number:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"con\" value='"+contact+"' disabled=true></td>\n" +
"</tr>\n" +
"<tr>\n" +
"                    <td>\n" +
"                        Email Id:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"eml\" value='"+email+"' disabled=true></td>\n" +
"</tr>\n" +
"<tr>\n" +
"                    <td>\n" +
"                        User Id:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"usrid\" value='"+uid+"' disabled=true></td>\n" +
"</tr>\n"
               +
        "<tr>\n" +
"                    <td>\n" +
"                        Account Number:    \n" +
"                    </td>\n" +
"                    <td><input type=\"text\" name=\"ac\" value='"+account+"' disabled=true></td>\n" +
"</tr>\n"+
"                    <td>\n" +
"                        want to change details?    \n" +
"                    </td>\n" +
"                    <td><a href=UpdateUser?x="+uid+" style=text-decoration:none >update</a></td>\n" +
"</tr>\n"
               +
"                    <td>\n" +
"                        want to change details?    \n" +
"                    </td>\n" +
"                    <td><a href=UpdateBank?x="+account+" style=text-decoration:none >update bank details</a></td>\n" +
"</tr>\n");
              
                  out.println("</table>");
               
               out.println("</form></body></html>");
           }
           out.println("<html><body><table align=center>");
            out.println("<tr><td><a href=UpdateUser?x="+id+"  ></a></td></tr>");
            out.println("</table></body></html>");
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
