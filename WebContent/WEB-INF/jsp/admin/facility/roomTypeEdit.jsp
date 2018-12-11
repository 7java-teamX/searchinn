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
<title>部屋詳細変更画面</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
	<h2>部屋詳細変更画面</h2>
	<div class="container">
		<div class="center-box">
			<form action="/searchinn/RoomTypeEditServlet" method="post">
				<table>
					<tr>
						<th>ID</th>
						<td><c:out value="${roomType.roomTypeId}" /><input type="hidden" name="roomTypeId" value="<c:out value="${roomType.roomTypeId}" />" /></td>
					</tr>
					<tr>
						<th>部屋タイプ名</th>
						<td><input type="text" name="roomTypeName" value="<c:out value="${roomType.roomTypeName}" />" /></td>
					</tr>
					<tr>
						<th>大人最大人数</th>
						<td><input type="number" min="1" name="adultCapacity" value="<c:out value="${roomType.adultCapacity}" />" /></td>
					</tr>
					<tr>
						<th>小人最大人数</th>
						<td><input type="number" name="childCapacity" value="<c:out value="${roomType.childCapacity}" />" /></td>
					</tr>
					<tr>
						<th>大人料金</th>
						<td><input type="number" name="adultCharge" value="<c:out value="${roomType.adultCharge}" />" /></td>
					</tr>
					<tr>
						<th>小人料金</th>
						<td><input type="number" name="childCharge" value="<c:out value="${roomType.childCharge}" />" /></td>
					</tr>
				</table>
			<input type="hidden" name="action" value="editConfirm" />
			<input type="submit" id="submit"/>
			</form>
		</div>
	</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>