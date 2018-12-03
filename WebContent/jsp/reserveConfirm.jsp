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
<c:out value="予約ID：${reserve.reserveId}" />
<c:out value="大人：${reserve.numOfAdults}" />
<c:out value="小人：${reserve.numOfChildren}" />
<c:out value="チェックイン日：${reserve.checkin}" />
<c:out value="泊数：${reserve.numOfNights}" />
<c:out value="宿泊日程：${reserve.reserveDate}" />
<c:out value="料金：${reserve.charge}" />
<c:out value="備考：${reserve.reserveMemo}" />

<c:out value="プラン名：${reserve.planName}" />
<img alt="プランイメージ" src="<c:out value="${reserve.planImage}" />">
<c:out value="プラン詳細：${reserve.planDetail}" />

<c:out value="部屋タイプ：${reserve.roomTypeName}" />
<c:out value="大人料金：${reserve.adultCharge}" />
<c:out value="小人料金：${reserve.childCharge}" />
【宿泊先情報】
<c:out value="ホテル名：${reserve.hotelName}" />
<c:out value="住所：${reserve.hotelAddress}" />
<c:out value="電話番号：${reserve.hotelTel}" />
<c:out value="メール：${reserve.hotelMail}" />
<img alt="ホテルイメージ" src="<c:out value="${reserve.hotelImage}" />">
<c:out value="ホテル詳細：${reserve.hotelDetail}" />
【宿泊者情報】
<c:out value="ID：${reserve.guestId}" />
<c:out value="名前：${reserve.guestName}" />
<c:out value="かな：${reserve.guestKana}" />
<c:out value="TEL：${reserve.guestTel}" />
<c:out value="MAIL：${reserve.guestMail}" />
<c:out value="住所：${reserve.guestAddress}" />


</body>
</html>