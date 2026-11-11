<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1> MyFactoryFramework LIB TEST </h1>
<h3>
  <a href="insert.do">등록하기 </a><p>
  <a href="select.do">검색하기 </a><p>
  <a href="update.do">수정하기 </a><p>
  <a href="delete.do">삭제하기 </a><p>
  <!--
    아래 요청이 되면 Controller를 실행하고 message 저장해서 forward 방식으로 selectby.jsp로 이동
  -->
  <a href="delete.do?key=delete">조건검색하기 </a><p>
</h3>

</body>
</html>