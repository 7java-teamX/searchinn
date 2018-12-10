<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/searchinn/css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css">
<title>ログイン</title>
</head>
<body>

	<jsp:include page="/include/header.jsp" />

	<div class="login">
		<div class="login-triangle"></div>

		<h2 class="login-header">ログイン画面</h2>

		<form class="login-container" action="/searchinn/GuestLoginServlet"
			method="post">
			<p>
				<input type="email" placeholder="メールアドレスを入力下さい" name="guestMail">
			</p>
			<p>
				<input type="password" placeholder="Password" name="guestPass">
			</p>
			<p>
				<input type="submit" value="会員ログイン">
			</p>
		</form>
		<div class="errmsg">
			<c:if test="${not empty errMsg}">
				<c:out value="${errMsg}"></c:out>
			</c:if>
		</div>

		<h2 class="hover">
			<a class="touroku" href="/searchinn/RegisterGuestServlet?action=null">会員登録</a>
		</h2>

	</div>
	<jsp:include page="/include/footer.jsp" />

</body>
</html>