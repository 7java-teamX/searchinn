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
<div class="main">
<h2>会員情報確認画面</h2>
	<p>下記のユーザーを登録します</p>


	<input type="button" value="登録" onClick="location.href='/searchinn/RegisterGuestServlet?action=done'">
	<input type="button" value="キャンセル" onClick="location.href='/searchinn/RegisterGuestServlet?action=null'">


	<h3><a href="registerGuestDone.html"></a></h3>
	<p>
		<a class="center" href="../index/index.html">TOPへ戻る</a>
	</p>
</div>
</body>
</html>