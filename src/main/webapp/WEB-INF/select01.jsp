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

<%@ include file = "menu.jsp" %>

<%
	MemberDAO memberDao = MemberDAO.getInstance();
	List<MemberDTO> list = memberDao.selectList();
%>



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
<%
	for(MemberDTO b : list){

%>
		<tbody>
			<tr>
				<td><%=b.getId() %></td>
				<td><a href="update.do?id=<%=b.getId()%>"><%=b.getName() %></td>
				<td><%=b.getBirth() %></td>
				<td><%=b.getNumber() %></td>
				<td><%=b.getCountry()%></td>
				<td><%=b.getAge()%></td>
				<td><%=b.getSex()%></td>
				<td><%=b.getType1()%></td>
				<td><%=b.getType2()%></td>
				<td><%=b.getCoDate1()%></td>
				<td><%=b.getCoDate2()%></td>
				<td><%=b.getCoResignation()%></td>
				<td><%=b.getCompany()%></td>
				<td><%=b.getCoAddress()%></td>
				<td><%=b.getCoNumber()%></td>
				<td><%=b.getNotice()%></td>
		
			</tr>
		</tbody>
	
	
	
<%

}

%>

	</table>
</body>
</html>