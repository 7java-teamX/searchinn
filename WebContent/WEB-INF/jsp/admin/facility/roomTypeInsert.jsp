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
		<form action="/searchinn/RoomTypeEditServlet" method="post">
			<table>
				<tr>
					<th>部屋タイプ名</th>
					<td><input type="text" name="roomTypeName"  /></td>
				</tr>
				<tr>
					<th>大人最大人数</th>
					<td><input type="number" min="1" name="adultCapacity" /></td>
				</tr>
				<tr>
					<th>小人最大人数</th>
					<td><input type="number" name="childCapacity"  /></td>
				</tr>
				<tr>
					<th>大人料金</th>
					<td><input type="number" name="adultCharge"  /></td>
				</tr>
				<tr>
					<th>小人料金</th>
					<td><input type="number" name="childCharge"  /></td>
				</tr>
			</table>
		<input type="hidden" name="action" value="insertConfirm" />
		<input type="submit" />
		</form>
	</div>
</body>
</html>