<%--
  Created by IntelliJ IDEA.
  User: marukong
  Date: 26. 11. 10.
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>가입된 정보</h3>
아이디: ${dto.id}<br>
이름: ${dto.name}<br>
나이: ${dto.age}<br>
주소: ${dto.addr}<br>
<hr>
메뉴: ${menu} <br>
mes: ${mes}
</body>
</html>
