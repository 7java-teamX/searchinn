<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況閲覧</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveInfo.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>
<div class="container">
	<h2>予約内容閲覧</h2>
	<hr>
	<!-- for Eachで予約情報の繰り返し -->
	<!-- pc画面1000px前後  -->
	<c:forEach var="reserveInfo" items="${reserveList}" varStatus="status">
		<div class="reserveBox">
			チェックイン：<c:out value="${reserveInfo.checkin}"/><!--ホテル名  -->
			<div class="planArea">
				<div class="text">
					ホテル名<c:out value="${reserveInfo.hotelName}"/><br><!--ホテル名  -->
					プラン名<c:out value="${reserveInfo.planName}"/><br><!--プラン名  -->
					予約内容の詳細<c:out value="${reserveInfo.planDetail}"/><br><!--予約内容の詳細  -->
				</div>
				<img src="<c:out value="${reserve.planImage}"/>" width="300" height="300" alt="<c:out value="${reserve.reserveId}"/>sasas"><!--予約プランの画像  -->
			</div>
			<div class="reserveArea">
				<div class="str">予約内容</div>
				<div class="reserveText">
					宿泊期間：<c:out value="${reserveInfo.reserveDate}"/><br><!--宿泊期間 -->
					宿泊日数：<c:out value="${reserveInfo.numOfNights}"/>日<br><!--宿泊日/宿泊日数  -->
					大人人数：<c:out value="${reserveInfo.numOfAdults}"/>人<br><!--大人人数  -->
					子供人数：<c:out value="${reserveInfo.numOfChildren}"/>人<br><!--子供人数  -->
					合計料金：￥<c:out value="${reserveInfo.charge}"/><br><!--子供人数  -->
					メモ<br><c:out value="${reserveInfo.reserveMemo}"/><br><!--メモ -->
				</div>

				<div class="btnArea">
					<a href="/searchinn/GReserveInfoChangeServlet?index=<c:out value="${status.index}" />" class="btn">予約内容変更</a>
					<a href="#" class="btn" onclick="doConfirm(<c:out value="${reserveInfo.reserveId}" />)">
					予約キャンセル</a>
				</div>
			</div>
		</div><!--  -->
	</c:forEach>
</div><!-- container -->
<footer>
	<jsp:include page="/include/footer.jsp" />
</footer>

<script>
function doConfirm(reservId){
  if(window.confirm("予約を取り消します\nよろしいですか")){
    location.href = "/searchinn/GReserveInfoDeleteServlet?reserveId="+ reservId;
  }
}
</script>
</body>
</html>