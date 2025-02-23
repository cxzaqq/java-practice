<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<h1>Request Parameter</h1>
<h3>GET 방식의 요청</h3>
<h4>form 태그를 활용한 get 방식 요청</h4>
<form action="queryString" method="get">
    <label for="name">이름: </label><input id="name" type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" id="male" value="M"><label for="male">남자</label>
    <input type="radio" name="gender" id="female" value="F"><label for="female">여자</label>
    <br>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie"><label for="movie">영화 시청</label>
    <input type="checkbox" name="hobbies" id="music" value="music"><label for="music">음악 감상</label>
    <input type="checkbox" name="hobbies" id="coding" value="coding"><label for="coding">코딩</label>
    <br>
    <Button>GET 요청</Button>
</form>

<h4>a 태그의 href 속성에 직접 파라미터를 써서 쿼리스트링을 작성하고 get 요청을 할 수 있다.</h4>
<a href="http://localhost:8080/chap03/queryString?name=%EC%9C%A4&age=12&birthday=2025-12-28&gender=M&national=ko&hobbies=movie&hobbies=music&hobbies=coding">
    a태그를 활용한 쿼리스트링 방식
</a>

<h3>POST 방식의 요청</h3>
<h4>form 태그를 이용한 post 방식 요청</h4>
<form action="formdata" method="post">
    <label for="name">이름: </label><input id="name" type="text" name="name">
    <br>
    <label>나이: </label><input type="text" name="age">
    <br>
    <label>생일: </label><input type="date" name="birthday">
    <br>
    <label>성별: </label>
    <input type="radio" name="gender" value="M"><label >남자</label>
    <input type="radio" name="gender" value="F"><label >여자</label>
    <br>
    <label>국적: </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>
    <label>취미: </label>
    <input type="checkbox" name="hobbies" value="movie"><label>영화 시청</label>
    <input type="checkbox" name="hobbies" value="music"><label>음악 감상</label>
    <input type="checkbox" name="hobbies" value="coding"><label>코딩</label>
    <br>
    <Button>POST 요청</Button>
</form>
</body>
</html>