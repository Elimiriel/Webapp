<%@ language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>Student List!</h3>
    <table>
    <tr>
    <th>Name</th><th>age</th><th>address</th><th>address</th><th>email</th><tr>phone</tr>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("list");
        for(int i=0; i<list.size(); i++) {
            StudentDTO dto=list.get(i);
            // for output, close and reopen the scriptlets
            %>
            <tr>
            <td><%=dto.getName()%></td>
            <td><%=dto.getAge()%></td>
            <td><%=dto.getAddress()%></td>
            <td><%=dto.getEmail()%></td>
            <td><%=dto.getPhone()%></td>
            <td>
            <input type="button" value="수정" onclick="location.href='update?id=<%=dto.getName()%>'">
            <input type="button" value="삭제" onclick="location.href='delete?id=<%=dto.getName()%>'">
            </tr>
            <%
            // "location.href='update?id=<%=dto.getName()%>'" is query string, update if the name is the same
            // "location.href='delete?id=<%=dto.getName()%>'" is query string, delete if the name is the same
        } // end sublet to close the for loop
    %>
    <%--registering from init pass to register jsp page--%>
    <tr><input type="button" value="register" onclick="location.href='view/student_insert.jsp'"></tr>
</body>
</html>