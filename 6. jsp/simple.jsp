<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.*,java.util.*"%>
<!doctype html>
<html>
<body>
<% 
    String sname=request.getParameter("sname");
    String fname=request.getParameter("fname");
    String dob=request.getParameter("dob");
    String address=request.getParameter("address");
    String phone=request.getParameter("phone");
    String email=request.getParameter("email");
    String mark=request.getParameter("mark");
    String place=request.getParameter("place");

    String authkey = "130txy7WyB5820xxx82d3";
    String senderId = "ABCDEF";
    String message = "you have been registered successfully";
    String mobiles = "8300673200";
    String route="4";

    URLConnection myURLConnection=null;
    URL myURL=null;
    BufferedReader reader=null;
    String encoded_message=URLEncoder.encode(message);
    String mainUrl="http://api.msg91.com/api/sendhttp.php?";
    StringBuilder sbPostData= new StringBuilder(mainUrl);
    
    sbPostData.append("authkey="+authkey);
    sbPostData.append("&mobiles="+mobiles);
    sbPostData.append("&message="+encoded_message);
    sbPostData.append("&route="+route);
    sbPostData.append("&sender="+senderId);
    mainUrl = sbPostData.toString();
    

    try{
    
       
       // myURL = new URL(mainUrl);
        //myURLConnection = myURL.openConnection();
        //myURLConnection.connect();
        //reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
        //String success="Your message sent sucessfully";
        //out.println(success);
        //reader.close();

        //database
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "h2000");
        Statement st=conn.createStatement();

        int i=st.executeUpdate("insert into register(sname,fname,dob,address,phone,email,mark,place)values('"+sname+"','"+fname+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+mark+"','"+place+"')");
        out.println("Data is successfully inserted!");
        response.sendRedirect("signup.html");
        
    }
    catch (IOException e){
        e.printStackTrace();
    }
    catch(Exception ee){
        ee.printStackTrace();
    }


    out.println("NAME         :"+sname+"<br>");
    out.println("FATHER'S NAME:"+fname+"<br>");
    out.println("DOB          :"+dob+"<br>");
    out.println("ADDRESS      :"+address+"<br>");
    out.println("PHONE        :"+phone+"<br>");
    out.println("EMAIL        :"+email+"<br>");
    out.println("MARK         :"+mark+"<br>");
    out.println("PLACE        :"+place+"<br>");
%>

</body>
</html>