<%@ page import="java.util.List" %>
<%@ page import="com.model.Patient" %>

<html>
<head>
<title>Patient Report</title>

<style>
body {
    font-family: Arial;
    background: #f4f6f9;
    margin: 0;
    background-image: url('Images/Report_Result.jpeg');
    background-size: cover;
    background-position: center;
}

/* HEADER */
.header {
    background: #2c3e50;
    color: white;
    padding: 15px;
    text-align: center;
    font-size: 22px;
}

/* CONTAINER */
.container {
    width: 90%;
    margin: 30px auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
}

/* TABLE */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

th {
    background: #3498db;
    color: white;
    padding: 12px;
}

td {
    padding: 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

tr:hover {
    background: #f1f1f1;
}

/* NO DATA */
.nodata {
    text-align: center;
    padding: 20px;
    color: red;
    font-size: 18px;
}

/* NAV BUTTONS */
.nav-buttons {
    text-align: center;
    margin-top: 20px;
}

.back-btn, .home-btn {
    display: inline-block;
    margin: 10px;
    padding: 10px 18px;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 14px;
}

/* BACK */
.back-btn {
    background: #007bff;
}

.back-btn:hover {
    background: #0056b3;
}

/* HOME */
.home-btn {
    background: #28a745;
}

.home-btn:hover {
    background: #1e7e34;
}
</style>

</head>

<body>

<div class="header">
     Hospital Management System - Patient Report
</div>

<div class="container">

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Admission Date</th>
    <th>Ailment</th>
    <th>Doctor</th>
</tr>

<%
@SuppressWarnings("unchecked")
List<Patient> list = (List<Patient>) request.getAttribute("list");

if (list != null && !list.isEmpty()) {

    for (Patient p : list) {
%>

<tr>
    <td><%= p.getPatientID() %></td>
    <td><%= p.getPatientName() %></td>
    <td><%= p.getAge() %></td>
    <td><%= p.getGender() %></td>
    <td><%= p.getAdmissionDate() %></td>
    <td><%= p.getAilment() %></td>
    <td><%= p.getAssignedDoctor() %></td>
</tr>

<%
    }

} else {
%>

<tr>
    <td colspan="7" class="nodata">No Records Found</td>
</tr>

<%
}
%>

</table>

</div>

<!-- BUTTONS -->
<div class="nav-buttons">

    <a href="report_form.jsp" class="back-btn">Back</a>
<br>
    <a href="index.jsp" class="home-btn">Home</a>

</div>

</body>
</html>