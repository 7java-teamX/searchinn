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
<title>予約変更確定</title>

</head>

<body>
<jsp:include page="/include/header.jsp"/>

<h2>予約変更確定</h2>
<div class="container" style="margin-bottom:200px">

<p class="bold">予約内容は変更されました!!</p>
<p>
	<a class="btn" href="AReserveListServlet">予約一覧へ戻る</a>
</p>
<hr>
<p>
	<a href="/searchinn/jsp/admin/admin.jsp">管理者TOP</a>
</p>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>