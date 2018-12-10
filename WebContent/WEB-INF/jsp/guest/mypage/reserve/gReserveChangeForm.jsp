<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況変更</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css"
	href="/searchinn/css/reserveInfo.css">
</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp" />
	</header>
	<div class="container">
		<h1>予約状況変更</h1>
		<div class="reserveBox">
			チェックイン：
			<c:out value="${reserveInfo.checkin}" />
			<!--ホテル名  -->
			<div class="planArea">
				<div class="text">
					ホテル名
					<c:out value="${reserveInfo.hotelName}" />
					<br>
					<!--ホテル名  -->
					プラン名
					<c:out value="${reserveInfo.planName}" />
					<br>
					<!--プラン名  -->
					予約内容の詳細
					<c:out value="${reserveInfo.planDetail}" />
					<br>
					<!--予約内容の詳細  -->
				</div>
				<img src="<c:out value="${reserve.planImage}"/>" width="300"
					height="300" alt="<c:out value="${reserve.reserveId}"/>sasas">
				<!--予約プランの画像  -->
			</div>
			<!-- planArea -->

			<div class="reserveArea">
				<div class="str">予約内容</div>
				<div class="text">
					宿泊期間 :
					<c:out value="${reserveInfo.reserveDate}" />
					<br>
					<!--宿泊期間 -->
					宿泊日数 :
					<c:out value="${reserveInfo.planName}" />
					<br>
					<!--宿泊日/宿泊日数  -->

					大人1人 / \
					<c:out value="${reserveInfo.adultCharge}" />
					<br>
					<!--大人人数  -->
					子供1人 / \
					<c:out value="${reserveInfo.childCharge}" />
					<br>
					<!--子供人数  -->
					<form action="/searchinn/GReserveInfoChangeServlet" method="post">
						大人人数 <select name="numOfAdult">
							<option value="1">1</option>
							<option value="2">2</option>
						</select>人 / 子供人数 <select name="numOfChild">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
						</select><br> メモ:<br>
						<textarea rows="5" cols="40" name="reserveMemo"><c:out
								value="${reserveInfo.reserveMemo}" />
					</textarea>
						<br>
						<!--メモ -->
						<!-- 合計金額：<input type="text" name="charge">円<br> -->
						<input type="submit" value="変更">
					</form>
					<!--子供人数  -->

					<div class="btnArea">
						<a href="/searchinn/GReserveListServlet" class="btn">戻る</a>
					</div>
				</div>
			</div>
			<!-- reserveArea -->
		</div>
		<!-- reserveBox -->
	</div>
	<!-- container -->

	<footer>
		<jsp:include page="/include/footer.jsp" />
	</footer>


</body>
</html>