<%--
  Created by IntelliJ IDEA.
  User: kkk
  Date: 25. 4. 28.
  Time: 오후 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<body>
<%@ include file="../common/top.jsp" %>
<form action="<c:url value="/memberjoind"/>" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id" id="userId"><span id="dupId">중복체크</span></td>
        </tr>
        <script>
            // jQuery라는 js 라이브러리: js의 자주 사용되는 기능으로 개발된 라이브러리. 설치는 보통  cnd 방식으로 합니다.
            // $로 시작
            $("#dupId").click(()=>{
                let uid=$("#userId").val();
                alert(uid);
                // 비동기 통신으로 서버에 전송해보겠습니다 request(비동기)
                const param= uid;
                // const param = uid;
                $.ajax({
                    async:true, // false라고 하면 동기방식으로 설정
                    url: "dupId",
                    data: {'id': param}, // 파라미터
                    type: 'GET', // GET 방식으로 보내겠다.
                    dataType: 'text',
                    success: function(data){
                        alert(data+"서버로부터 받음")
                        if(data !=''){
                            alert("사용가능")
                            $('#dupId').text(data+' 사용 가능 아이디')
                        }else{
                            alert("중복된 아이디입니다.")
                            $("#userId").val('');
                            $("#userId").focus();
                        }
                    },
                    error: function(data){
                        alert('통신오류')
                    }
                })
            })
        </script>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="tel"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="가입">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
