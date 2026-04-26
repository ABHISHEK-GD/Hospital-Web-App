
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Reports</title>

<style>
body {
    font-family: Arial;
    text-align: center;
    margin-top: 50px;
    background: #f4f6f9;
     background-image: url('Images/Report_Form.jpeg');
    background-size: cover;
    background-position: center;
}

/* BLUE REPORT BUTTONS */
button {
    padding: 12px 18px;
    margin: 8px;
    cursor: pointer;
    background: #007bff;
    color: white;
    border: none;
    border-radius: 5px;   /* 🔥 less curve */
    font-size: 14px;
}

button:hover {
    background: #0056b3;
}

/* HOME BUTTON */
.home-btn {
    padding: 10px 18px;
    margin-top: 20px;
    display: inline-block;
    background: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;   /* 🔥 less curve */
    font-size: 14px;
}

.home-btn:hover {
    background: #1e7e34;
}

/* VIEW PATIENTS BUTTON */
.view-btn {
    padding: 10px 18px;
    margin-top: 10px;
    display: inline-block;
    background: #28a745;   /* 🔥 green */
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 14px;
}

.view-btn:hover {
    background: #1e7e34;
}

/* SECTION */
.section {
    display: none;
    margin-top: 20px;
}

/* INPUT STYLE */
input[type="text"],
input[type="date"] {
    padding: 10px 12px;
    width: 250px;
    font-size: 15px;
    border-radius: 6px;
    border: 1px solid #bbb;
    outline: none;
}

input[type="text"]:focus,
input[type="date"]:focus {
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0,123,255,0.3);
}

input[type="submit"] {
    padding: 10px 20px;   /* 🔥 bigger button */
    font-size: 15px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    background: #6c757d;  /* 🔥 grey */
    color: white;
}

input[type="submit"]:hover {
    background: #5a6268;   /* darker grey on hover */
}
</style>

<script>
function showSection(type) {

    document.getElementById("dateBox").style.display = "none";
    document.getElementById("ailmentBox").style.display = "none";
    document.getElementById("doctorBox").style.display = "none";

    if (type === 'date') {
        document.getElementById("dateBox").style.display = "block";
    }
    else if (type === 'ailment') {
        document.getElementById("ailmentBox").style.display = "block";
    }
    else if (type === 'doctor') {
        document.getElementById("doctorBox").style.display = "block";
    }
}
</script>

</head>

<body>

<h2>Patient Reports</h2>

<!-- BUTTONS -->
<button type="button" onclick="showSection('date')">Date Report</button>
<button type="button" onclick="showSection('ailment')">Ailment Report</button>
<button type="button" onclick="showSection('doctor')">Doctor Report</button>

<br><br>

<!-- DATE REPORT -->
<div id="dateBox" class="section">
    <form action="ReportServlet" method="post">
        From: <input type="date" name="fromDate">
        To: <input type="date" name="toDate">
        <input type="hidden" name="type" value="date">
        <br><br>
        <input type="submit" value="Generate Report">
    </form>
</div>

<!-- AILMENT REPORT -->
<div id="ailmentBox" class="section">
    <form action="ReportServlet" method="post">
        Ailment: <input type="text" name="ailment">
        <input type="hidden" name="type" value="ailment">
        <br><br>
        <input type="submit" value="Generate Report">
    </form>
</div>

<!-- DOCTOR REPORT -->
<div id="doctorBox" class="section">
    <form action="ReportServlet" method="post">
        Doctor: <input type="text" name="doctor">
        <input type="hidden" name="type" value="doctor">
        <br><br>
        <input type="submit" value="Generate Report">
    </form>
</div>
<br>
<!-- VIEW PATIENTS -->
<a href="DisplayPatientsServlet" class="view-btn">View Patients</a>
<br>
<!-- HOME -->
<a href="index.jsp" class="home-btn">Home</a>
</body>
</html>