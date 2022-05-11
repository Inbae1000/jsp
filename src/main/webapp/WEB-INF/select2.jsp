<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.beans.*" %>
<%@ page import = "java.util.List" %>
<meta charset="UTF-8">
<title>Database SQL</title>
<link rel = "stylesheet" href = ./tablestyle.css>
</head>
<body>

<%-- <%@ include file = "menu.jsp" %> --%>



	<table id ="member">
		<thead>
			<tr>
				<th>NO</th>
				<th>성명</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>지역</th>
				<th>나이</th>
				<th>성별</th>
				<th>유형</th>
				<th>구분</th>
				<th>입사일</th>
				<th>고용유지기간</th>
				<th>퇴사여부</th>
				<th>업체명</th>
				<th>주소</th>
				<th>업체전화번호</th>
				<th>비고</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>${select2.id}</td>
				<td>${select2.name}</td>
				<td>${select2.birth}</td>
				<td>${select2.number}</td>
				<td>${select2.country}</td>
				<td>${select2.age}</td>
				<td>${select2.sex}</td>
				<td>${select2.type1}</td>
				<td>${select2.type2}</td>
				<td>${select2.coDate1}</td>
				<td>${select2.coDate2}</td>
				<td>${select2.coResignation}</td>
				<td>${select2.company}</td>
				<td>${select2.coAddress}</td>
				<td>${select2.coNumber}</td>
				<td>${select2.notice}</td>
		
			</tr>
		</tbody>
	
	
	


	</table>
</body>
</html>