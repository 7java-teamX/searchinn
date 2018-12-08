<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
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
		    <p><input type="text" name= "id" placeholder="管理者ID"></p>
		    <p><input type="password" name="pass" placeholder="Password"></p>
		    <p><input type="submit" value="管理者ログイン" ></p>
	  	</form>

		<p>
			<a class="whiteText" href="/searchinn/jsp/admin/admin.jsp">管理者画面へ</a>
		</p>
	</div>

	<jsp:include page="/include/footer.jsp"/>

</body>
</html>