<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "com.beans.*" %>
<meta charset="UTF-8">
<title>Update SQL</title>
<link rel = "stylesheet" href = ./style.css>
</head>
<body>

<form method = "post" action = "insert2.do">

	<div class = "one">
	
		<div class = "header">
			<div class = "fonts">
				학생정보등록
			</div>	
		</div>
		
		<div class = "plus">
			<div class = "plus2">기본정보</div>
			<div class = "plus3">
				<div class ="plus4">
					<p>이름 : <input type = "text" name="name">
				</div>
				
				<div class ="plus4">
					<p>생년월일 : <input type = "date" name="birth" value = "0001-01-01" min="0000-00-00" max="3000-12-31" >
				</div>
				
				<div class = "plus4">
					<p>전화번호 : <input type = "tel" name = "number" pattern="\d{3}-\d{3,4}-\d{4}" title="형식 010-0000(000)-0000">
				</div>
				
				<div class = "plus4">
					<p>지역 : <input type = "text" name = "country">
				</div>
				
				<div class = "plus4" >
					<p>나이 : <input type = "text" name = "age" value = "0">
				 </div>
				
				<div class = "plus4">
					<p>성별 : <input type = "text" name = "sex">
				</div>
				
				<div class ="plus4">
					<p>유형 : <input type = "text" name = "type1">
				</div>
				
				<div class ="plus4">
					<p>구분 : <input type = "text" name = "type2">
				</div>
				
				<div class = "plus4">
					<p>비고 : <input type = "text" name = "notice">
				</div>
			</div>

				
		</div>
		

		
		<div class ="plus">
			<div class ="plus2">업체현황</div>
			<div class ="plus3">
				<div class = "plus4">
					<p>업체명 : <input type = "text" name = "company">
				</div>
				
				<div class = "plus4">
					<p>업체주소 : <input type = "text" name = "coAddress">
				</div>
				
				<div class = "plus4">
					<p>입사일 : <input type = "date" name = "coDate1" value = "0001-01-01" min="0000-00-00" max="3000-12-31">
				</div>
				
				<div class = "plus4">
					<p>고용유지기간 : <input type = "date" name = "coDate2" value = "0001-01-01" min="0000-00-00" max="3000-12-31">
				</div>
				
				<div class = "plus4">
					<p>퇴사여부 : <input type = "text" name = "coResignation" >
				</div>
				
				<div class = "plus4"> 
					<p>업체전화번호 : <input type = "text" name = "coNumber" >
				</div>
			</div>

			
	
			
		</div>
		
		

		<p><input type = "submit" value = "전송">
	</div>
</form>
</body>
</html>