
<%-- create me a simple home page with 2 option showing add jobs and list all jobs--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #45a049;
        }
        h1 {
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: auto;
        }
        .options {
            display: flex;
            justify-content: center;
            flex-direction: column;
            align-items: center;
        }
        .option {
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to the Job Management System</h1>
    <div class="options">
        <div class="option">
            <a href="createJob" class="button">Add Job</a>
        </div>
        <div class="option">
            <a href="viewalljobs" class="button">List All Jobs</a>
        </div>
    </div>
    <p>Choose an option to get started!</p>
</div>
</body>
</html>
<%-- End of home.jsp --%>