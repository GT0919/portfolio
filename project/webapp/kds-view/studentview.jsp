<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="student.Student" %>
     <%@ page import= "Score.StudentScore" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Student s = (Student)request.getAttribute("s");
StudentScore sc = (StudentScore) request.getAttribute("score");
%>

<form method="post"  action="/project/updateScore2" >
<table>
<tr>
<td>번호</td>
<td><input type="text" name="snumber" value="<%=s.getSnumber()%>" readonly></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" value="<%=s.getName()%>" readonly></td>
</tr>
<tr>
<td>국어</td>
<td><input type="text" name="kor" value="<%=sc.getKor()%>" ></td>
</tr>
<tr>
<td>영어</td>
<td><input type="text" name="eng" value="<%=sc.getEng()%>" ></td>
</tr>
<tr>
<td>수학</td>
<td><input type="text" name="math" value="<%=sc.getMath()%>" ></td>
</tr>
<tr>
<td>총점</td>
<td><input type="text" name="total" value="<%=sc.getTotal()%>" readonly></td>
</tr>
<tr>
<td>평균</td>
<td><input type="text" name="avg" value="<%=sc.getAvg()%>" readonly></td>
</tr>
<tr>
<td><input type ="text" name ="score_num" placeholder="변경을 원하시면 score_num입력">
<td> <button>변경</button></td> 
</tr>
</table>
</form>
 
 
</body>
</html>