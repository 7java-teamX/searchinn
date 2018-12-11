<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/facilyty.css">
<title>プラン詳細変更</title>
</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp"/>
	</header>
	<div class="container">
	<h2>プラン詳細変更</h2>
		<div class="center-box">
			<form action="/searchinn/PlanEditServlet" method="post">
				<table>
					<tr>
						<th>プランID</th>
						<td><c:out value="${plan.planId}" /></td>
					</tr>
					<tr>
						<th>プラン名</th>
						<td><input type="text" name="planName" value="<c:out value="${plan.planName}" />" /></td>
					</tr>
					<tr>
						<th>ホテルID</th>
						<td>
						<select name="hotelId">
							<c:forEach var="hotel" items="${hotelAll}">
								<option value="${hotel.hotelId}">${hotel.hotelId}(${hotel.hotelName})</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<th>部屋タイプID</th>
							<td>
								<select>
									<c:forEach var="roomType" items="${roomTypeAll}">
									 	<option value="${roomType.roomTypeId}">${roomType.roomTypeId}(${roomType.roomTypeName}：大人最大${roomType.adultCapacity}人，小人最大${roomType.childCapacity}人，大人料金${roomType.adultCharge}円，小人料金${roomType.childCharge}円)</option>
									</c:forEach>
								</select>
							</td>
					</tr>
					<tr>
						<th>部屋数</th>
						<td><input type="number" name="numRoom" value="<c:out value="${plan.numRoom}" />" /></td>
					</tr>
					<tr>
						<th>image</th>
						<td><input type="text" name="planImage" value="<c:out value="${plan.planImage}" />" /></td>
					</tr>
					<tr>
						<th>説明</th>
						<td><input type="text" name="planDetail" value="<c:out value="${plan.planDetail}" />" /></td>
					</tr>
				</table>
			<input type="hidden" name="planId" value="<c:out value="${plan.planId}" />" />
			<input type="hidden" name="action" value="editConfirm" />
			<input type="submit" id="submit"/>
			</form>
		</div>
	</div>
	<jsp:include page="/include/footer.jsp"/>
</body>
</html>