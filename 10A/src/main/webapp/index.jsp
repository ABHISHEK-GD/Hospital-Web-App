<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Form</title>
    <style>
        .form-container {
            width: 300px;
            margin: 10px ;
            padding: 20px;
            border: 1px solid #ccc;
        }
        .form-field {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Enter User Data</h2>
        <form action="processUser" method="POST">
            <div class="form-field">
                <label for="username">Username       :</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-field">
                <label for="email">Email           :</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-field">
                <label for="designation">Designation     :</label>
                <input type="text" id="designation" name="designation" required>
            </div>
            <div class="form-field">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
</body>
</html>
