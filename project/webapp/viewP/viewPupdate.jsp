<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "teacher.TeacherTable" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
TeacherTable ta = (TeacherTable) request.getAttribute("protable");
%>

<form method="post" action="/project/updatePtable">
<table>
<tr><td>primary key</td><td><input type="text" name="pnumber" value="<%=ta.getpnumber()%>" readonly></td></tr>
<tr><td>아이디</td><td><input type="text" name="p_id" value="<%=ta.getp_id()%>"  readonly></td></tr>
<tr><td>비밀번호</td><td><input type="text" name="p_pw" value="<%=ta.getp_pw()%>" ></td></tr>
<tr><td>이름</td><td><input type="text" name="p_name" value="<%=ta.getp_name()%>" ></td></tr>
<tr><td>과목</td><td><input type="text" name="main" value="<%=ta.getMain()%>" ></td></tr>
<tr><td>반</td><td><input type="text" name="ban" value="<%=ta.getBan()%>" ></td></tr>
<tr><td><button>수정</button></td></tr>

</table>
</form>
</body>
</html>