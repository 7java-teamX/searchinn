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
					<td><input type="number" min="1" name="hotelId" value="<c:out value="${plan.hotelId}" />" /></td>
				</tr>
				<tr>
					<th>部屋タイプID</th>
					<td><input type="number" name="roomTypeId" value="<c:out value="${plan.roomTypeId}" />" /></td>
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
		<input type="submit" />
		</form>
	</div>
</body>
</html>