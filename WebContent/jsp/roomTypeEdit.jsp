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
	<div>
		<form action="/searchinn/RoomTypeServlet" method="post">
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
		<input type="submit" />
		</form>
	</div>
</body>
</html>