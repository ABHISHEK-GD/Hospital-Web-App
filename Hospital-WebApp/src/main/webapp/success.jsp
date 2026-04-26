<!DOCTYPE html>
<html>
<head>
<title>Success</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f6f9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.card {
    background: white;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
}

h2 {
    color: #28a745;
    margin-bottom: 20px;
}

a {
    display: inline-block;
    margin-top: 10px;
    padding: 10px 20px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 6px;
}

a:hover {
    background: #0056b3;
}
</style>

</head>

<body>

<div class="card">
    <h2> Patient Added Successfully!</h2>
    <a href="addPatient.jsp">Add Another Patient</a>
    <br><br>
    <a href="DisplayPatientsServlet">View Patients</a>
</div>

</body>
</html>