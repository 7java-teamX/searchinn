<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveList.css">
<title>予約キャンセル確定画面</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>予約キャンセル確定画面</h2>


<div class="container">
	<div class="center-box">
		<p class="strog">予約はキャンセルされました</p>
		<p>
			<a class="btn" href="AReserveListServlet">予約一覧へ</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>