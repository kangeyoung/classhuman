<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 5. 1.
  Time: 오후 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/top.css?after"/>" >
<body>
<div id="headerTitle">
    <h3><a href="<c:url value="/"/>">휴먼 여행지 추천</a></h3>
</div>
<hr />
<div class="tourMenu">
    <a href="#" class="menu">홈</a>
    <a href="#" class="menu">테마</a>
    <a href="#" class="menu">지역</a>
    <a href="#" class="menu">여행코스</a>
    <a href="#" class="menu">여행정보</a>
    <a href="#" class="menu">여행혜택</a>
    <a href="<c:url value="/login"/>" class="menu">로그인</a>
</div>
</body>
</html>
