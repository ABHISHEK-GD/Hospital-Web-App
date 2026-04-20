<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<html>
<body>

<%
String name = request.getParameter("uname");

// store in session
session.setAttribute("user", name);

// ✅ fixed 1 minute expiry
session.setMaxInactiveInterval(60);
%>

<h2>Hello <%= name %>!</h2>

<p>Session started.</p>
<p>Session will expire in <b>1 minute</b>.</p>

<p>Click below within 1 minute OR wait to test expiry:</p>

<a href="<%= request.getContextPath() %>/second.jsp">
    Check Session
</a>

</body>
</html>