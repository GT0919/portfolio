<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="student.Student" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>번호</td>
<td>아이디</td>
<td>패스워드</td>
<td>이름</td>
<td>생일</td>
<td>반</td>


</tr>
<%  ArrayList<Student> list  =(ArrayList<Student>) request.getAttribute("list");
for(int i=0;  i<list.size();  i++)  {
	Student s =  list.get(i);
	%>
	<tr>
	<td><%= s.getSnumber() %></td>
	<td><%= s.getId() %></td>
	<td><%= s.getPw() %></td>
	<td><%= s.getName() %></td>
	<td><%= s.getBirthday() %></td>
	<td><%= s.getBan() %></td>
	
	</tr>
<% } %>


</table>

</body>
</html>