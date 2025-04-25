<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 4. 25.
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>응원방 입장하기</title>
</head>
<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/resources/css/startC.css>
<body>
<header>응원방 입장하기</header>
<input type="text" id="name" name="nickName" placeholder="별명 입력">
<button onclick="addUser()">등록</button>
<br>
<span>*별명은 중복 불가*</span>
</body>
</html>
<script>
    function addUser() {
        const nickName = document.getElementById('name').value;
        sessionStorage.setItem(name, nickName);
        let today = new Date();
        let hours = ('0' + today.getHours()).slice(-2);
        let minutes = ('0' + today.getMinutes()).slice(-2);
        let seconds = ('0' + today.getSeconds()).slice(-2);
        let timeString = hours + "" + minutes + "" + seconds;
        console.log(timeString);
        location.href = "/hom_war_exploded/chat/startC?nickName=" + nickName + "&sTime=" + timeString;
    }
</script>
