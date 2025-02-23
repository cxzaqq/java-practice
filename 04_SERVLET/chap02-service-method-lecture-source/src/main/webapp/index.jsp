<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Service Method</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a태그의 href 속성값 변경</h4>
    <a href="request-service">GET 방식 서비스 요청하기</a>

    <h3>POST 방식의 요청</h3>
    <h4>from 태그의 method 속성값 변경</h4>
    <form action="request-service" method="post">
<%--        <input type="submit" value="조회">--%>
        <button type="submit">조회버튼</button>
    </form>
</body>
</html>