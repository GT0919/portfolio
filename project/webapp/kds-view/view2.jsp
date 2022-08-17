<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="student.Student" %>
    <%@ page import= "Score.StudentScore" %>
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
    }

    .tbl tr {
      height: 22px;
    }

    .tbl td {
      border: 1px solid black;
      font-size: 16px;
      font-weight: 700;
      overflow: hidden;
      padding: 10px 5px;
      text-align: center;
      vertical-align: top;
      word-break: normal;
      height: 22px;
      line-height: 35px;
    }

    thead .td1 {
      width: 150px;
      background: #d2d2d2;
    }

    tbody .td2 {
      width: 150px;
    }
  </style>
</head>
<body>

<table class="tbl">
<thead>
<tr>
<td class="td1">번호</td>
<td class="td1">아이디</td>
<td class="td1">이름</td>
<td class="td1">생일</td>
<td class="td1">반</td>
<td class="td1">국어</td>
<td class="td1">영어</td>
<td class="td1">수학</td>
<td class="td1">합계</td>
<td class="td1">평균</td>
<td class="td1">score_num</td>
</tr>
</thead>
<%  ArrayList<Student> list  =(ArrayList<Student>) request.getAttribute("list");
	   ArrayList<StudentScore> list1 = (ArrayList<StudentScore>) request.getAttribute("list1");
for(int i=0;  i<list.size();  i++)  {
	Student s =  list.get(i);
	%>
	<%for(int j=0; j<list1.size(); j++){
		StudentScore ss = list1.get(j);
	if(s.getSnumber() == ss.getSnumber()){ 
		int totaltmp = ss.getKor()+ ss.getEng()+ss.getMath();
	    double tmpavg =    (totaltmp/3.0);  
	    double tmp =     (Math.round(tmpavg*10)/10.0);        %>
	<tbody>
	<tr>
	<td class="td2"><%= s.getSnumber() %></td>
	<td class="td2"><%= s.getId() %></td>
	<td class="td2"><%= s.getName() %></td>
	<td class="td2"><%= s.getBirthday() %></td>
	<td class="td2"><%= s.getBan() %></td>	
	<td class="td2"><%= ss.getKor() %></td>
	<td class="td2"><%= ss.getEng() %></td>
	<td class="td2"><%= ss.getMath() %></td>
	<td class="td2"><%= ss.getKor()+ ss.getEng()+ss.getMath() %></td>
	<td class="td2"><%= tmp  %></td>
	<td class="td2"><%= ss.getScore_num() %></td>
	</tr>
	</tbody>	
	
<%} }} %>


</table>

</body>
</html>