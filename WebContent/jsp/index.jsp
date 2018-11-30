<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/indexStyle.css">
<link rel="stylesheet" type="text/css" href="../css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="../css/footerStyle.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/indexStyle.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/footerStyle.css">
<title>BOOKINN</title>
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div class="title">
		<h1><a href="#">BOOKINN.com</a></h1>
		<h3 id="hoge">世界最小級のホテル予約サイト</h3><br>
		<h3 id="hoge">ホテル予約ならBOOKINN.com</h3><br>
	</div>

	<br>
	<div id="main">

	<h4 class="siro">ご予約の流れ</h4><span class="spanao">→</span>
	<h4 class="ao">エリア選択</h4><span class="spanao">→</span>
	<h4 class="ao">ホテル選択</h4><span class="spanao">→</span>
	<h4 class="ao">プラン選択</h4><span class="spanao">→</span>
	<h4 class="ao">予約情報入力</h4><span class="spanao">→</span>
	<h4 class="ao">会員登録</h4><span class="spanao">→</span>
	<h4 class="ao">入力確認</h4><span class="spanao">→</span>
	<h4 class="siro">予約確定</h4>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>