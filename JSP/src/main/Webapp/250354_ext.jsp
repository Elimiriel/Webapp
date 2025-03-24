<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
String id = request.getParameter("id").trim();//trim() : front, end 공백제거
String pw = request.getParameter("pw").trim();
String phone = request.getParameter("phone").trim();
String addr = request.getParameter("addr").trim();
String[] hobby = request.getParameterValues("hobby").trim();
//compairing with db info, before diirect db communication
if(id.equals(db_id) && pw.equals(db_pw)) {
    /*
    request : 요청에 대한 정보를 가지고 있는 객체. 클라이언트로부터 요청을 받기 위한 객체-클라이언트로부터 요청을 받아들이는 객체 / forwarding: path not change, data change
    response : 응답에 대한 정보를 가지고 있는 객체. 클라이언트에게 응답을 보내기 위한 객체-클라이언트에게 지시를 내리는 객체 / redirecting: return to the first and go diff path
                without internal data. re-request to next page
    session : HttpSession 객체를 생성하여 사용할지 여부를 지정
    setAttribute: key, value
    */
    request.setAttribute("phone", phone);//response.setAttribute("phone", phone);
    request.setAttribute("addr", addr);//response.setAttribute("addr", addr);
    request.setAttribute("hobby", hobby);//response.setAttribute("hobby", hobby);
    RequestDispatcher rd=request.getRequestDispatcher("250354_receive.jsp")//RequestDispatcher rd=request.getRequestDispatcher("250354_receive.jsp");
    rd.forward(request, response);//forwarding to next page //rd.redirect(request, response);//redirecting to next page
    //response.sendRedirect("250354_receive.jsp");
} else {
    response.sendRedirect("250354.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<hr width="30%" color="red">
<%=
    id + "<br>" +
    pw + "<br>" +
    request.getParameter(phone).trim() + "<br>" + //backcalling
    addr + "<br>" +
    Arrays.toString(hobby)
%>
