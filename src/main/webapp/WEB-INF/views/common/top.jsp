<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 4. 28.
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    ul li{
        display: inline-block;
        width: 100px;
    }
</style>
<body>
<header>
    <h3>휴먼 홈페이지</h3>
</header>
<nav>
    <ul>
        <li>공부방</li>
        <li>자유게시판</li>
        <li>Q&A</li>
        <li><a href="<c:url value="/memberjoin"/>">회원가입</a></li>
    </ul>
    <hr>
</nav>
</body>
</html>
