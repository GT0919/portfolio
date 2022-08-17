<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="student.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//Student s = (Student)request.getAttribute("student");

%>

<form method="post"  action="/project/updateStudent.27" >
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id" value=""></td>
</tr>
<tr>
<td>패스워드</td>
<td><input type="text" name="pw" value=""></td>
</tr>
<tr>
<td> <button>변경</button></td> 
</tr>
</table>
</form>
 
 
</body>
</html>