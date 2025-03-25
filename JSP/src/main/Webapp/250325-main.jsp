<%@ language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Cookie & Session</h1>
    <div>
    <h2>
        ID: <% request.getParameter("id"); %><br>
        PW: <% request.getParameter("pw"); %><br>
        <a href="<%= request.getContextPath() %>/select">All List</a>
        %>
    </h2>
    </div>
    <div>
    <h2>ID_session: <%= session.getAttribute("id") %></h2>
    <h2>PW_session: <%= session.getAttribute("pw") %>
    </h2>
    </div>