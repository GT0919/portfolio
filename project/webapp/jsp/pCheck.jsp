<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="student.Student" %>
     <%@ page import= "Score.StudentScore" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AcornAcademy 학사정보시스템</title>
<link rel="stylesheet" href="/project/css/main.css">

</head>
<body>
  <div id="header">
    <div class="wrapper1">
      <h1>
        <a href="" class="logo">
          <img src="../image/logo.png">
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
        <li><a href="">성적조회</a></li>
      </ul>
    </div>
    <div class="wrapper2">
      <div class="main">
        <p class="p1">학번/성명&nbsp;<input class="search" type="text"><button>찾기</button><input class="result" type="text">
        </p>
        <p class="p2">▣ 나의 성적</p>
        <table class="tbl">
          <thead>
            <tr>
              <th class="th1">순번</th>
              <th class="th2">성명</th>
              <th class="th3">아이디</th>
              <th class="th4">생일</th>
              <th class="th7">총점</th>
              <th class="th8">평균</th>
            </tr>
          </thead>
          
<%  ArrayList<Student> list  =(ArrayList<Student>) request.getAttribute("list");
	   ArrayList<StudentScore> list1 = (ArrayList<StudentScore>) request.getAttribute("list1");
for(int i=0;  i<list.size();  i++)  {
	Student s =  list.get(i);
	%>
	<%for(int j=0; j<list1.size(); j++){
		StudentScore ss = list1.get(j);
	if(s.getSnumber() == ss.getSnumber()){ %>
          <tbody>
            <tr>
              <td class="td1"><%=s.getSnumber()%></td>
              <td class="td2"><%=s.getName()%></td>
              <td class="td3"><%=s.getId()%></td>
              <td class="td4"><%=s.getBirthday()%></td>
              <td class="td7"><%=ss.getTotal()%></td>
              <td class="td8"><%=ss.getAvg()%></td>
            </tr>    <% }}} %>
          </tbody>
        </table>
        <p class="p3">
          ▣ 학기별 성적
          <select name="semester">
            <option value="none">== 선택 ==</option>
            <option value="v1">1학년 1학기</option>
            <option value="v2">1학년 2학기</option>
            <option value="v3">2학년 1학기</option>
            <option value="v4">2학년 2학기</option>
            <option value="v5">3학년 1학기</option>
            <option value="v6">3학년 2학기</option>
            <option value="v7">4학년 1학기</option>
            <option value="v8">4학년 2학기</option>
          </select>
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
            </tr>
          </thead>
          <tbody>
          
            <tr>
              <td class="td1"></td>
              <td class="td2"></td>
              <td class="td3"></td>
              <td class="td4"></td>
              <td class="td5"></td>
              <td class="td6"></td>
            </tr>
           
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
        <img src="../image/logo.png">
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