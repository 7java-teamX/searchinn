<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/searchinn/GuestInfoChangeServlet?action=guest" method="post">
	<input type="hidden" name="id" value="${loginUser.guestId}">
	<p>name:<input type="text" name="name" autocomplete="on" list="nowName" required></p>
	<p>kana:<input type="text" name="kana" autocomplete="on" list="nowKana" required></p>
	<p>TEL:<input type ="text" name="tel" autocomplete="on" list="nowTel" required></p>
	<p>EMail:<input type ="email" name="email" autocomplete="on" list="nowMail" required></p>
	<p>address:<input type ="text" name="address" autocomplete="on" list="nowAddress" required></p>
	<datalist id="nowName">
	<option value="${loginUser.name}">
	</datalist>
	<datalist id="nowKana">
	<option value="${loginUser.kana}">
	</datalist>
	<datalist id="nowTel">
	<option value="${loginUser.tel}">
	</datalist>
	<datalist id="nowMail">
	<option value="${loginUser.mail}">
	</datalist>
	<datalist id="nowAddress">
	<option value="${loginUser.address}">
	</datalist>
	<input type="submit" value="変更">
</form>
</body>
</html>