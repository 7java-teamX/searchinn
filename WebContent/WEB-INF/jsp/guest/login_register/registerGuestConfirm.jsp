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

			お名前：<c:out value="${loginGuest.name}" /><br>
			カナ：<c:out value="${loginGuest.kana}" /><br>
			電話番号:<c:out value="${loginGuest.tel}" /><br>
			生年月日:<c:out value="${loginGuest.birthday}" /><br>
			メールアドレス:<c:out value="${loginGuest.mail}" /><br>
			住所:<c:out value="${loginGuest.address}" /><br>

	<input type="button" value="登録" onClick="location.href='/searchinn/RegisterGuestServlet?action=done'">
	<input type="button" value="キャンセル" onClick="location.href='/searchinn/RegisterGuestServlet?action=null'">

	<p>
		<a class="center" href="/searchinn/index.jsp">TOPへ戻る</a>
	</p>
</div>
</body>
</html>