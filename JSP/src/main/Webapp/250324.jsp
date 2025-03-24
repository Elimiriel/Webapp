<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
Directive
<%page>metainfo of jsp about processings and transistions to server
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%include file="header.jsp"%>
include: include the file named header.jsp or html
<%taglib%>import the taglib: designate tag library: EL. JSTL
commands
    - language="java" : 해당 JSP 에서 사용되는 언어(java). 스크립트릿이나 표현식, 선언부를 작성할 때 사용할 script 프로그래밍 언어를 지정함.
    - contentType : 출력할 데이터의 MIME 타입과 문자 집합을 지정, JSP 페이지의 내용을 어떤 형태로 출력할지를 웹 브라우저에게 알려주는 역할.
        - charset : 문자(한글) 설정(UTF-8, EUC-KR)
                    ==> 설정하지 않으면 ISO-8859-1 을 사용함.
    - import : 다른 (lang)패키지에 있는 클래스를 가져다가 사용할 때 지정.
    - session : HttpSession 속성의 사용 여부를 지정. 형식) <%@ page Session="true" %>
    - isErrorPage : 에러 페이지인지의 여부를 지정.
    - errorPage : 에러가 발생했을 때 보여줄 에러페이지를 지정.
    - pageEncoding="UTF-8" : 현재 페이지의 문자(한글) 설정. 출력할 데이터의 문자 집합을 지정함.

scriptlet
<% %>java code
    - java code를 작성
    - java code를 작성할 때는 반드시 <% %>태그 사이에 작성해야 함.
    - java code를 작성할 때는 반드시 세미콜론(;)으로 문장을 끝내야 함.
    - java code를 작성할 때는 반드시 자바의 문법을 따라야 함.
    - java code를 작성할 때는 반드시 자바의 예약어를 사용해야 함.
    - java code를 작성할 때는 반드시 자바의 클래스, 메소드, 변수를 사용/생성할 수 있음.
    - <%= %>태그를 사용하여 출력할 수 있음.
    - <%! %>태그를 사용하여 전역변수, 메소드를 선언할 수 있음.
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% include file="header/including.jsp"%>
<% include file="header/putter.jsp"%>
<%--include: include the file named header.jsp or html or CSS--%>
<%--taglib: designate tag library: EL. JSTL--%>
<%--commands--%>
<%--language="java" : 해당 JSP 에서 사용되는 언어(java). 스크립트릿이나 표현식, 선언부를 작성할 때 사용할 script 프로그래밍 언어를 지정함.--%>
<%--contentType : 출력할 데이터의 MIME 타입과 문자 집합을 지정, JSP 페이지의 내용을 어떤 형태로 출력할지를 웹 브라우저에게 알려주는 역할.--%>
<%--charset : 문자(한글) 설정(UTF-8, EUC-KR)--%>
<%--==> 설정하지 않으면 ISO-8859-1 을 사용함.--%>
<%--import : 다른 (lang)패키지에 있는 클래스를 가져다가 사용할 때 지정.--%>
<%--session : HttpSession 속성의 사용 여부를 지정. 형식) <%@ page Session="true" %>--%>
<%--isErrorPage : 에러 페이지인지의 여부를 지정.--%>
<%--errorPage : 에러가 발생했을 때 보여줄 에러페이지를 지정.--%>
<%--pageEncoding="UTF-8" : 현재 페이지의 문자(한글) 설정. 출력할 데이터의 문자 집합을 지정함.--%>
<%--scriptlet--%>
<%--<% %>java code--%>
<%--    - java code를 작성--%>
<%--    - java code를 작성할 때는 반드시 <% %>태그 사이에 작성해야 함.--%>
<%--    - java code를 작성할 때는 반드시 세미콜론(;)으로 문장을 끝내야 함.--%>
<%--    - java code를 작성할 때는 반드시 자바의 문법을 따라야 함.--%>
<%--    - java code를 작성할 때는 반드시 자바의 예약어를 사용해야 함.--%>
<%--    - java code를 작성할 때는 반드시 자바의 클래스, 메소드, 변수를 사용/생성할 수 있음.--%>
<%--    - <%= %>태그를 사용하여 출력할 수 있음.--%>
<%--    - <%! %>태그를 사용하여 전역변수, 메소드를 선언할 수 있음.--%>
<div align="center">
<hr width="30%" color="red">
<h2>Inputs</h2>
<hr width="30%" color="red">
<form action='member'>
<table border="1">
<tr><th>ID</th>
<td><input type="text" name="id">
</td>
</tr>
<td><th>PW
</th>
<td><input type="text" name="pw">
</td>
</tr>
<td><th>PN
</th>
<td><input type="text" name="phone">
</td>
</tr>
<td><th>Addr
</th>
<td><input type="selectbox" name="addr">
<option value="서울">서울</option>
<option value="부산">부산</option>
<option value="대구">대구</option>
<option value="대전">대전</option>
<option value="광주">광주</option>
<option value="인천">인천</option>
<option value="울산">울산</option>
<option value="세종">세종</option>
<option value="경기">경기</option>
<option value="강원">강원</option>
<option value="충북">충북</option>
<option value="충남">충남</option>
<option value="전북">전북</option>
<option value="전남">전남</option>
<option value="경북">경북</option>
<option value="경남">경남</option>
<option value="제주">제주</option>
</td>
</tr>
<th>Hobby
<td>
    <input type="checkbox" name="hobby" value="여행">여행&nbsp;
    <input type="checkbox" name="hobby" value="독서">독서&nbsp;
    <input type="checkbox" name="hobby" value="산책">산책&nbsp;
    <input type="checkbox" name="hobby" value="수면">수면&nbsp;
    <input type="checkbox" name="hobby" value="게임">게임&nbsp;
    <input type="checkbox" name="hobby" value="TV">TV&nbsp;
    <%--checkbox becomes Array--%>
