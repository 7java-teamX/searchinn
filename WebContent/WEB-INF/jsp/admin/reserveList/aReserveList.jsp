<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況閲覧</title>
<style>
table,th,td{border: solid 1px black;}
.bg{ 	height:35px; }
</style>
</head>
<body>
<h2>予約状況閲覧</h2>
<form action="/searchinn/AReserveInfoServlet" method="post">
	期間：<input type="date" name="day" value="<c:out value="${refineSearch.day}" />" ><br>
	ホテルの名前：<input type="text" name="hotelName"
	value="<c:out value="${refineSearch.hotelName}" />"><br>
	プランの名前：<input type="text" name="planName"
	value="<c:out value="${refineSearch.planName}" />"><br>
	予約者の名前：<input type="text" name="guestName"
	value="<c:out value="${refineSearch.guestName}" />"><br>
	<input type="submit" value="送信" class="bg">
	<a href="/searchinn/AReserveListServlet?action=delete" class="bg">検索条件のリセット</a>
</form>

<hr>

<table style="border: solid 1px black;">
	<tr>
		<th>予約ID</th>
		<th>ホテル名</th>
		<th>プラン名</th>
		<th>宿泊者</th>
		<th>宿泊者ID</th>
		<th>日程</th>
		<th></th>
	</tr>

	<!-- for Eachで繰り返し文 -->
	<c:forEach var="reserve" items="${reserveList}" varStatus="status">
	<tr>
		<td><c:out value="${reserve.reserveId}"/></td>
		<td><c:out value="${reserve.hotelName}"/></td>
		<td><c:out value="${reserve.planName}"/></td>
		<td><c:out value="${reserve.guestName}"/></td>
		<td><c:out value="${reserve.guestId}"/></td>
		<td><c:out value="${reserve.reserveDate}"/></td>
		<td><a href="AReserveInfoServlet?index=<c:out value="${status.index}" />">詳細</a>
		</td>
	</tr>
	</c:forEach>
</table>
<hr>
<a href="/searchinn/AdminMenuServlet">管理者TOP</a>
</body>
</html>