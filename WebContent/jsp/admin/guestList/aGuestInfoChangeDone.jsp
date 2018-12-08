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
<title>顧客内容完了画面</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>顧客内容完了画面</h2>

<div class="container">
	<div class="center-box">
		<h2>変更完了しました</h2>
		<p><a href="/searchinn/AGuestListServlet?action=list" class="btn">一覧ページへ</a></p>
	</div>
</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>