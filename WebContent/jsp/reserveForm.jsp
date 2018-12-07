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
	<form action="/searchinn/PlanReserveServlet" method="post">
		<div>
			<h3>【宿泊日程】</h3>
			<p>
				宿泊開始日：
				<input type="date" name="checkin"
				min="<c:out value="${today}" />" max="<c:out value="${afterDay}" />">
			</p>
			<p>
				泊数：
				<select name="nights">
					<c:forEach var="i" begin="1" end="6">
						<option value=<c:out value="${i}" /> ><c:out value="${i}泊${i+1}日" /></option>
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
						<option value=<c:out value="${i}" /> ><c:out value="${i}" /></option>
					</c:forEach>
				</select>
				名
			</p>
			<p>
				小人：
				<select name="numChild">
					<c:forEach var="i" begin="0" end="2">
						<option value=<c:out value="${i}" /> ><c:out value="${i}" /></option>
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

	<c:if test="${not empty errMsg}">
		<h3><c:out value="${errMsg}"></c:out></h3>
	</c:if><!-- 予約重複時にエラーメッセージの出力を行う -->

	<hr>

	<h4><c:out value="${calMap.year}年${calMap.month}月の空室状況"/></h4>

	<div>
		<form action="/searchinn/PlanReserveServlet?action=show" method="get">
			<input type="month" name="ym" value=<c:out value="${calMap.ym}" /> >
			<input type="submit" value="表示"/>
		</form>
	</div>
	<div>
		${calMap.calendar}
	</div>
</body>
</html>