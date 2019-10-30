import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class formdb extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse rep)throws IOException,ServletException{
        rep.setContentType("text/html");
        PrintWriter pw=rep.getWriter();

        String name=req.getParameter("Name");
        String add=req.getParameter("address");
        String pin=req.getParameter("pin");
        String phno=req.getParameter("phno");
        String uname=req.getParameter("uname");
        String pass=req.getParameter("pass");


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trip", "root", "h2000");

            Statement st=con.createStatement();
            int i=st.executeUpdate("insert into  reg values('"+name+"','"+add+"','"+pin+"','"+phno+"','"+uname+"','"+pass+"')");
            if(i>0){
                pw.println("<h2>"+"your record inserted"+"</h2>");
            }
        }
        catch(Exception e){
            pw.println(e);
        }
    }
}