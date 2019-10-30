import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class formser extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
      res.setContentType("text/html");
      PrintWriter pw=res.getWriter();

      pw.println("<DOCTYPE html>\n"+"<html>\n"+"<head>\n"+"<title>\n"+"</title>\n"+
                    "</head>\n"+"<body>\n"+"<table border=\"1\"> <tr><td>NAME</td> <td>"+req.getParameter("Name")+"</td></tr>"+
                    "<tr><td>Address</td><td>"+req.getParameter("address")+"</td></tr>"+
                    "<tr><td>pincode</td><td>"+req.getParameter("pin")+"</td></tr>"+
                    "<tr><td>Mobile no</td><td>"+req.getParameter("phno")+"</td></tr>"+
                    "<tr><td>Uname</td><td>"+req.getParameter("uname")+"</td></tr>"+
                    "<tr><td></td><td>"+req.getParameter("pass")+"</td></tr></table>"+
                    
                    "</body>\n"+"</html>");
      pw.close();
  }

}

