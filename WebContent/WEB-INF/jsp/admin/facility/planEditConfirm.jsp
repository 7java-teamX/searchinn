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
<title></title>
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>
	<h2>プラン詳細確認画面</h2>
	<div class="container">
		<div class="center-box">
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
			<p>
				<a class="btn" href="/searchinn/PlanEditServlet?action=editDone">確定</a>
			<p>
		</div>
	</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>