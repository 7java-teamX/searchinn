<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約確認画面</title>
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
		<h4 class="siro">入力確認</h4><span class="spanao">→</span>
		<h4 class="ao">予約確定</h4>
	</div>
</header>

<div class="container">
	<div class="box">
		<div class="title">&nbsp;	プラン詳細</div>
		<div class="flex" style="width:97%;">
			<div class="detail">
				プラン名：<c:out value="${reserve.planName}" /><br>
				プラン詳細：<c:out value="${reserve.planDetail}" /><br>
				部屋タイプ：<c:out value="${reserve.roomTypeName}" /><br>
				<small>
					大人料金：<c:out value="${reserve.adultCharge}" />円/１人<br>
					小人料金：<c:out value="${reserve.childCharge}" />円/１人
				</small>
			</div>
			<img alt="プランイメージ" src="<c:out value="${reserve.planImage}" />"
			width="300" height="230" class="img"><br>
		</div>
	</div>

	<div class="box">
		<div class="title">&nbsp;	予約詳細</div>
		<div class="detail2 ">
			<c:out value="大人：${reserve.numOfAdults}" />&nbsp;&nbsp;
			<c:out value="小人：${reserve.numOfChildren}" /><br>
			<c:out value="チェックイン日：${reserve.checkin}" />&nbsp;&nbsp;
			<c:out value="泊数：${reserve.numOfNights}" />泊<br>
			<c:out value="宿泊日程：${reserve.reserveDate}" /><br>
			<c:out value="料金：${reserve.charge}" /><br>
			<c:out value="備考：${reserve.reserveMemo}" /><br>
		</div>
	</div>

	<div class="box">
		<div class="title">&nbsp;	宿泊先情報</div>
		<div class="flex">
			<div class="detail">
				<c:out value="ホテル名：${reserve.hotelName}" /><br>
				<c:out value="住所：${reserve.hotelAddress}" /><br>
				<c:out value="電話番号：${reserve.hotelTel}" /><br>
				<c:out value="メール：${reserve.hotelMail}" /><br>
				<c:out value="ホテル詳細：${reserve.hotelDetail}" /><br>
			</div>
			<img alt="ホテルイメージ" src="<c:out value="${reserve.hotelImage}" />"
			 class="img" width="200" height="130"><br>
		</div>
	</div>



	<div class="box">
		<div class="title">&nbsp;	予約者情報</div>
		<div class="detail2 ">
			<c:out value="ID：${reserve.guestId}" /><br>
			<c:out value="名前：${reserve.guestName}" /><br>
			<c:out value="かな：${reserve.guestKana}" /><br>
			<c:out value="TEL：${reserve.guestTel}" /><br>
			<c:out value="MAIL：${reserve.guestMail}" /><br>
			<c:out value="住所：${reserve.guestAddress}" /><br>
		</div>
	</div>
	<p class="btn_area">
		<a href="/searchinn/PlanReserveServlet?action=done" class="btn2">予約</a>
	</p>

</div>

<jsp:include page="/include/footer.jsp" />
</body>
</html>