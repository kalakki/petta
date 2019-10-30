import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloForm4 extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
       // Create cookies for first and last names.      
           String fname="ashik";
           String mno="86949404";
           String lname="joel";
           String email="ashik@gmail.com";
           String date="07-06-2000";
      Cookie Name = new Cookie("first_name", fname);
      Cookie Phone_no = new Cookie("phone_no", mno);

      // Set expiry date after 24 Hrs for both the cookies.
      Name.setMaxAge(60*60*24);
      Phone_no.setMaxAge(60*60*24);

      // Add both the cookies in the response header.
      response.addCookie( Name );
      response.addCookie( Phone_no );


      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Using GET Method to Read Form Data";

         
      out.println("<html>\n");

            out.println("<head><title>" + title + "</title></head>\n" );

               out.println("<body bgcolor = \"#f0f0f0\">\n" );

               out.println("<h1 align = \"center\">" + title + "</h1>\n");

               out.println("<table border=1 align=center>\n");

               out.println ( "<tr><td><b>First Name</b>: </td><td>");

               out.println(fname + "</td></tr>\n");

               out.println (" <tr> <td><b>Last Name</b>: </td><td>");

               out.println(lname + "</td></tr>\n"); 

               out.println("<tr> <td><b>E-Mail</b>:</td><td> ");

               out.println(email + "</td></tr>\n");

               out.println("  <tr><td><b>Mobile Number</b>: </td><td>");

               out.println(mno + "</td></tr>\n");

               out.println("<tr><td><b>Date Of Birth</b>: </td><td>");

               out.println(date + "</td></tr>\n");
                 
                  
               out.println("</table>\n" +
            "</body>" +
         "</html>"
         );
   }
}