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
	<form action="/serchinn/PlanReserve" method="post">
		<div>
			<h3>【宿泊日程】</h3>
			<p>
				宿泊開始日：
				<input type="date" name="checkin">
			</p>
			<p>
				泊数：
				<select name="nigths">
					<c:forEach var="i" begin="1" end="6">
						<option value=${i} >${i}泊${i+1}日</option>
					</c:forEach>
				</select>
			</p>
		</div>
		<div>
			<h3>【利用者】</h3>
			<p>
				大人：
				<select name="numAdult">
					<c:forEach var="i" begin="1" end="2">
						<option value=${i} >${i}</option>
					</c:forEach>
				</select>
				名
			</p>
			<p>
				小人：
				<select name="numChild">
					<c:forEach var="i" begin="0" end="2">
						<option value=${i} >${i}</option>
					</c:forEach>
				</select>
				名
			</p>
		</div>
		<div>
			備考欄：
			<input type="text" name="memo">
		</div>
		<input type="submit" value="予約（確認画面へ）">
	</form>

	<b><c:out value="${calMap.year}年${calMap.month}月の空室状況"/></b>

	<div>
		<form action="/searchinn/PlanReserveServlet" method="get">
			<input type="month" name="ym" value="${calMap.ym}">
			<input type="submit" value="表示"/>
		</form>
	</div>
	<div>
		${calMap.calendar}
	</div>
</body>
</html>