<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>BOOKINN | 管理者・施設管理</title>
</head>
<body>
	<h3>エリア</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
		</tr>
		<c:forEach var="area" items="<c:out value="${areaList}" />">
			<tr>
				<td><c:out value="${area.areaId}" /></td>
				<td><c:out value="${area.areaName}" /></td>
			</tr>
		</c:forEach>
	</table>

	<h3>ホテル</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>エリアID</th>
			<th>名前</th>
			<th>住所</th>
			<th>TEL</th>
			<th>MAIL</th>
			<th>image</th>
			<th>詳細</th>
		</tr>
		<c:forEach var="hotel" items="<c:out value="${hotelList}" />">
			<tr>
				<td><c:out value="${hotel.hotelId}" /></td>
				<td><c:out value="${hotel.areaId}" /></td>
				<td><c:out value="${hotel.hotelName}" /></td>
				<td><c:out value="${hotel.address}" /></td>
				<td><c:out value="${hotel.hotelTel}" /></td>
				<td><c:out value="${hotel.hotelMail}" /></td>
				<td><c:out value="${hotel.hotelImage}" /></td>
				<td><c:out value="${hotel.hotelDetail}" /></td>
			</tr>
		</c:forEach>
	</table>

	<h3>部屋タイプ</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>大人キャパ</th>
			<th>小人キャパ</th>
			<th>大人料金</th>
			<th>小人料金</th>
		</tr>
		<c:forEach var="roomType" items="<c:out value="${roomTypeList}" />">
			<tr>
				<td><c:out value="${roomType.roomTypeId}" /></td>
				<td><c:out value="${roomType.roomTypeName}" /></td>
				<td><c:out value="${roomType.adultCapacity}" /></td>
				<td><c:out value="${roomType.childCapacity}" /></td>
				<td><c:out value="${roomType.adultCharge}" /></td>
				<td><c:out value="${roomType.childCharge}" /></td>
			</tr>
		</c:forEach>
	</table>


	<a href="/searchinn/FacilityServlet"></a>

</body>
</html>