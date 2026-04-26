<!DOCTYPE html>
<html>
<head>
<title>Hospital Management System</title>

<style>
body {
    font-family: Arial;
    text-align: center;
    padding-top: 60px;

    /* BACKGROUND IMAGE */
    background-image: url('Images/Home_Interface.jpg');
    background-size: cover;
    background-position: center;
}

h1 {
    color: #007bff;
}

/* LOGO */
.logo {
    width: 130px;
    display: block;
    margin: 0 auto 20px auto;
}

/* BUTTON STYLE */
.btn {
    display: block;
    margin: 15px auto;
    padding: 10px;
    width: 220px;
    background: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.btn:hover {
    background: #0056b3;
}
</style>

</head>

<body>

<!-- LOGO -->
<img src="Images/Hospital_Logo.png" class="logo" alt="Hospital Logo">

<h1>Hospital Management System</h1>

<a href="DisplayPatientsServlet" class="btn">View Patients</a>
<a href="addPatient.jsp" class="btn">Add Patient</a>
<a href="patientdelete.jsp" class="btn">Delete Patient</a>
<a href="patientupdate.jsp" class="btn">Update Patient</a>
<a href="report_form.jsp" class="btn">Reports</a>

</body>
</html>