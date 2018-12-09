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
<title>部屋タイプ追加入力確認画面</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
	<h2>部屋タイプ追加入力確認画面</h2>
	<div class="container">
		<div class="center-box">
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
			<a href="/searchinn/RoomTypeServlet?action=insertDone" class="btn">確定</a>
		</div>
	</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>