<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 4. 22.
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>바바밥</title>
</head>
<style>
    .all {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 10px;
        flex-direction: column;
    }

    #header {
        background-color: cornflowerblue;
        color: white;
        width: 850px;
        text-align: center;
        padding: 20px;
        font-size: 20px;
    }

    table tr td {
        border: 1px solid;
    }
    input[type= button]{
        background-color: cornflowerblue;
        color: white;
        width: 100px;
        height: 30px;
        border: transparent;
        font-size: 17px;
    }
</style>
<body>
<div class=all>

    <h2 id= header>휴먼 점심 메뉴</h2>
    <hr>
    <div class=btn>
        <input type=button id=0 onclick=clickDay(this) value=월요일>
        <input type=button id=1 onclick=clickDay(this) value=화요일>
        <input type=button id=2 onclick=clickDay(this) value=수요일>
        <input type=button id=3 onclick=clickDay(this) value=목요일>
        <input type=button id=4 onclick=clickDay(this) value=금요일>
    </div>

    <table id="table">
        <tr>
            <td style="width: 100px">밥</td>
            <td style="width: 200px"></td>
        </tr>
        <tr>
            <td>국</td>
            <td></td>
        </tr>
        <tr>
            <td>요리</td>
            <td></td>
        </tr>
    </table>
</div>
</body>
</html>
<script>
    function clickDay(e) {
        const table = document.getElementById("table")
        if (e.value == "월요일") {
            table.rows[0].cells[1].innerHTML = `${foodlist.get(0).rice}`
            table.rows[1].cells[1].innerHTML = `${foodlist.get(0).soup}`
            table.rows[2].cells[1].innerHTML = `${foodlist.get(0).mainMeal}`
        } else if (e.value == "화요일") {
            table.rows[0].cells[1].innerHTML = `${foodlist.get(1).rice}`
            table.rows[1].cells[1].innerHTML = `${foodlist.get(1).soup}`
            table.rows[2].cells[1].innerHTML = `${foodlist.get(1).mainMeal}`
        } else if (e.value == "수요일") {
            table.rows[0].cells[1].innerHTML = `${foodlist.get(2).rice}`
            table.rows[1].cells[1].innerHTML = `${foodlist.get(2).soup}`
            table.rows[2].cells[1].innerHTML = `${foodlist.get(2).mainMeal}`
        } else if (e.value == "목요일") {
            table.rows[0].cells[1].innerHTML = `${foodlist.get(3).rice}`
            table.rows[1].cells[1].innerHTML = `${foodlist.get(3).soup}`
            table.rows[2].cells[1].innerHTML = `${foodlist.get(3).mainMeal}`
        } else if (e.value == "금요일") {
            table.rows[0].cells[1].innerHTML = `${foodlist.get(4).rice}`
            table.rows[1].cells[1].innerHTML = `${foodlist.get(4).soup}`
            table.rows[2].cells[1].innerHTML = `${foodlist.get(4).mainMeal}`
        }
    }
</script>
