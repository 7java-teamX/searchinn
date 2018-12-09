<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">

<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>

<jsp:include page="/include/header.jsp"/>
	<div class="container">
		<div class="main_menu">
			<h2>管理者画面</h2>
			<div class="center">
				<p><a href="#" class="square_btn">顧客情報管理</a></p>
				<p><a href="/searchinn/jsp/admin/sales.jsp" class="square_btn">売上集計</a></p>
				<p><a href="#" class="square_btn">予約状況一覧</a></p>
				<p><a href="/searchinn/FacilityServlet" class="square_btn">施設管理</a></p>
			</div>
		</div>

	</div>

<jsp:include page="/include/footer.jsp"/>

</body>
</html>