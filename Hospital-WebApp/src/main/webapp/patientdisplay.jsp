<%@ page import="java.util.*" %>

<html>
<head>
<title>Patients List</title>

<style>
body {
    font-family: Arial;
    background: #f4f6f9;
    margin: 0;
    background-image: url('Images/Hospital_Display.jpeg');
    background-size: cover;
    background-position: center;
}

/* TITLE */
h2 {
    text-align: center;
    margin-top: 20px;
    color: #333;
}

/* SEARCH ROW */
.search-row {
    width: 95%;
    margin: 10px auto;
    display: flex;
    justify-content: flex-end;
    margin-right: 120px;
}

/* SEARCH BOX */
.search-box {
    display: flex;
    align-items: center;
    background: white;
    border-radius: 25px;
    padding: 5px 10px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.15);
}

/* BACK BUTTON */
.back-btn {
    text-decoration: none;
    font-size: 30px;
    font-weight: bold;
    color: #007bff;
    margin-right: 8px;
}

.back-btn:hover {
    color: #0056b3;
}

/* INPUT */
.search-input {
    border: none;
    outline: none;
    padding: 8px;
    width: 200px;
}

/* SEARCH BUTTON */
.search-btn {
    border: none;
    background: #28a745;
    color: white;
    padding: 8px 14px;
    border-radius: 20px;
    cursor: pointer;
}

.search-btn:hover {
    background: #218838;
}

/* TABLE */
.tbl {
    margin: 25px auto;
    border-collapse: collapse;
    width: 85%;
    background: white;
    box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
}

.tbl th {
    background: #007bff;
    color: white;
    padding: 10px;
}

.tbl td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
}

.tbl tr:hover {
    background: #f1f1f1;
}

/* CRUD BUTTONS */
.crud-btn {
    display: inline-block;
    margin: 10px;
    padding: 10px 18px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.crud-btn:hover {
    background: #0056b3;
}

/* HOME BUTTON */
.home-btn {
    display: inline-block;
    margin: 20px;
    padding: 10px 18px;
    background: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.home-btn:hover {
    background: #218838;
}

/* NO DATA */
.nodata {
    text-align: center;
    color: red;
    margin-top: 20px;
}
</style>

</head>

<body>

<!-- TITLE -->
<h2>Patients List</h2>

<!-- SEARCH ROW -->
<div class="search-row">

    <form action="DisplayPatientsServlet" method="get" class="search-box">

        <!-- BACK -->
        <a href="DisplayPatientsServlet" class="back-btn">&#8592;</a>

        <!-- INPUT -->
        <input type="text" name="search" class="search-input"
        placeholder="Search ID or Name"
        value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">

        <!-- SEARCH -->
        <button type="submit" class="search-btn">Search</button>

    </form>

</div>

<%
@SuppressWarnings("unchecked")
ArrayList<String[]> list =
(ArrayList<String[]>) request.getAttribute("data");

if (list == null || list.isEmpty()) {
%>

<div class="nodata">No Patients Found</div>

<%
} else {
%>

<table class="tbl">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Admit Date</th>
    <th>Ailment</th>
    <th>Doctor</th>
</tr>

<%
for (String[] row : list) {
%>

<tr>
    <td><%= row[0] %></td>
    <td><%= row[1] %></td>
    <td><%= row[2] %></td>
    <td><%= row[3] %></td>
    <td><%= row[4] %></td>
    <td><%= row[5] %></td>
    <td><%= row[6] %></td>
</tr>

<%
}
%>

</table>

<%
}
%>

<!-- CRUD BUTTONS -->
<div style="text-align:center; margin-top:20px;">

    <a href="addPatient.jsp" class="crud-btn">Add Patients</a>
    
    <a href="patientdelete.jsp" class="crud-btn">Delete Patients</a>
    
    <a href="patientupdate.jsp" class="crud-btn">Update Patients</a>

</div>

<!-- HOME -->
<div style="text-align:center;">
    <a href="index.jsp" class="home-btn">Home</a>
</div>

</body>
</html>