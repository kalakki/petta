<%@page import="java.util.*,java.sql.* "%>

<%
        String userid= request.getParameter("userid");
        String pass=request.getParameter("pass");
        session.setAttribute("user",userid);

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "h2000");

        Statement st =conn.createStatement();

        ResultSet rs = st.executeQuery("select * from login where uname='" +userid+"'and pass='"+pass+"' ");

        try{
                rs.next();
                if(rs.getString("pass").equals(pass) && rs.getString("uname").equals(userid)){
                        response.sendRedirect("test.jsp");
                }
                else{
                        response.sendRedirect("signup.html");
                }
        }
        catch(Exception e){
                e.printStackTrace();
        }
%>
