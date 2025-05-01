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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<%@include file="../common/top.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css?after"/>">
<body>
<div class="content-container">
    <span id="loMsg" style="color: red; text-align: center">${login}</span>
    <form id="loginForm" action="<c:url value="/loginIn"/>" method="post">
        <span class="tt">아이디</span>
        <span><input type="text" id="realId" name="id" placeholder="아이디 입력" required></span> <br>
        <span id="infoI"></span>
        <span class="tt">비밀번호</span>
        <span><input type="password" name="pass" id="realPass" placeholder="비밀번호 입력" required></span> <br>
        <div id="signTr" style="display: none">
            <span><input type="password" name="noParam" id="chkPass" placeholder="비밀번호 확인"> </span>
            <span id='infoP'></span>
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
        document.getElementById('realId').addEventListener('change', chkI)
    }

    function chkI() {
        let id = $('#realId').value;
        $.ajax({
            type: 'post',
            url: '/dupId',
            async: true,
            dataType: 'text',
            data: id,
            success: function (data) {
                if (data == "1") {
                    $('#infoI').innerHTML = '아이디 중복';
                    $('#realId').value = '';
                } else {
                    $('#infoI').innerHTML = '중복검사 완료';
                }
            },
            error: function () {
                alert('서버오류');
            }
        })
    }

    function chkP(e) {
        let realPass = document.getElementById('realPass').value;
        if (realPass != e.value) {
            document.getElementById('infoP').innerHTML = '비밀번호가 틀립니다.';
            e.value = '';
        }
    }

    function backL() {
        document.getElementById('signTr').style.display = 'none';
        document.getElementById('btns1').style.display = 'block';
        document.getElementById('btns2').style.display = 'none';
        document.getElementById('loginForm').action = 'loginIn';
        document.getElementById('realId').removeEventListener('change', chkI);
    }
</script>
