<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>가입된 정보</h1>
아이디 : ${userDTO.id}<br><!-- userDTO.getId()메소드 호출 -->
이름: ${userDTO.name}<br>
나이: ${userDTO.age}<br>
주소: ${userDTO.addr}<br>

<hr>
<h1>가입된 정보 - @ModelAttribute("dto")</h1>
아이디 : ${dto.id}<br><!-- userDTO.getId()메소드 호출 -->
이름: ${dto.name}<br>
나이: ${dto.age}<br>
주소: ${dto.addr}<br>

<hr>
메뉴 : ${menu} <br>
mes : ${mes}



</body>
</html>