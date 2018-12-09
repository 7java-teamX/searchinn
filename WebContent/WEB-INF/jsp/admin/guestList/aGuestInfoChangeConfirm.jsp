<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestList.css">
<title>顧客内容確認画面</title>
<title>変更確認</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div class="container">
	<h2>顧客内容確認画面</h2>
	<div class="center-box">
		<p>名前:${guestDetail.name} </p>
		<p>かな:${guestDetail.kana}</p>
		<p>TEL:${guestDetail.tel} </p>
		<p>Email:${guestDetail.mail}</p>
		<p>住所:${guestDetail.address}</p>
	</div>
	<div class="center-box">

	<p>名前:${update.name} </p>
	<p>かな:${update.kana}</p>
	<p>TEL:${update.tel} </p>
	<p>Email:${update.mail}</p>
	<p>住所:${update.address}</p>
	<p><a href="/searchinn/GuestInfoChangeServlet?action=admin" class="btn">変更</a>
	<a href="/searchinn/aGuestList.jsp" class="btn">キャンセル</a></p>
	</div>
</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>