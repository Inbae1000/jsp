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


<form method = "post" action = "update2.do">

	<div class = "one">
	
		<div class = "header">
			<div class = "fonts">
				학생정보수정
			</div>
		</div>
		
		<div class = "plus">
			<div class = "plus2">기본정보</div>
			<div class = "plus3">
				<div class ="plus4">
					<p>이름 : <input type = "text" name="name" value = ${select2.name} >
					<input type = "hidden" name ="id" value = ${select2.id}>
				</div>
				
				<div class ="plus4">
					<p>생년월일 : <input type = "date" name="birth" value = ${select2.birth}>
				</div>
				
				<div class = "plus4">
					<p>전화번호 : <input type = "tel" name = "number" value = ${select2.number} >
				</div>
				
				<div class = "plus4">
					<p>지역 : <input type = "text" name = "country" value = ${select2.country} >
				</div>
				
				<div class = "plus4" >
					<p>나이 : <input type = "text" name = "age" value = ${select2.age}>
				 </div>
				
				<div class = "plus4">
					<p>성별 : <input type = "text" name = "sex" value = ${select2.sex}>
				</div>
				
				<div class ="plus4">
					<p>유형 : <input type = "text" name = "type1" value = ${select2.type1}>
				</div>
				
				<div class ="plus4">
					<p>구분 : <input type = "text" name = "type2" value= ${select2.type2}>
				</div>
				
				<div class = "plus4">
					<p>비고 : <input type = "text" name = "notice" value = ${select2.notice}>
				</div>
			</div>

				
		</div>
		

		
		<div class ="plus">
			<div class ="plus2">업체현황</div>
			<div class ="plus3">
				<div class = "plus4">
					<p>업체명 : <input type = "text" name = "company" value = ${select2.company}>
				</div>
				
				<div class = "plus4">
					<p>업체주소 : <input type = "text" name = "coAddress" value = ${select2.coAddress}>
				</div>
				
				<div class = "plus4">
					<p>입사일 : <input type = "date" name = "coDate1" value = ${select2.coDate1} min="0000-00-00" max="3000-12-31">
				</div>
				
				<div class = "plus4">
					<p>고용유지기간 : <input type = "date" name = "coDate2" value = ${select2.coDate2} min="0000-00-00" max="3000-12-31">
				</div>
				
				<div class = "plus4">
					<p>퇴사여부 : <input type = "text" name = "coResignation" value = ${select2.coResignation}>
				</div>
				
				<div class = "plus4"> 
					<p>업체전화번호 : <input type = "text" name = "coNumber" value = ${select2.coNumber}>
				</div>
			</div>

			
	
			
		</div>
		
		

		<p><input type = "submit" value = "전송">
		<p><input type = "submit" value = "삭제" formaction="delete.do" onclick="('${select2.id}')">
	</div>
</form>
</body>
</html>