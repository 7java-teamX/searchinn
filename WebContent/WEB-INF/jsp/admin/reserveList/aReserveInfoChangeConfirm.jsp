<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約変更確認</title>
</head>
<body>
<h1>予約内容変更確認</h1>

予約ID:<c:out value="${reserveInfo.reserveId}"/><br>
メモ:<c:out value="${reserveInfo.reserveMemo}"/><br>
宿泊日数：<c:out value="${reserveInfo.numOfNights}"/>日<br>
宿泊期間：<c:out value="${reserveInfo.reserveDate}"/><br>
大人人数：<c:out value="${reserveInfo.numOfAdults}"/>人<br>
子供人数：<c:out value="${reserveInfo.numOfChildren}"/>人<br>
合計料金：<c:out value="${reserveInfo.charge}"/>

<a class="btn" href="AReserveInfoChangeServlet?action=done">予約変更</a>
<a class="btn" href="AReserveInfoChangeServlet">戻る</a>

</body>
</html>