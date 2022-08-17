<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Score.StudentScore" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AcornAcademy 학사정보시스템</title>
<link rel="stylesheet" href="/project/css/s_main.css">
<style>
.p1{
  margin-top: 20px;
}

.tbl {
  margin-top: 10px;
  border-collapse: collapse;
  border-spacing: 0;
  text-align: center;
}

.tbl td {
  border: 1px solid black;
  font-family: Arial, sans-serif;
  font-size: 14px;
  overflow: hidden;
  padding: 10px 5px;
  word-break: normal;
}

.tbl th {
  border: 1px solid black;
  background-color: #d2d2d2;
  font-size: 16px;
  font-weight: 700;
  overflow: hidden;
  padding: 10px 5px;
  text-align: center;
  vertical-align: top;
  word-break: normal;
}

.tbl .th1 {
  width: 200px;
}

.tbl .th2 {
  width: 200px;
}

.tbl .th3 {
  width: 200px;
}

.tbl .th4 {
  width: 200px;
}

.tbl .th5 {
  width: 200px;
}

.tbl .th6 {
  width: 200px;
}

.tbl .th7 {
  width: 200px;
}
</style>
</head>
<body>
  <div id="header">
    <div class="wrapper1">
      <h1>
        <a href="" class="logo">
          <img src="/project/html/img/logo.png">
        </a>
      </h1>
      <ul class="top">
        <li><a href="">게시판</a>
          <ul class="drop">
            <li><a href="">공지사항</a></li>
            <li><a href="">이용안내</a></li>
            <li><a href="">주간식단표</a></li>
          </ul>
        </li>
        <li><a href="">마이페이지</a>
          <ul class="drop">
            <li><a href="">개인정보수정</a></li>
            <li><a href="">수강신청</a></li>
            <li><a href="">성적조회</a></li>
          </ul>
        </li>
        <li><a href="/project/logout">로그아웃</a></li>
      </ul>
    </div>
  </div>
  <div id="contents">
    <div class="wrapper1">
      <ul class="top">
        <li><a href="">전체석차</a></li>
        <li><a href="/project/sfindScore">성적조회</a></li>
      </ul>
    </div>
    <div class="wrapper2">
      <div class="main">                    
        <p class="p1">
          ▣ 전체 석차
        </p>
        <table class="tbl">
          <thead>
            <tr>
              <th class="th1">학생번호</th>
              <th class="th2">국어</th>
              <th class="th3">영어</th>
              <th class="th4">수학</th>
              <th class="th5">총점</th>
              <th class="th6">평균</th>
              <th class="th6">석차</th>
            </tr>
          </thead>
          <tbody>
          <%  ArrayList<StudentScore> list  =(ArrayList<StudentScore>) request.getAttribute("list");
				for(int i=0;  i<list.size();  i++)  {
					StudentScore s =  list.get(i); 
					//int tmptotal = s.getMath()+s.getEng()+s.getKor();
					//double tmpavg= tmptotal/3.0;
			%>
            <tr>
              <td class="td1"><%= s.getSnumber() %> </td>
              <td class="td2"><%= s.getKor() %></td>
              <td class="td3"><%= s.getEng() %></td>
              <td class="td4"><%= s.getMath() %></td>
              <td class="td5"><%= s.getTotal() %></td>
              <td class="td6"><%= s.getAvg() %></td>
              <td class="td7"><%= s.getRank() %></td>
            </tr>
            <% } %>
       
          </tbody>
        </table>
      </div>
    </div>
    <div class="wrapper3">
      <ul class="bottom">
        <li><a href="">고객센터</a></li>
      </ul>
    </div>
  </div>
  <div id="footer">
    <div class="wrapper4">
      <a href="http://www.acorncampus.co.kr/" class="emblem">
        <img src="/project/html/img/logo.png">
      </a>
      <div class="address">
        <ul>
          <li>
            <a href="">개인정보처리방침</a>
          </li>
        </ul>
        <span class="add">
          <span>서울특별시 마포구 양화로 122 AcornAcademy TEL.02-2231-6413</span>
        </span>
        <span class="copyright">COPYRIGHT(C)2022 ACORN ACADEMY. ALL RIGHTS RESERVED.
        </span>
      </div>
    </div>
  </div>
</body>
</html>