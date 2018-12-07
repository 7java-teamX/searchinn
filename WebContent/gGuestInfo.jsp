<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ユーザー登録情報</h2>
<p>ユーザー名:${loginUser.name}</p>
<p>かな:${loginUser.kana}</p>
<p>TEL:${loginUser.tel}</p>
<p>EMail:${loginUser.mail}</p>
<p>Adress:${loginUser.address}</p>
<p><a href="/searchinn/gGuestInfoChangeForm.jsp">変更</a></p>
<p><a href="/searchinn/jsp/guest/mypage.jsp">マイページへ</a></p>
</body>
</html>