<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h2>Student Result</h2>

<%
String msg = (String) request.getAttribute("message");

if(msg.contains("Error")){
%>
    <p style="color:red;"><%= msg %></p>
<%
} else {
%>
    <p style="color:green;"><%= msg %></p>

    Roll No: <%= request.getAttribute("roll") %><br>
    Name: <%= request.getAttribute("name") %><br><br>

    Marks:<br>
    Sub1: <%= request.getAttribute("s1") %><br>
    Sub2: <%= request.getAttribute("s2") %><br>
    Sub3: <%= request.getAttribute("s3") %><br>
    Sub4: <%= request.getAttribute("s4") %><br>
    Sub5: <%= request.getAttribute("s5") %><br><br>

    Average: <%= request.getAttribute("avg") %><br>
    Result: <b><%= request.getAttribute("result") %></b>
<%
}
%>

<br><br>
<a href="index.jsp">Go Back</a>

</body>
</html>