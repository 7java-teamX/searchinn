<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確定</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveInfo.css">
</head>
<body>

<jsp:include page="/include/header.jsp"/>

<div class="container">
	<div class="box">
		<h3 class="title" >キャンセル完了画面</h3>
		<h2 class="center_area none">予約はキャンセルされました</h2>
		<div class="center_area none">
			<a class="btn" href="/searchinn/GReserveListServlet">予約一覧</a>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>