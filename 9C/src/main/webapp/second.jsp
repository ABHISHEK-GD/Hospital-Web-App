<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<html>
<body>

<h2>Session Status</h2>

<%
String name = (String) session.getAttribute("user");

if(name == null){
%>
    <p> Session expired!</p>
<%
} else {
%>
    <p> Hello <%= name %></p>
<%
}
%>

<br>
<a href="index.html">Go Back</a>

</body>
</html>