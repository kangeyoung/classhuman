<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 4. 24.
  Time: 오후 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/resources/css/wt.css>
<body>
<div class="all">
    <h2 id="header">오늘의 날씨</h2>
    <div class="sub1">
        <a href="/hom_war_exploded/wt?city=all"><input type="button" id="searchall" value="전국 날씨"></a>
        <input type="text" id="searchC" placeholder="시도 입력">
        <input type="button" id="search" value="검색">
    </div>
    <div style="text-align: center">
        <form method="get">
            <label><input type="checkbox" name="searCheck" value="서울특별시">서울특별시</label>
            <label><input type="checkbox" name="searCheck" value="부산광역시">부산광역시</label>
            <label><input type="checkbox" name="searCheck" value="대구광역시">대구광역시</label>
            <label><input type="checkbox" name="searCheck" value="인천광역시">인천광역시</label>
            <label><input type="checkbox" name="searCheck" value="광주광역시">광주광역시</label>
            <label><input type="checkbox" name="searCheck" value="대전광역시">대전광역시</label>
            <label><input type="checkbox" name="searCheck" value="울산광역시">울산광역시</label>
            <label><input type="checkbox" name="searCheck" value="세종특별자치시">세종특별자치시</label><br>
            <label><input type="checkbox" name="searCheck" value="경기도">경기도</label>
            <label><input type="checkbox" name="searCheck" value="강원특별자치도">강원특별자치도</label>
            <label><input type="checkbox" name="searCheck" value="충청북도">충청북도</label>
            <label><input type="checkbox" name="searCheck" value="충청남도">충청남도</label>
            <label><input type="checkbox" name="searCheck" value="전라북도">전라북도</label>
            <label><input type="checkbox" name="searCheck" value="전라남도">전라남도</label>
            <label><input type="checkbox" name="searCheck" value="경상북도">경상북도</label>
            <label><input type="checkbox" name="searCheck" value="경상남도">경상남도</label>
            <label><input type="checkbox" name="searCheck" value="제주특별자치도">제주특별자치도</label><br>
            <button style="margin-top: 5px; width: 50px;" onclick="search()">검색</button>
        </form>
    </div>
    <form method="get">
        <table id="list">
            <tr>
                <th><input type="button" value="전체선택" onclick="checkAll()"></th>
                <th>시/도</th>
                <th>날씨</th>
                <th>최고기온</th>
                <th>최저기온</th>
            </tr>
            <c:forEach var="region" items="${list}">
                <tr>
                    <td>
                        <input type="checkbox" name="delCheck" value="${region.city}">
                    </td>
                    <td> ${region.city } </td>
                    <td> ${region.weather } </td>
                    <td> ${region.maxTemp } </td>
                    <td> ${region.minTemp } </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="right">
                    <button>삭제</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
<script>
    window.onload= ()=>{
        document.getElementById('search').addEventListener('click',()=>{
            const sWord = document.getElementById('searchC').value;
            location.href = "/hom_war_exploded/wt?city="+sWord;
        })
    }
</script>
