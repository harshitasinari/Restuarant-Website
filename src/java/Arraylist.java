/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

/**
 *
 * @author harshita
 */
@WebServlet(urlPatterns = {"/Arraylist"})
public class Arraylist extends HttpServlet {

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
        String dish=req.getParameter("ds");
        String usr=req.getParameter("us");
        String quantity=req.getParameter("plates");
        
        double total;
        try  {
            /* TODO output your page here. You may use following sample code. */
            ArrayList al=new ArrayList();
            al.add(dish);
            al.add(usr);
            al.add(quantity);
            
            
           
             Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select * from (dishes,user_details) where Name='"+dish+"' and user_id='"+usr+"' ");
                if(rs.next())
                {
                    String im=rs.getString("imge");
                    String pr=rs.getString("Price");
                    String dsh=rs.getString("Name");
                    String id=rs.getString("user_id");
                    double p=Double.parseDouble(pr);
                    total=p*Double.parseDouble((String)al.get(2));
                    
            out.println("<html><body><form action=AddToCart>");
            out.println("<table border=1 align=center>");
            out.println("<tr><td><img src=Images/"+im+" ></td><td align=center><input type=text value='"+dsh+"' name=ds></td></tr></table>");
            out.println("<table align=center>");
            out.println("<tr><td>user id:</td><td><input type=text value='"+id+"' name=us></td></tr>");
            out.println("<tr><td>number of plates:</td><td><input type=text value='"+al.get(2)+"' name=qu></td></tr>");
            out.println("<tr><td>price per plate:</td><td><input type=text value='"+pr+"' disabled=true name=pr></td></tr>");
            
            out.println("<tr><td>total price:</td><td><input type=text value='"+total+"'  name=tp></td></tr>");
            out.println("<tr><td>Order number:</td><td><input type=text name=on></td></tr>");
            
            out.println("<tr><td><input type=submit name=sub value=\"add to cart\"></td><td><a href=Home?x="+usr+" style=text-decoration:none >continue shopping</a></td></tr>");
            out.println("</table><table border=1 align=center>");
            out.println("<tr ><td  align=center><a href=ViewCart?x="+usr+"&y="+dish+" style=text-decoration:none >View Cart</a></td></tr>");  
                
                
                
            
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
