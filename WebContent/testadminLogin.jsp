<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者 ログイン画面</title>
</head>
<body>
<h1>管理者 ログイン画面</h1>
<form action="/searchinn/GuestInfoServlet" method="post">
	<p>ユーザー名:<input type="text" name="name"></p>
	<p>パスワード:<input type ="password" name="pass"></p>
	<input type="submit" value="ログイン">
</form>
</body>
</html>