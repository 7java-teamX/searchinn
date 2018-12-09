<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約変更確定</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveInfo.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>


<div class="container">
	<div class="box">
		<h3 class="title" >予約変更確定</h3>
		<div class="center_area none">
			<br><h3>予約内容は変更されました</h3><br><br>
			<a class="btn" href="/searchinn/GReserveListServlet">予約一覧へ戻る</a>
		</div>
	</div>
</div>

<footer>
	<jsp:include page="/include/footer.jsp" />
</footer>

</body>
</html>