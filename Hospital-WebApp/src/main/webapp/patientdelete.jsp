<!DOCTYPE html>
<html>
<head>
<title>Delete Patient</title>

<style>
body {
    font-family: Arial;
    background: #f4f6f9;
    text-align: center;
    padding-top: 100px;
     /* BACKGROUND IMAGE */
    background-image: url('Images/Hospital_Delete.jpeg');
    background-size: cover;
    background-position: center;
     
}

h2 {
    color: red;
}

input {
    padding: 10px;
    margin: 10px;
    width: 200px;
}

/* COMMON BUTTON STYLE (FOR BOTH <a> AND <button>) */
.btn {
    display: inline-block;
    width: 200px;
    padding: 10px 0;
    margin: 10px;
    border-radius: 5px;
    text-decoration: none;
    color: white;
    border: none;
    cursor: pointer;
    font-size: 16px;
    box-sizing: border-box;
}

/* REMOVE DEFAULT BUTTON DIFFERENCE */
button.btn {
    appearance: none;
}

/* DELETE = RED */
.btn-red {
    background-color: #dc3545;
}

.btn-red:hover {
    background-color: #c82333;
}

/* VIEW = BLUE */
.btn-blue {
    background-color: #007bff;
}

.btn-blue:hover {
    background-color: #0056b3;
}

/* HOME = OLD STYLE */
.home-link {
    display: inline-block;
    margin-top: 10px;
    padding: 10px 20px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 6px;
}
</style>

</head>

<body>

<h2>Delete Patient Data</h2>

<form action="DeletePatientServlet" method="post">
    <input type="number" name="patientId" placeholder="Enter Patient ID" required />
    <br>
    <button type="submit" class="btn btn-red">Delete</button>
</form>

<br>

<a href="DisplayPatientsServlet" class="btn btn-blue">View Patients</a>
<br>

<a href="index.jsp" class="home-link">Home</a>

</body>
</html>