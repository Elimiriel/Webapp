<%@ target language="java" context type="text/html"; charset="utf-8"%>
<!DOCTYPE html>
<html lang="en" xmllang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center">
<hr width="30%" color="red">
<h2>Inputs</h2>
<hr width="30%" color="red">
<form action='member' name="frm" method="post">
<table border="1">
<tr><th>name:&nbsp;</th>
<td><input type="text" name="name">
</td>
</tr>
<td><th>Mathematics:&nbsp;</th>
<td><input type="number" name="smath"></td>
</td>
<tr><th>Science:&nbsp;</th>
<td><input type="number" name="sscience"></td>
</tr>
<tr><th>English:&nbsp;</th>
<td><input type="number" name="senglish"></td>
</tr>
<tr><th>History:&nbsp;</th>
<td><input type="number" name="shistory"></td>
</tr>
<tr><th>Geography:&nbsp;</th>
<td><input type="number" name="sgeography"></td>
</tr>
</table>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
</div>
</body>
</html>