<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = style.css>
</head>
<body>
<%@ include file = "menu.jsp" %>

<table width ="2000" border="1">
	<form name = "frm" method = "post" action = "insert2.do">
	

	<tr>
			<th>성명</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>지역</th>
			<th>나이</th>
			<th>성별</th>
			<th>유형</th>
			<th>구분</th>
			<th>업체명</th>
			<th>업체주소</th>
			<th>입사일</th>
			<th>고용유지기간</th>
			<th>퇴사여부</th>
			<th>업체전화번호</th>
			<th>비고</th>
	</tr>

	<tr>
	
		<td style="width:60px;"><input type = "text" name ="name" style="width:60px;font-size:15px;"></td>
		<td style="width:100px;"><input type = "date" name="birth" value = "0001-01-01" min="0000-00-00" max="3000-12-31" style="width:100px;font-size:15px;" ></td>
		<td style="width:110px;"><input type = "tel" name ="number" pattern="\d{3}-\d{3,4}-\d{4}" title="형식 010-0000(000)-0000" style="width:110px;font-size:15px;"></td>
		<td style="width:80px;"><input type = "text" name ="country" style="width:80px;font-size:15px;"></td>
		<td style="width:50px;"><input type = "text" name ="age" value = "0" style="width:50px;font-size:15px;"></td>
		<td style="width:50px;"><input type = "text" name ="sex" style="width:50px;font-size:15px;"></td>
		<td style="width:80px;"><input type = "text" name ="type1" style="width:80px;font-size:15px;"></td>
		<td style="width:80px;"><input type = "text" name ="type2" style="width:80px;font-size:15px;"></td>
		<td style="width:200px;"><input type = "text" name ="company" style="width:200px;font-size:15px;"></td>
		<td style="width:250px;"><input type = "text" name ="coAddress" style="width:250px;font-size:15px;"></td>
		<td style="width:100px;"><input type = "date" name ="coDate1" value = "0001-01-01" min="0000-00-00" max="3000-12-31" style="width:100px;font-size:15px;"></td>
		<td style="width:100px;"><input type = "date" name ="coDate2" value = "0001-01-01" min="0000-00-00" max="3000-12-31" style="width:100px;font-size:15px;"></td>
		<td style="width:60px;"><input type = "text" name ="coResignation" style="width:60px;font-size:15px;"></td>
		<td style="width:100px;"><input type = "text" name ="coNumber" style="width:100px;font-size:15px;"></td>
		<td style="width:300px;"><input type = "text" name ="notice" style="width:300px;font-size:14px;"></td>
	
	</tr>	
		
		<p><input type = "submit" value = "전송" style="border:1px solid black;">
	</form>
</table>
</body>
</html>