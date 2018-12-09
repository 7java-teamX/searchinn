<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestInfo.css">
<title>登録内容変更確認</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div class="container">
	<div class="box">
		<h2 class="title center_area">変更確認</h2>
		<div class="center_area">
			<h3>変更前</h3>
			名前:${loginUser.name} <br>
			かな:${loginUser.kana}<br>
			TEL:${loginUser.tel} <br>
			Email:${loginUser.mail}<br>
			住所:${loginUser.address}<br>
		</div>

		<div class="center_area">
			<h3>変更後</h3>
			名前:${update.name}<br>
			かな:${update.kana}<br>
			TEL:${update.tel} <br>
			Email:${update.mail}<br>
			住所:${update.address}<br>
		</div>
		<p class="center_area none" >
			<a href="/searchinn/GuestInfoChangeServlet?action=guest" class="btn">変更</a>
			<a href="/searchinn/GGuestInfoServlet?action=info" class="btn">キャンセル</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>