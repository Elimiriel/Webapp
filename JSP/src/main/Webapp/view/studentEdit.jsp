<%@ language="java" contentType="text/html; charset=UTF-8" %>
<%
// import the StudentDTO class: get new student information
import com.dto.StudentDTO;
StudentDTO cont=(StudentDTO)request.getAttribute("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>Student Edit!</h3>
    <form action="update" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%=cont.getName()%>" readonly></td>
                <%-- readonly: cannot be changed --%>
            <%-- <td><input type="hidden" name="name" value="<%=cont.getName()%>"></td> hidden: can be changed --%>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="<%=cont.getAge()%>"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" value="<%=cont.getAddress()%>"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="<%=cont.getEmail()%>"></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value="<%=cont.getPhone()%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</body>
</html> 