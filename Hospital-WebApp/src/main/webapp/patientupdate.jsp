<!DOCTYPE html>
<html>
<head>
<title>Update Patient</title>

<style>
body {
    font-family: Arial;
    background: #f4f6f9;
    text-align: center;
    padding-top: 50px;
     /* BACKGROUND IMAGE */
    background-image: url('Images/Hospital_Update.jpeg');
    background-size: cover;
    background-position: center;
   
}

/* INPUT + SELECT */
input, select {
    padding: 10px;
    margin: 8px;
    width: 250px;
    box-sizing: border-box;
    font-size: 14px;
}

/* COMMON BUTTON STYLE */
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

/* REMOVE DEFAULT BUTTON STYLE */
button.btn {
    appearance: none;
}

/* GREEN BUTTON */
.btn-green {
    background-color: #28a745;
}

.btn-green:hover {
    background-color: #218838;
}

/* HOME BUTTON */
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

<h2>Update Patient Data</h2>

<form action="UpdatePatientServlet" method="post">

<input type="number" name="id" placeholder="Patient ID" required />
<br>

<input type="text" name="name" placeholder="New Patient Name" required />
<br>

<input type="number" name="age" placeholder="New Age" required />
<br>

<select name="gender" required>
    <option value="">Select Gender</option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <option value="Other">Other</option>
</select>
<br>

<input type="date" name="date" required />
<br>

<input type="text" name="ailment" placeholder="Ailment" required />
<br>

<input type="text" name="doctor" placeholder="Doctor" required />
<br>

<button type="submit" class="btn btn-green">Update</button>

</form>
<!-- ✅ NEW BUTTON -->
<a href="DisplayPatientsServlet" class="btn btn-green">View Patients</a>

<br>

<a href="index.jsp" class="home-link">Home</a>

</body>
</html>