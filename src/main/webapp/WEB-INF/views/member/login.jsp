<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 5. 1.
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="../common/top.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<body>
<div class="content-container">
    <span id= "loMsg" style="color: red; text-align: center">${login}</span>
    <form id="loginForm" action="<c:url value="/loginIn"/>" method="post">
        <span class="tt">아이디</span>
        <span><input type="text" name="id" placeholder="아이디 입력" required></span> <br>
        <span class="tt">비밀번호</span>
        <span><input type="password" name="pass" placeholder="비밀번호 입력" required></span> <br>
        <div id="signTr" style="display: none">
            <span class="tt">이름</span>
            <span><input type="text" name="name" placeholder="이름 입력"></span> <br>
        </div>
        <div id="btns1">
            <span><input type="submit" value="로그인" id="loBtn"></span>
            <span><input type="button" onclick="signIn()" value="회원가입"></span>
        </div>
        <div id="btns2" style="display: none">
            <span><input type="submit" value="가입"></span>
            <span><input type="button" onclick="backL()" value="뒤로"></span>
        </div>
    </form>
</div>
</body>
</html>
<script>
    function signIn() {
        document.getElementById('signTr').style.display = 'flex';
        document.getElementById('signTr').style.flexDirection = 'column';
        document.getElementById('btns1').style.display = 'none';
        document.getElementById('btns2').style.display = 'block';
        document.getElementById('loginForm').action = 'signUp'
        document.getElementById('loMsg').style.display = 'none';
    }

    function backL() {
        document.getElementById('signTr').style.display = 'none';
        document.getElementById('btns1').style.display = 'block';
        document.getElementById('btns2').style.display = 'none';
        document.getElementById('loginForm').action = 'loginIn';
    }
</script>
