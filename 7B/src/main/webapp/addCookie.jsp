<%@ page language="java" import="javax.servlet.http.*" %>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Create Cookie
    Cookie cookie = new Cookie(name, domain);

    // Set Max Age
    cookie.setMaxAge(age);

    // Add Cookie to response
    response.addCookie(cookie);
%>

<h2>Cookie Successfully Added!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain(Value):</b> <%= domain %></p>
<p><b>Max Age:</b> <%= age %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>