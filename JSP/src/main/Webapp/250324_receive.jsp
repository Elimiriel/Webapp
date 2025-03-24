<#@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<hr width="30%" color="red">
<h3><%=request.getAttribute("name")님~%><br>
contact: <%=request.getAttribute("phone")%></h3>
</div>
</body>
</html>
<!--     - request.getParameter() : 입력한 데이터를 가져옴. -->