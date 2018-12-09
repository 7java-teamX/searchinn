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
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveList.css">
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>予約状況閲覧</h2>
<div class="container">

<p>
	<a class="btn" href="/searchinn/AdminMenuServlet">管理者TOP</a>
</p>

<form action="/searchinn/AReserveInfoServlet" method="post">
	<table>
				<tr>
					<td>期間<input type="date" name="day" value="<c:out value="${refineSearch.day}" />"></td>
					<td><input type="text" name="hotelName"  value="<c:out value="${refineSearch.hotelName}" />"
					placeholder="ホテルの名前"></td>
					<td><input type="text" name="planName"	value="<c:out value="${refineSearch.planName}" />"
					placeholder="プランの名前"></td>
					<td><input type="text" name="guestName" value="<c:out value="${refineSearch.guestName}" />"
					placeholder="予約者の名前"></td>
					<td>
						<input type="submit" value="検索" id="submit">&nbsp;	&nbsp;
						<input type="reset" value="リセット" id="submit">
					</td>
				<tr>
		</table>
		<p>
			<small>※予約情報は日付  ホテル名 プラン名 予約者の名前  で絞り込み検索が可能です</small>
		</p>
		<p>
			<a href="/searchinn/AReserveListServlet?action=delete" class="bg">検索条件のリセット</a>
		</p>

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
</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>