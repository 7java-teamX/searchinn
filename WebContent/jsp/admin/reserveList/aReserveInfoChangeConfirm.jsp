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
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveList.css">
<title>予約内容変更確認</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>

<h2>予約内容変更確認</h2>
<div class="container">
	<table class="guest-text2">
		<tr>
			<th class="guest-text2">予約ID</th>
			<td class="guest-text2"><c:out value="${reserveInfo.reserveId}"/></td>
		</tr>
		<tr>
			<th class="guest-text2">宿泊期間</th>
			<td class="guest-text2"><c:out value="${reserveInfo.reserveDate}"/></td>
		</tr>
		<tr>
			<th class="guest-text2">宿泊日数</th>
			<td class="guest-text2"><c:out value="${reserveInfo.numOfNights}"/>泊</td>
		</tr>

		<tr>
			<th class="guest-text2">大人人数</th>
			<td class="guest-text2"><c:out value="${reserveInfo.numOfAdults}"/>人</td>
		</tr>
		<tr>
			<th class="guest-text2">子供人数</th>
			<td class="guest-text2"><c:out value="${reserveInfo.numOfChildren}"/>人</td>
		</tr>
		<tr>
			<th class="guest-text2">合計料金</th>
			<td class="guest-text2"><c:out value="${reserveInfo.charge}"/></td>
		</tr>
		<tr>
			<th class="guest-text2">メモ</th>
			<td class="guest-text2"><c:out value="${reserveInfo.reserveMemo}"/></td>
		</tr>
	</table>
	<p>
		<small>この内容でお間違いないですか？</small>
	</p>


	<p>
		<a class="btn" href="AReserveInfoChangeServlet?action=done">予約変更</a>
		<a class="btn" href="AReserveInfoChangeServlet">戻る</a>
	</p>

</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>