
<%@page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/styles.css">
<script src="/js/scripts.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to My Web Application</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/scripts.js"></script>
</head>
<body>
    <header>
        <h1>Welcome to My Web Application</h1>
    </header>

    <main>
        <h2>Latest News</h2>
        <p>This is a simple web application built with JSP and JSTL.</p>

        <h1>Add Two Number</h1>
        <form action="addNumbers" method="post">
            <label for="num1">Number 1:</label>
            <input type="number" id="num1" name="num1" required>
            <br>
            <label for="num2">Number 2:</label>
            <input type="number" id="num2" name="num2" required>
            <br>
            <input type="submit" value="Add Numbers">
        </form>
    </main>
    <footer>
        <p>&copy; 2023 My Web Application</p>
    </footer>
    <script>
        // Example JavaScript code
        console.log("Welcome to My Web Application");

    </script>
</body>
</html>
<!-- End of src/main/webapp/index.jsp -->
