<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約変更確認</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveInfo.css">
</head>
<body>

<jsp:include page="/include/header.jsp"/>

<div class="container">
	<div class="box">
		<h3 class="title" >予約内容変更確認</h3>
		<div class="center_area">
			<c:out value="${reserveInfo.planName}"/><br>
			予約ID:<c:out value="${reserveInfo.reserveId}"/><br>

			宿泊日数：<c:out value="${reserveInfo.numOfNights}"/>日<br>
			宿泊期間：<c:out value="${reserveInfo.reserveDate}"/><br>
			大人人数：<c:out value="${reserveInfo.numOfAdults}"/>人<br>
			子供人数：<c:out value="${reserveInfo.numOfChildren}"/>人<br>
			合計料金：<c:out value="${reserveInfo.charge}"/>
			メモ:<br><c:out value="${reserveInfo.reserveMemo}"/><br>
		</div>


		<div class="center_area none">
			<small>こちらの内容で問題ないですか？</small><br>
			<a class="btn" href="GReserveInfoChangeServlet?index=done">はい</a>
			<a class="btn" href="GReserveInfoChangeServlet">戻る</a>
		</div>
	</div> <!-- box-->
</div> <!-- container -->


<jsp:include page="/include/footer.jsp"/>
</body>
</html>