<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestFormStyle.css">
<title>会員情報入力確認</title>



</head>
<body>
<div class="main1">
<h2>会員情報確認画面</h2>
	<p>下記のユーザーを登録します</p>

			お名前：<c:out value="${Guest.GuestName}" /><br>
			ログインＩＤ：<c:out value="${Guest.GuestId}" /><br>
			メールアドレス:<c:out value="${Guest.Guestmail}" /><br>
			パスワード:<c:out value="${Guest.GuestPass}" /><br>

	<input type="button" value="登録" onClick="location.href='/searchinn/RegisterGuestServlet?action=done'">
	<input type="button" value="キャンセル" onClick="location.href='/searchinn/RegisterGuestServlet?action=null'">


	<h3><a href="registerGuestDone.html"></a></h3>
	<p>
		<a class="center" href="/searchinn/jsp/index.jsp">TOPへ戻る</a>
	</p>
</div>
</body>
</html>