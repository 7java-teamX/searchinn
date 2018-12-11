<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報変更画面</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestInfo.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>

<div class="container">
	<div class="box">
		<h3 class="title" >登録情報変更画面</h3>
	<form action="/searchinn/GuestInfoChangeServlet?action=guest" method="post">
	<div  class="center_area">
		<input type="hidden" name="id" value="${loginUser.guestId}">
		name:<input type="text" name="name" autocomplete="on" list="nowName" required><br>
		kana:<input type="text" name="kana" autocomplete="on" list="nowKana" required><br>
		TEL:<input type ="text" name="tel" autocomplete="on" list="nowTel" required><br>
		EMail:<input type ="email" name="email" autocomplete="on" list="nowMail" required><br>
		address:<input type ="text" name="address" autocomplete="on" list="nowAddress" required><br>
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
	<input type="submit" value="変更" id="submit">
	</div>
</form>
</div></div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>