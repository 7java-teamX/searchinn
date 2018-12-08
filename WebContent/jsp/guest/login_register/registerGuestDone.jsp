<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力確定</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestForm.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
</head>
<body>

<jsp:include page="/include/header.jsp"/>
<div class="main1">
		<h2>会員情報確定画面</h2>
		<p>会員情報を確定します。</p>
		<input type="button" value="ログイン画面へ" onClick="location.href='/searchinn/MainServlet?action=login'"
		 id="submit">

	<p>
		<a class="center" href="/searchinn/jsp/index.jsp">TOPへ戻る</a>

	</p>
	</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>