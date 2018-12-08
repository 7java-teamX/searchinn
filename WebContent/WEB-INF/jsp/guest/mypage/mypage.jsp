<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/searchinn/css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>
<div class="login">
	<div class="login-triangle"></div>
	 	<h2 class="login-header">マイページ</h2>
	 	<div class="login-container">
	 	<br>
		<p><a href="/searchinn/GReserveListServlet" class="square_btn">予約確認</a></p>
		<p><a href="/searchinn/GGuestInfoServlet?action=info" class="square_btn">会員情報</a></p>
		<br>
	</div>
</div>
<footer>
	<jsp:include page="/include/footer.jsp" />
</footer>

</body>
</html>