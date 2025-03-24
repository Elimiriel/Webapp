<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function validate() {
   var id = document.frm.id.value;
   var pwd = document.frm.pwd.value;
   
   if(id == "") {
      alert("아이디를 입력하세요.");
      document.frm.id.focus();//focus on the input field
      return;//page move forcestop
   }
   
   if(pwd == "") {
      alert("비밀번호를 입력하세요.");
      document.frm.pwd.focus();//focus on the input field
      return;//page move forcestop
   }
   frm.method = "post";
   frm.action = "login";
   frm.submit();
   //document.frm.action = "login";
    //document.frm.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%-- 250324_formed.jsp
preprocessing via JScript --%>
<div align="center">
       <hr width="50%" color="blue">
          <h2>로그인 페이지</h2>
       <hr width="50%" color="blue">
       <br> <br>
       
       <form name="frm">
          <table border="1">
             <tr>
                <th>아이디</th>
                <td>
                   <input type="text" name="id">
                </td>
             </tr>
             
             <tr>
                <th>비밀번호</th>
                <td>
                   <input type="password" name="pwd">
                </td>
             </tr>
             
             <tr>
                <td colspan="2" align="center">
                   <input type="button" onclick="validate()" 
                          value="로그인">&nbsp;
                   <input type="reset" value="취소">
                </td>
             </tr>
          </table>
       </form>
       
    </div>
</body>
</html>