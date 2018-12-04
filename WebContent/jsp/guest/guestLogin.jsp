<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/searchinn/css/loginStyle.css">
	<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
	<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">
	<title>ログイン</title>
</head>
<body>

<jsp:include page="/jsp/header.jsp"/>

	<div class="login">
 	<div class="login-triangle"></div>

 	<h2 class="login-header">ログイン画面</h2>

 	<form class="login-container" action="" method="post">
    <p><input type="text" placeholder="ユーザーID" name="guestId"></p>
    <p><input type="password" placeholder="Password" name="guestPass"></p>
    <p><input type="submit" value="会員ログイン" ></p>
  	</form>

	<h2 class="hover"><a class ="touroku" href="/searchinn/RegisterGuestServlet?action=null">会員登録</a></h2>


	</div>

<jsp:include page="/jsp/footer.jsp"/>

</body>
</html>