<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
</head>
<body>
<p><a href = "/searchinn/aGuestListServlet">"顧客情報一覧へ</a></p>
<p>絞り込み検索</p>
<form action="/searchinn/GuestInfoServlet" method="post">
	<p>ゲストID:<input type="number" name="id"></p>
	<p>ユーザー名:<input type="text" name="name"></p>
	<p>:TEL<input type ="tel" name="tel"></p>
	<p>:EMail<input type ="email" name="email"></p>
	<input type="submit" value="検索">
</form>

<!-- 以下に 一覧表示 -->
</body>
</html>