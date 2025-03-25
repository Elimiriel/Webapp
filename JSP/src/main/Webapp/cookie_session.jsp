<%@ language="java" contentType="text/html; charset=UTF-8" %>
<%
    // server side cookie receiving
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for(Cookie cookie : cookies) {
            out.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
            //out: output in jsp
        }
    }
    // duration time setting
    cookies.setMaxAge(60 * 60 * 24); //
    // server side session receiving
    HttpSession session = request.getSession();
    // session.getAttribute("name") : getAttribute("name") in session
    String name = (String)session.getAttribute("name");
    String db_name = "1234";
    // compare with db info
    if(name.equals(db_name)) {
        out.println("Welcome, " + name + "<br>");
        // go to main with session info
        session.setAttribute("name", name);
        RequestDispatcher rd = request.getRequestDispatcher("250325_main.jsp");
        rd.forward(request, response);
    } else {
        out.println("Welcome, Guest" + "<br>");
        RequestDispatcher rd = request.getRequestDispatcher("250325_login.jsp");
        rd.forward(request, response);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Cookie & Session</h1>
    <form action="cookie_session.jsp" method="post">
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