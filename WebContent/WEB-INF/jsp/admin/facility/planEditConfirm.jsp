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
				<th>プランID</th>
				<td><c:out value="${plan.planId}" /></td>
			</tr>
			<tr>
				<th>プラン名</th>
				<td><c:out value="${plan.planName}" /></td>
			</tr>
			<tr>
				<th>ホテルID</th>
				<td><c:out value="${plan.hotelId}" /></td>
			</tr>
			<tr>
				<th>部屋タイプID</th>
				<td><c:out value="${plan.roomTypeId}" /></td>
			</tr>
			<tr>
				<th>部屋数</th>
				<td><c:out value="${plan.numRoom}" /></td>
			</tr>
			<tr>
				<th>image</th>
				<td><c:out value="${plan.planImage}" /></td>
			</tr>
			<tr>
				<th>説明</th>
				<td><c:out value="${plan.planDetail}" /></td>
			</tr>
		</table>
		<a href="/searchinn/PlanEditServlet?action=editDone">確定</a>
	</div>
</body>
</html>