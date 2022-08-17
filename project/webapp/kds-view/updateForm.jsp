<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="member.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Member m = (Member)request.getAttribute("member");

%>

<form method="post"  action="/0420_/updateMember.20_" >
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="m_id" value="<%=m.getM_id()%>"></td>
</tr>
<tr>
<td>비번</td>
<td><input type="text" name="m_pw" value="<%=m.getM_pw()%>"></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="m_name" value="<%=m.getM_name()%>" readonly></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="m_tel" value="<%=m.getM_tel()%>" readonly></td>
</tr>
<tr>
<td>생일</td>
<td><input type="text" name="m_birthday" value="<%=m.getM_birthday()%> " readonly></td>
</tr>
<tr>
<td>포인트</td>
<td><input type="text" name="m_point" value="<%=m.getM_point()%>" readonly></td>
</tr>
<tr>
<td>고객등급</td>
<td><input type="text" name="m_grade" value="<%=m.getM_grade()%>" readonly></td>
</tr>
<tr>
<td> <button>변경</button></td> 
</tr>
</table>
</form>
 
 
</body>
</html>