<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>

<script>
function validateForm() {

    let f = document.forms["form"];

    if (f.roll.value.trim() === "" || f.name.value.trim() === "") {
        alert("Roll No and Name required");
        return false;
    }

    let subjects = ["s1","s2","s3","s4","s5"];

    for (let i = 0; i < subjects.length; i++) {
        let val = f[subjects[i]].value;

        if (val === "" || val < 0 || val > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }

    return true;
}
</script>

</head>
<body>

<h2>Student Marks Entry</h2>

<form name="form" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="roll"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="s1"><br>
Sub2: <input type="number" name="s2"><br>
Sub3: <input type="number" name="s3"><br>
Sub4: <input type="number" name="s4"><br>
Sub5: <input type="number" name="s5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>