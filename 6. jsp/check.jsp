<%@page import="java.sql.*,java.util.* "%>

<%
    String ans1= request.getParameter("ans1");
    String ans2= request.getParameter("ans2");
    String ans3= request.getParameter("ans3");
    String ans4= request.getParameter("ans4");
    String ans5= request.getParameter("ans5");
    String ans6= request.getParameter("ans6");
    String ans7= request.getParameter("ans7");
    
    Class.forName("com.mysql.jdbc.Driver");

    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "h2000");
    int i=1,mark=0,crt=0;

    try{
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select * from ques");
        while(rs.next()){
            if(i==1){
                String str1=rs.getString(2);
                if(str1.equals(ans1)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==2){
                String str2=rs.getString(2);
                if(str2.equals(ans2)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==3){
                String str3=rs.getString(2);
                if(str3.equals(ans3)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==4){
                String str4=rs.getString(2);
                if(str4.equals(ans4)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==5){
                String str5=rs.getString(2);
                if(str5.equals(ans5)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==6){
                String str6=rs.getString(2);
                if(str6.equals(ans6)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            if(i==7){
                String str7=rs.getString(2);
                if(str7.equals(ans7)){
                    mark=mark+5;
                    crt=crt+1;
                }
            }
            i++;
        }

        String name=(String)session.getAttribute("user");
        out.println("<h4>"+name+"   your results"+"</h4>");
        out.println("correct answers "+ crt+"<br>");
        out.println("marks"+mark);
        
    }
    catch(Exception e){
        e.printStackTrace();
    }
%>