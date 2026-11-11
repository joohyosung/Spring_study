<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 실습</title>
</head>
<body>
    <h1>JSP 페이지입니다.</h1>
    <p>현재 시간: <%= java.time.LocalDateTime.now() %></p>
</body>
</html>