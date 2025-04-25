<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>응원방</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/chat.css">
<body>
<header>응원방</header>
<button onclick="reloadTable()">새로고침</button>
<div>
    <table id="msgTable">
        <c:forEach items="${msgList}" var="msg">
            <tr>
                <td>${msg}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<input type="text" id="msgText" name="msg" placeholder="메세지 입력">
<button onclick="sendMsg()">전송</button>
</body>
</html>
<script>
    const nickName = sessionStorage.getItem(name);

    document.getElementById('msgText').focus();
    document.getElementById('msgText').value=sessionStorage.getItem("oriMsg");

    function reloadTable() {
        console.log("100");
        const msgT = document.getElementById('msgText').value;
        sessionStorage.setItem("oriMsg",msgT);
        location.href = "/hom_war_exploded/chat/chat?nicky=" + nickName+"&mmm="+msgT;

    }

    setTimeout(reloadTable, 3000);


    function sendMsg() {
        const msgText = document.getElementById('msgText');
        let putMsg = msgText.value;
        msgText.value = "";
        let today = new Date();
        let hours = ('0' + today.getHours()).slice(-2);
        let minutes = ('0' + today.getMinutes()).slice(-2);
        let seconds = ('0' + today.getSeconds()).slice(-2);
        let timeString = hours + minutes + seconds;
        location.href = "/hom_war_exploded/chat/chat?nicky=" + nickName + "&timeString=" + timeString + "&msgText=" +putMsg;

    }
</script>