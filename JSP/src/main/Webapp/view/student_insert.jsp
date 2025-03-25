<%@ language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert to DB</title>
</head>
<body>
<div>
<h3>Insert to DB</h3>
<%-- getContexPath(): current project --%>
<form action="<%request.getContexPath()%>/insert" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Insert"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>
    </table>
</div>
</body>