</td>
</th>
</td>
</tr>
<td colspan="2" align="center"><input type="submit" name="register">
<td colspan="2" align="center"><input type="reset" name="reset">
</td>
</table>
</form>

</div>
<div align="center">
<hr width="30%" color="red">
<h2>Java scriptlet</h2>
<%!
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String phone = request.getParameter("phone");
    String addr = request.getParameter("addr");
    String[] hobby = request.getParameterValues("hobby");
    String hobbyStr = "";
    if(hobby != null) {
        for(int i=0; i<hobby.length; i++) {
            hobbyStr += hobby[i] + " ";
        }
    }
    //console output, not page
    println("ID: " + id);
    println("PW: " + pw);
    println("PN: " + phone);
    println("Addr: " + addr);
    println("Hobby: " + hobbyStr);
    Calendar cal = Calendar.getInstance();//singleton only
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
    out.println("Current time: " + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second);
%>
<form action='member'>
<table border="1">
<tr><th>ID</th>
<td><%=id%></td>
</tr>
<td><th>PW
</th>
<td><%=pw%></td>
</td>
</tr>
<td><th>PN
</th>
<td><%=phone%></td>
</td>
</tr>
<td><th>Addr
</th>
<td><%=addr%></td>
<th>Hobby
<td><%=hobbyStr%></td>
</th>
<th>datetime</th>
<td><%=year%>/<%=month%>/<%=day%> <%=hour%>:<%=minute%>:<%=second%></td>
</tr>
<td colspan="2" align="center"><input type="submit" name="register">
<td colspan="2" align="center"><input type="reset" name="reset">
</td>
</table>
</form>

<%--MVC1: to another jsp--%>
<form method="post" action="250324_ext.jsp">
<table border="1">
<tr><th>ID</th>
<td><input type="text" name="id">
</td>
</tr>
<td><th>PW
</th>
<td><input type="text" name="pw">
</td>
</tr>
<td><th>PN
</th>
<td><input type="text" name="phone">
</td>
</tr>
<td><th>Addr
</th>
<td><input type="text" name="addr">
<th>Hobby
<td>
    <input type="checkbox" name="hobby" value="여행">여행&nbsp;
    <input type="checkbox" name="hobby" value="독서">독서&nbsp;
    <input type="checkbox" name="hobby" value="산책">산책&nbsp;
    <input type="checkbox" name="hobby" value="수면">수면&nbsp;
    <input type="checkbox" name="hobby" value="게임">게임&nbsp;
    <input type="checkbox" name="hobby" value="TV">TV&nbsp;
    <%--checkbox becomes Array--%>
</td>
</th>
</table>
</body>
</html>
