<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Home</title>
</head>
<style>
    .all {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 10px;
        flex-direction: column;
    }

    .sub1 {
        display: flex;
        justify-self: center;
        gap: 10px;
    }

    #list th, #list tr, #list td {
        border: 1px solid;
    }

    #header {
        background-color: cornflowerblue;
        color: white;
        width: 850px;
        text-align: center;
        padding: 20px;
        font-size: 20px;
    }
</style>
<body>
<div class=all>
    <h2 id=header>열차조회 시스템 개발</h2>
    <hr>
    <div class="sub1">
        <input type="button" id="btnall" value="모든열차보기" onclick="selDef()">
        <input type="text" id="searchtext" placeholder="지역명 입력">
        <input type="button" id="search" value="검색" onclick="selReText()">
    </div>
    <div class="sub1">
        <select id="sel" onchange="selRe()">
            <option value="101">선택</option>
            <option value="서울">서울</option>
            <option value="대전">대전</option>
            <option value="부산">부산</option>
            <option value="천안">천안</option>
            <option value="대구">대구</option>
        </select>
        <form id="checkboxes" method="get">
            <input type="checkbox" id="서울" name="int" value="0">서울
            <input type="checkbox" id="대전" name="int" value="1">대전
            <input type="checkbox" id="부산" name="int" value="2">부산
            <input type="checkbox" id="천안" name="int" value="3">천안
            <input type="checkbox" id="대구" name="int" value="4">대구
            <button>선택</button>
        </form>
    </div>
    <table id="list">
        <tr>
            <th>지역명</th>
            <th>열차이름</th>
            <th>출발시간</th>
            <th>도착시간</th>
        </tr>
        <c:forEach items="${trains}" var="train">
            <tr>
                <td>${train.region }</td>
                <td>${train.name }</td>
                <td>${train.dTime }</td>
                <td>${train.aTime }</td>
            </tr>
            <script>
                document.getElementById(`${train.region}`).checked = true;
            </script>
        </c:forEach>
    </table>
</div>
</body>
</html>
<script>
    function selDef() {
        location.href = "/hom_war_exploded/";
    }

    function selReText() {
        const text = document.getElementById("searchtext");
        location.href = "/hom_war_exploded/?d=" + text.value;
    }

    function selRe() {
        const sel = document.getElementById("sel");
        if (sel.value == 101) {
            return;
        }
        console.log(sel.value)
        location.href = "/hom_war_exploded/?d=" + sel.value;
    }
</script>