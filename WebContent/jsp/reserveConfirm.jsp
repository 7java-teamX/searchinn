<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>プラン詳細</h3>
<c:out value="プラン名：${reserve.planName}" /><br>
<img alt="プランイメージ" src="<c:out value="${reserve.planImage}" />"><br>
<c:out value="プラン詳細：${reserve.planDetail}" /><br>
<c:out value="部屋タイプ：${reserve.roomTypeName}" /><br>
<c:out value="大人料金：${reserve.adultCharge}" /><br>
<c:out value="小人料金：${reserve.childCharge}" /><br>

<h3>予約詳細</h3>

<c:out value="大人：${reserve.numOfAdults}" /><br>
<c:out value="小人：${reserve.numOfChildren}" /><br>
<c:out value="チェックイン日：${reserve.checkin}" /><br>
<c:out value="泊数：${reserve.numOfNights}" /><br>
<c:out value="宿泊日程：${reserve.reserveDate}" /><br>
<c:out value="料金：${reserve.charge}" /><br>
<c:out value="備考：${reserve.reserveMemo}" /><br>

<h3>宿泊先情報</h3>
<c:out value="ホテル名：${reserve.hotelName}" /><br>
<c:out value="住所：${reserve.hotelAddress}" /><br>
<c:out value="電話番号：${reserve.hotelTel}" /><br>
<c:out value="メール：${reserve.hotelMail}" /><br>
<img alt="ホテルイメージ" src="<c:out value="${reserve.hotelImage}" />"><br>
<c:out value="ホテル詳細：${reserve.hotelDetail}" /><br>

<h3>予約者情報</h3>
<c:out value="ID：${reserve.guestId}" /><br>
<c:out value="名前：${reserve.guestName}" /><br>
<c:out value="かな：${reserve.guestKana}" /><br>
<c:out value="TEL：${reserve.guestTel}" /><br>
<c:out value="MAIL：${reserve.guestMail}" /><br>
<c:out value="住所：${reserve.guestAddress}" /><br>

<a href="/searchinn/PlanReserveServlet?action=done">予約</a>



</body>
</html>