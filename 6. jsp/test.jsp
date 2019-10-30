<html>
    <head>

    </head>
    <body style="background-color: cornsilk">
        <%String name =(String)session.getAttribute("user");
        out.println("<h3>"+"Welcome :"+name+"</h3>");
        %>
        <h1 style="text-align: center">EXAMINATION</h1>
        <form action="http://localhost:8080/me33/check.jsp" method="get">
        <p>
            <label>1. India is a federal union comprising twenty-nine states and how many union territories?</label><br>
            <input type="radio" name="ans1" value="a">6 <br>
            <input type="radio" name="ans1" value="b">7 <br>
            <input type="radio" name="ans1" value="c">8 <br>
            <input type="radio" name="ans1" value="d">9 <br>
        </p>
        <p>
            <label>2. Which of the following is the capital of Arunachal Pradesh?</label><br>
            <input type="radio" name="ans2" value="a">itanagar <br>
            <input type="radio" name="ans2" value="b">dispur <br>
            <input type="radio" name="ans2" value="c">imphal <br>
            <input type="radio" name="ans2" value="d">panaji <br>
        </p>
        <p>
            <label>3. What are the major languages spoken in Andhra Pradesh?</label><br>
            <input type="radio" name="ans3" value="a">english and telugu <br>
            <input type="radio" name="ans3" value="b">telugu and urudu <br>
            <input type="radio" name="ans3" value="c">telugu and kannada <br>
            <input type="radio" name="ans3" value="d">all of the above <br>
        </p>
        <p>
            <label>4. What is the state flower of Haryana?</label><br>
            <input type="radio" name="ans4" value="a">lotus <br>
            <input type="radio" name="ans4" value="b">rhododendron <br>
            <input type="radio" name="ans4" value="c">golden shower <br>
            <input type="radio" name="ans4" value="d">not declared <br>
        </p>
        <p>
            <label>5. In which state is the main language Khasi?</label><br>
            <input type="radio" name="ans5" value="a">Mizoram<br>
            <input type="radio" name="ans5" value="b">Nagaland <br>
            <input type="radio" name="ans5" value="c"> Meghalaya <br>
            <input type="radio" name="ans5" value="d">Tripura <br>
        </p>
        <p>
            <label>6. Which of the following states is not located in the North?</label><br>
            <input type="radio" name="ans6" value="a">jharkand <br>
            <input type="radio" name="ans6" value="b">jammu and kashmir <br>
            <input type="radio" name="ans6" value="c">himachal pradesh <br>
            <input type="radio" name="ans6" value="d">haryana <br>
        </p>
        <p>
            <label>7. Which is the largest coffee producing state of India?</label><br>
            <input type="radio" name="ans7" value="a">Kerala <br>
            <input type="radio" name="ans7" value="b">Tamil Nadu <br>
            <input type="radio" name="ans7" value="c">Karnataka <br>
            <input type="radio" name="ans7" value="d">Arunachal Pradesh <br>
        </p>
        <p><button>submit</button></p>
        </form>

    </body>
</html>