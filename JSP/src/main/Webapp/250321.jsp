<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8; URL=http://localhost:8080/JSP">
<title>Insert title here</title>
</head>
<body>
<!--HTML COMMENT, ctrl+shft+/ in eclipse -->
<%-- JSP Comment
Already wrapped with HTML form?
MVC2 pattern:
JSP sends Request to Serv, Serv comm with DB, Serv return to JSP results--%>
<h1>Init!</h1>
    <div align="center">
    <hr width="50%" color="blue">
    <h2>Account form</h2>
    <form method="get" action="LoginServlet">
    <%--get: show all infos to url, but lightweight
    post: security or tons of commands--%>
    <%--gathering and request sublet in action path--%>
    <tr>
    <th>ID</th>
    <td><input type="text" name="id"></td><%--save to varname id and send it to sublet:= Striing id="input in textbox"--%>
    <th>PW</th>
    <td><input type="text" name="pwd"></td>
    </tr>
    <td colspan="2" align="center"><input type="submit" value="login">&nbsp;
    <input type="reset" value="clear"></td>
    </form>
    </div>
    
</body>
</html>