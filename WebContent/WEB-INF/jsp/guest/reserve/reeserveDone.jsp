<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約完了画面</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserve.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
	<div id="main">
		<h4 class="ao">ご予約の流れ</h4><span class="spanao">→</span>
		<h4 class="ao">エリア/ホテル選択</h4><span class="spanao">→</span>
		<h4 class="ao">プラン選択</h4><span class="spanao">→</span>
		<h4 class="ao">予約情報入力</h4><span class="spanao">→</span>
		<h4 class="ao">会員登録</h4><span class="spanao">→</span>
		<h4 class="ao">入力確認</h4><span class="spanao">→</span>
		<h4 class="siro">予約確定</h4>
	</div>
</header>

<div class="container">
	<div class="box">
	<br><br><br><br><br>
		<div class="box2">
			<h3>予約完了しました</h3>
			<a href="/searchinn" class="btn">TOPへ</a>
		</div>
	<br><br><br><br><br>
</div>

</div>

<jsp:include page="/include/footer.jsp" />
</body>
</html>