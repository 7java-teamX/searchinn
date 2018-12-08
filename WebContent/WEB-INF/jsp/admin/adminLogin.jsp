<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="../css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="../css/footerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">
<title>管理者ログイン画面</title>
</head>
<body>

	<jsp:include page="/include/header.jsp"/>

	<div class="login">
 		<div class="login-triangle"></div>

	 	<h2 class="login-header">管理者ログイン画面</h2>


	 	<form class="login-container" action="/searchinn/AdminLoginServlet" method="post">
		    <p><input type="text" name="id" placeholder="管理者ID"></p>
		    <p><input type="password" name="pass" placeholder="Password"></p>
		    <p><input type="submit" value="管理者ログイン" ></p>
	  	</form>
		<div class= "errmsg">
		  	<c:if test="${not empty errMsg}">
	 			<c:out value="${errMsg}"></c:out>
	 		</c:if>
		</div>
	</div>

	<jsp:include page="/include/footer.jsp"/>

</body>
</html>