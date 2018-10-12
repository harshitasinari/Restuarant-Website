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
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
        //String us=req.getParameter("y");
        
        String first,last;
        
        try  {
              Class.forName("com.mysql.jdbc.Driver");
                
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery("select (first_name) from user_details where user_id='"+id+"'");
                if(rs.next())
                {
                    first=rs.getString("first_name");
                    //last=rs.getString("last_name");
                    out.println("<html><body><table align=right border=1><tr><td align=center bgcolor=white >"+first+"</td></tr></table></body></html>");
                    
                } 
            /* TODO output your page here. You may use following sample code. */
            out.println("\n" +
"<html>\n" +
"    \n" +
"    <body>\n" +
"        <form>\n" +
"            <table  align=\"center\" width=\"100%\" height=\"350\">\n" +
"                <tr><td style=\"background-image: url(AtholPlace-Restaurant.jpg)\">\n" +
"                              <h1 align=\"center\" ><font color=\"red\">Welcome to Restaurant</font></h1></td></tr>\n" +
"            </table>\n" +
"            <table align=\"right\" width=\"20%\" height=\"10\" border=\"1\">\n" +
"                <tr>\n" );
          
           
           out.println("<td>\n" +
"                        <h5 align=\"center\"> <a href=Profile?x="+id+" style=\"text-decoration: none\">Profile</a></h5>\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <h5 align=\"center\"> <a href=\"first.html\" style=\"text-decoration: none\">Logout</a></h5>\n" +
"                    </td>\n" +
        "                    <td>\n" +
"                        <h5 align=\"center\"> <a href=ViewCart?x="+id+" style=\"text-decoration: none\">View Cart</a></h5>\n" +
"                    </td>\n"+
"                </tr>\n" +
"            </table>\n" +
"            <table align=\"center\" width=\"100%\" height=\"30\" border=\"1\">\n" +
"                        <tr><td>\n" +
"                                <h3 align=\"center\"> <a href=Veg?x="+id+" style=\"text-decoration: none\" >Indian veg</a></h3>\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <h3 align=\"center\"><a href=\"nonveg.html\" style=\"text-decoration: none\">Indian non-veg</a>  </h3>  \n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <h3 align=\"center\"> <a href=\"chinese.html\" style=\"text-decoration: none\">chinese</a></h3>\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <h3 align=\"center\">  <a href=\"beverages.html\" style=\"text-decoration: none\">beverages</a></h3>\n" +
"                    </td>\n" +
"                        </tr>\n" +
"            </table>\n" +
"        \n" +
"        </form>\n" +
"    </body>\n" +
"</html>\n" +
"");
           
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
