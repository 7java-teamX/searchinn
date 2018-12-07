<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力確定</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestFormStyle.css">
</head>
<body>
<div class="main1">
		<h2>会員情報確定画面</h2>
		<p>会員情報を確定します。</p>
		<input type="button" value="ログイン画面へ" onClick="location.href='/searchinn/MainServlet?action=login'">

	<p>
		<a class="center" href="/searchinn/jsp/index.jsp">TOPへ戻る</a>
	</p>
	</div>

</body>
</html>