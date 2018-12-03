<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約詳細</title>
<style>
.contents-box{
	border: 2px solid skyblue;
}
.title{
	border: 2px solid skyblue;
}
.info{
	background-color:#C0C0C0;
}
.btn{
	border: 1px solid #FFDEAD ;
	background-color:#FFE4B5 ;
	text-decoration: none;
	//padding:5px 10px;
	font-size:20px;
}
.container{
	margin : 0 auto;
	width;85% ;
}
img{
	border: 1px solid #C0C0C0 ;
}
</style>
</head>
<body>
<h1>予約詳細</h1>
<div class="container">
	<div class="contents-box">
		<div class="title">プラン情報</div>
		<div class="info">
			<c:out value="${reserveInfo.hotelName}"/><br><!-- ホテル名前 -->
			<c:out value="${reserveInfo.planName}"/><br><!-- プラン名前 -->
			<c:out value="${reserveInfo.planDetail}"/><br><!-- プラン詳細 -->
			<img src="<c:out value="${reserveInfo.planImage}"/>" width="300" height="300"><br><!-- プラン画像-->
			大人1人当たり \<c:out value="${reserveInfo.adultCharge}"/> / <!--大人料金 -->
			子供1人当たり \<c:out value="${reserveInfo.childCharge}"/><!--子供料金 -->
		</div>
	</div>

	<div class="contents-box">
		<div class="title">予約情報</div>
		<div class="info">
				予約ID:<c:out value="${reserveInfo.reserveId}"/><br>
				日程:<c:out value="${reserveInfo.reserveDate}"/><br>
				大人:<c:out value="${reserveInfo.numOfAdults}"/>人
				子供:<c:out value="${reserveInfo.numOfChildren}"/>人<br>
				合計料金:<c:out value="${reserveInfo.charge}"/><br>
				メモ<br>
				<c:out value="${reserveInfo.reserveMemo}"/>
			<hr>
				顧客ID：<c:out value="${reserveInfo.guestId}"/><br>
				顧客名：<c:out value="${reserveInfo.guestName}"/><br>
				顧客カナ：<c:out value="${reserveInfo.guestKana}"/><br>
				生年月日：<c:out value="${reserveInfo.guestBirthday}"/><br>
				住所：<c:out value="${reserveInfo.guestAddress}"/><br>
				電話番号：<c:out value="${reserveInfo.guestTel}"/><br>
				メールアドレス：<c:out value="${reserveInfo.guestMail}"/><br>
		</div>
	</div>
	<a class="btn" href="AReservetInfoChangeServlet">予約変更</a>
	<a class="btn" href="AReserveInfoDeleteServlet?index=<c:out value="${reserveInfo.reserveId}" />">削除</a>
</div>


</body>
</html>