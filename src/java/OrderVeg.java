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
@WebServlet(urlPatterns = {"/OrderVeg"})
public class OrderVeg extends HttpServlet {

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
        String nme=req.getParameter("z");
        String id=req.getParameter("x");
      //  String pss=req.getParameter("y");
        
        
        try  {
            
            /* TODO output your page here. You may use following sample code. */
            
            Class.forName("com.mysql.jdbc.Driver");
                out.println("<html><body>");
                out.println("<table  align=\"center\" width=\"100%\" height=\"350\">\n" +
"                \n" +
"                <tr><td style=\"background-image: url(AtholPlace-Restaurant.jpg)\">\n" +
"                              <h1 align=\"center\" ><font color=\"red\">Order Now</font></h1></td></tr>\n" +
"            </table>");
                out.println("</body></html>");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from (dishes,user_details) where Name='"+nme+"' and user_id='"+id+"' ");
                if(rs.next())
                {
                    String dish=rs.getString("Name");
                    String pr=rs.getString("Price");
                    
                    String im=rs.getString("imge");
                    String usr=rs.getString("user_id");
                    String fn=rs.getString("first_name");
                    String ln=rs.getString("last_name");
                    String ad=rs.getString("address");
                    String pc=rs.getString("pin_code");
                    String cnn=rs.getString("contact_number");
                    String em=rs.getString("email_id");
                   
                   
                    
                    out.println("<html><body><form action=Arraylist><table border=1 align=center>");
                    out.println("<tr><td><img src=Images/"+im+"></td><td align=center><input type=text value='"+dish+"' name=ds ></td></tr>");
                    out.println("<table align=center>");
                    out.println("<tr><td>User Id:</td><td align=center><input type=text value='"+usr+"' name=us><td></tr>");
                    out.println("<tr><td>number of Plates:</td><td align=center><select name=plates><option value=1>1</option><option value=2>2</option><option value=3>3</option><option value=4>4</option><td></tr>");
                    out.println("<tr><td colspan=2><input type=submit name=sub value=order></td></tr>");
                    
                    out.println("</table>");
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
