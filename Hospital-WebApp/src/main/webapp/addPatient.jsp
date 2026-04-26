<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Add Patient</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    text-align: center;
     /* BACKGROUND IMAGE */
    background-image: url('Images/Hospital_Add.png');
    background-size: cover;
    background-position: center;
     
}

h2 {
    color: #333;
}

form {
    background: white;
    padding: 20px;
    margin: auto;
    width: 350px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

input, select {
    width: 90%;
    padding: 8px;
    margin: 8px 0;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

a {
    display: inline-block;
    margin-top: 15px;
    text-decoration: none;
    padding: 10px 20px;
    background: #28a745;
    color: white;
    border-radius: 5px;
}
</style>

</head>

<body>
<br>
<h2>Add Patient</h2>

<form action="AddPatientServlet" method="post">

    <input type="number" name="id" placeholder="Patient ID" required>

    <input type="text" name="name" placeholder="Patient Name" required>

    <input type="number" name="age" placeholder="Age" required>

    <select name="gender" required>
        <option value="">Select Gender</option>
        <option>Male</option>
        <option>Female</option>
    </select>

    <input type="date" name="date" required>

    <input type="text" name="ailment" placeholder="Ailment" required>

    <input type="text" name="doctor" placeholder="Assigned Doctor" required>

    <br><br>

    <button type="submit">Add Patient</button>

</form>

<a href="DisplayPatientsServlet">View Patients</a>
<br>
<a href="index.jsp">Home</a>
</body>
</html>