<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    // server side cookie
    Cookie[] cookies = new Cookie("id", "1234");
    // duration time setting
    cookies.setMaxAge(60 * 60 * 24); // 1 day
    // trans to client
    response.addCookie(cookies);
    // server side session
    HttpSession session = request.getSession();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Cookie & Session</h1>
    <form action="250325_cookie_session.jsp" method="post">
        <input type="text" name="name" placeholder="이름을 입력하세요">
        <input type="submit" value="전송+쿠키확인">
    </form>
    <%
        String name = request.getParameter("name");
        if(name != null) {
            out.println("이름: " + name + "<br>");
            // 쿠키 생성: 
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(60 * 60 * 24); // 1일
            response.addCookie(cookie);
            // 세션 생성
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
        }
    %>
</body>
</html>