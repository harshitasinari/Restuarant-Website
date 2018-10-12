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
@WebServlet(urlPatterns = {"/ViewCart"})
public class ViewCart extends HttpServlet {

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
        String user=req.getParameter("x");
        String dsh=req.getParameter("y");
        double total = 0;
        double tpp=0;
        
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            
            
                out.println("<html><body>");
                out.println(" <table  align=\"center\" width=\"100%\" height=\"350\">\n" +
"                <tr><td style=\"background-image: url(AtholPlace-Restaurant.jpg)\">\n" +
"                              <h1 align=\"center\" ><font color=\"red\">Welcome to Restaurant</font></h1></td></tr>\n" +
"            </table>");
                out.println("<table align=right border=1>");
                out.println("<tr><td><a href=Home?x="+user+" style=text-decoration:none >Home</a></td><td><a href=first.html style=text-decoration:none >Logout</a></td></tr>");
                out.println("</table>");
                out.println("</body></html>");
                
                 Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restuarant","root","");
            String sql="select * from user_cart where user_id='"+user+"'";
            
            if(sql!=null){
		Statement stm=cn.createStatement();
                ResultSet rs=stm.executeQuery(sql);
                while(rs.next())
                {
                    
                    String dish=rs.getString("dish_name");
                    String qu=rs.getString("quantity");
                    String tp=rs.getString("total_price");
                    String nm=rs.getString("user_id");
                    String on=rs.getString("order_number");
                 ArrayList al=new ArrayList();
                     al.add(dish);
                     al.add(tp);
                   String n=(String)al.get(0);
                   String t=(String)al.get(1);
                  double tppp=Double.parseDouble(t);
                   tpp=tppp+tpp;
                  Statement stm1=cn.createStatement();
                     ResultSet rs1=stm1.executeQuery("select * from dishes where Name='"+n+"'");
                    if(rs1.next()){
                        String im=rs1.getString("imge");
                        String di=rs1.getString("Name");
                        out.println("<html><body>");
                        out.println("<table border=1 >"); 
                        
                    out.println("<tr><td><img src=Images/"+im+"></td><td><input type=text  value='"+di+"'></td></tr>"); 
                    
                   // rs1.close();
                            }
                   
                    out.println("<tr><td>number of plates: <input type=text value='"+qu+"'></td><td rowspan=2 align=center ><a href=DeleteCart?x="+on+"&y="+dish+" style=text-decoration:none >Delete</a></td></tr>");
                    out.println("<tr><td>total price:<input type=text value='"+tp+"'></td></tr>");
                    
                    }
                out.println("</table></body></html>");
                
        out.println("<html><body>");
            out.println("<table align=center border=1>");
            out.println("<tr><td align=center>Total amount:</td><td align=center>"+tpp+"</td></tr>");
            out.println("<tr><td><a href=Veg?x="+user+" style=text-decoration:none >Continue Shopping</a></td><td><a href=Payment?x="+user+"&y="+tpp+" style=text-decoration:none >Proceed to payment</a></td></tr>");
            out.println("</table></body></html>");
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
