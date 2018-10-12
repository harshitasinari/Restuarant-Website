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
@WebServlet(urlPatterns = {"/Order"})
public class Order extends HttpServlet {

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
     //  String pass=req.getParameter("y");
        try  {
            /* TODO output your page here. You may use following sample code. */
            if(id!=null)
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                 ResultSet rs=stm.executeQuery("select * from (dishes,user_details) where user_id='"+id+"' ");
                out.println("<html><body>");
                out.println("<table  align=\"center\" width=\"100%\" height=\"350\">\n" +
"                \n" +
"                <tr><td style=\"background-image: url(AtholPlace-Restaurant.jpg)\">\n" +
"                              <h1 align=\"center\" ><font color=\"red\">All veg Dishes</font></h1></td></tr>\n" +
"            </table>");
                out.println("</body></html>");
                out.println("<html><body><table align=right width=100% height=50 border=1>");
                out.println("<tr><td align=center><a href=Home?x="+id+" style=text-decoration:none >Home</a></td>"
                        + "<td align=center><a href=first.html style=text-decoration:none >Logout</a></td>"
                        + "<td align=center><a href=Profile?x="+id+" style=text-decoration:none >Profile</a></td>"
                                + "<td align=center><a href=ViewCart?x="+id+" style=text-decoration:none >View Cart</a></td></tr>");
                out.println("</table></body></html>");
                 
                if(rs.next())
                {
                    String fn=rs.getString("first_name");
                      String nm=rs.getString("Name");
                   String im=rs.getString("imge");
                    String ds=rs.getString("Description");
                    String ct=rs.getString("category");
                    String pr=rs.getString("Price");
                    String ur=rs.getString("user_id");
                 //   String sh=rs.getString("show_site"); 
                    out.println("<html><body><table align=right border=1><tr><td align=center bgcolor=white >"+fn+"</td></tr></table></body></html>");
                   if(ct.equals("veg"))
                {
                   
                    out.println("<html><body>");
                    out.println("<table border=1><tr>");
                    
                    out.println("<td><img src=Images/"+im+"></td>");
                    out.println("<td ><input type=text value='"+nm+"'  disabled=true></td>");
                    out.println("<td ><input type=text value='"+ds+"'  disabled=true></td>");
                   
                    out.println("<td ><input type=text value='"+pr+"'  disabled=true></td>");
                    out.println("<td><a href=OrderVeg?z="+nm+"&x="+ur+" style=text-decoration:none>order now</a> </td>");
                    out.println("</tr></table>");
                    out.println("</body></html>");
                } 
                }
                while(rs.next())
                {
                    
                    String nm=rs.getString("Name");
                   String im=rs.getString("imge");
                    String ds=rs.getString("Description");
                    String ct=rs.getString("category");
                    String pr=rs.getString("Price");
                    
                   
                  
                 
                  
		if(ct.equals("veg"))
                {
                    out.println("<html><body>");
                    out.println("<table border=1><tr>");
                    
                    out.println("<td><img src=Images/"+im+"></td>");
                    out.println("<td ><input type=text value='"+nm+"'  disabled=true></td>");
                    out.println("<td ><input type=text value='"+ds+"'  disabled=true></td>");
                   
                    out.println("<td ><input type=text value='"+pr+"'  disabled=true></td>");
                    out.println("<td><a href=OrderVeg?z="+nm+"&x="+id+" style=text-decoration:none>order now</a> </td>");
                    out.println("</tr></table>");
                    out.println("</body></html>");
                }
                
                  
                }
            }
            else{
                 Class.forName("com.mysql.jdbc.Driver");
                out.println("<html><body>");
                out.println("<table  align=\"center\" width=\"100%\" height=\"350\">\n" +
"                \n" +
"                <tr><td style=\"background-image: url(AtholPlace-Restaurant.jpg)\">\n" +
"                              <h1 align=\"center\" ><font color=\"red\">All veg Dishes</font></h1></td></tr>\n" +
"            </table>");
                out.println("</body></html>");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                 
                ResultSet rs=stm.executeQuery("select * from dishes");
                while(rs.next())
                {
                    
                    String nm=rs.getString("Name");
                   String im=rs.getString("imge");
                    String ds=rs.getString("Description");
                    String ct=rs.getString("category");
                    String pr=rs.getString("Price");
                    
                   
                  
                 
                  
		if(ct.equals("veg"))
                {
                    out.println("<html><body>");
                    out.println("<table border=1><tr>");
                    
                    out.println("<td><img src=Images/"+im+"></td>");
                    out.println("<td ><input type=text value='"+nm+"'  disabled=true></td>");
                    out.println("<td ><input type=text value='"+ds+"'  disabled=true></td>");
                   
                    out.println("<td ><input type=text value='"+pr+"'  disabled=true></td>");
                    out.println("<td><a href=login.html style=text-decoration:none >order now</a> </td>");
                    out.println("</tr></table>");
                    out.println("</body></html>");
                }
                
                  
                }
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
