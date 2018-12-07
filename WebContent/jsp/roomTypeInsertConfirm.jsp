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
		<table>
			<tr>
				<th>部屋タイプ名</th>
				<td><c:out value="${roomType.roomTypeName}" /></td>
			</tr>
			<tr>
				<th>大人最大人数</th>
				<td><c:out value="${roomType.adultCapacity}" /></td>
			</tr>
			<tr>
				<th>小人最大人数</th>
				<td><c:out value="${roomType.childCapacity}" /></td>
			</tr>
			<tr>
				<th>大人料金</th>
				<td><c:out value="${roomType.adultCharge}" /></td>
			</tr>
			<tr>
				<th>小人料金</th>
				<td><c:out value="${roomType.childCharge}" /></td>
			</tr>
		</table>
		<a href="/searchinn/RoomTypeServlet?action=insertDone">確定</a>
	</div>
</body>
</html>