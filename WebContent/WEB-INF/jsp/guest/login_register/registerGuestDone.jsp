<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録完了</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestForm.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
</head>
<body>

<jsp:include page="/include/header.jsp"/>
<div class="main1">
		<h2>会員情報登録完了</h2>
		<p> ${regGuest.name}さん登録完了しました。</p>
		<input type="button" value="ログイン画面へ" onClick="location.href='/searchinn/MainServlet?action=login'"
		 id="submit">
	<p>
		<a class="center" href="/searchinn/index.jsp">TOPへ戻る</a>
	</p>
	</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>