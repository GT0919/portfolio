<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "Score.StudentScore" %>
<%@ page import = "student.Student" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
}

.tbl {
  margin-top: 10px;
  border-collapse: collapse;
  border-spacing: 0;
  text-align: center;
  margin-left:200px
}

.tbl tr{
  height: 35px;
}

.tbl td {
  border: 1px solid black;
  font-size: 20px;
  font-weight: 700;
  overflow: hidden;
  padding: 10px 5px;
  text-align: center;
  vertical-align: top;
  word-break: normal;
  height: 20px;
  line-height: 35px;
}

.td1 {
  width: 150px;
  background: #d2d2d2;  
}

.td2 {
  width: 400px;
}

.td2 input{
  width: 400px;
  height: 28px;
}

button{
  margin-top: 15px;
  margin-left: 420px;
  width: 160px;
  height: 35px;
  font-size: 20px;
  border: 1px solid #d2d2d2;
  border-radius: 4px;
  background:  #87cefa;  
}

.btn1{  
  margin-left: 260px;
}
</style>
</head>
<body>
<% StudentScore ss= (StudentScore) request.getAttribute("score"); %>
<% ArrayList<Student> list  =(ArrayList<Student>) request.getAttribute("list"); %>

<form method="post" action="/project/updateScore">
<table class="tbl">
<tr>
<td class="td1">score_num</td>
<td class="td2"><input type="text" name="score_num" value="<%=ss.getScore_num()%>" readonly></td>
</tr>
<tr>
<td class="td1">snumber</td>
<td class="td2"><input type="text" name="snumber" value="<%=ss.getSnumber()%>" readonly></td>
</tr>
<%for(int i=0; i<list.size(); i++){ 
	if(ss.getSnumber() == list.get(i).getSnumber()){%>
<tr>
<td class="td1">이름</td>
<td class="td2"><input type="text" name="name" value="<%=list.get(i).getName()%>"  ></td>
</tr>
<%}}%>

<tr>
<td class="td1">국어</td>
<td class="td2"><input type="text" name="kor" value="<%=ss.getKor()%>" ></td>
</tr>
<tr>
<td class="td1">영어</td>
<td class="td2"><input type="text" name="eng" value="<%=ss.getEng()%>" ></td>
</tr>
<tr>
<td class="td1">수학</td>
<td class="td2"><input type="text" name="math" value="<%=ss.getMath()%>" ></td>
</tr>
<tr>
<td class="td1">합계</td>
<td class="td2"><input type="text" name="total" value="<%=ss.getTotal()%>" readonly></td>
</tr>
<tr>
<td class="td1">평균</td>
<td class="td2"><input type="text" name="avg" value="<%=ss.getAvg()%>" readonly></td>
</tr>

</table>
<button>수정</button>


</form>


</body>
</html>