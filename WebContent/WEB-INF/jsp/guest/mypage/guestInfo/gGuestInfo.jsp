<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestInfo.css">
<title>ユーザ情報</title>
</head>
<body>

<jsp:include page="/include/header.jsp"/>

<div class="container">

	<div class="box">
		<div class="center_area">
		<h2 >ユーザー登録情報</h2>
			ユーザー名:${loginUser.name}<br>
			かな:${loginUser.kana}<br>
			TEL:${loginUser.tel}<br>
			EMail:${loginUser.mail}<br>
			Adress:${loginUser.address}<br>
		</div>
		<p class="center_area">
			<a href="/searchinn/gGuestInfoChangeForm.jsp" class="btn">変更</a>
			<a href="/searchinn/jsp/guest/mypage.jsp" class="btn">マイページへ</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>