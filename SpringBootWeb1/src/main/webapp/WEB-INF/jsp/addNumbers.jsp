

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Numbers Result</title>
</head>
<body>
<h1>Add Two Numbers Result</h1>

<%
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");

    if (num1Str != null && num2Str != null) {
        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int sum = num1 + num2;

            out.println("<p>Number 1: " + num1 + "</p>");
            out.println("<p>Number 2: " + num2 + "</p>");
            out.println("<h2>Sum: " + sum + "</h2>");
        } catch (NumberFormatException e) {
            out.println("<p>Invalid input. Please enter valid numbers.</p>");
        }
    } else {
        out.println("<p>No numbers received.</p>");
    }
%>

<a href="/">Back to Home</a>
</body>
</html>
