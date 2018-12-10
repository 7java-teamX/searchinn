<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	登録内容変更完了</title>
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
		<p  class="center_area none">
		<br><br>
			変更完了しました
		</p>
		<p class="center_area none">
			<a href="/searchinn/GGuestInfoServlet?action=info" class="btn">ゲスト情報ページ</a>

			<a href="/searchinn/MainServlet?action=mypage" class="btn">マイページ</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>