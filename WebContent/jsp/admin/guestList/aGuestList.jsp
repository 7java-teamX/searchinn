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
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestList.css">
<title>顧客情報一覧</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>

<h2>顧客情報一覧</h2>

<div class="container">
		<p><a href = "/searchinn/jsp/admin/admin.jsp">"管理者機能一覧へ</a>
			<a href = "/searchinn/AGuestListServlet?action=list">"顧客情報一覧へ</a></p>
		<table>
			<tr>
				<td><input type="number" name="id" placeholder="ゲストID"></td>
				<td><input type="text" name="name" placeholder="ユーザー名"></td>
				<td><input type="text" name="kana" placeholder="かな"></td>
				<td><input type ="email" name="email" placeholder="EMail"></td>
			<tr>
		</table>

		<hr>

		<table>
			<tr>
				<th>id</th>
				<th>名前</th>
				<th>かな</th>
				<th>TEL</th>
				<th>Email</th>
				<th></th>
			</tr>
			<c:forEach var="guest" items="${guestList}">
			<tr>
				<td>${guest.guestId}</td>
				<td>${guest.name}</td>
				<td>${guest.kana}</td>
				<td>${guest.tel}</td>
				<td>${guest.mail}/td>
				<td>
					<a href="/searchinn/GuestInfoServlet?id=<c:out value="${guest.guestId}"/>">詳細</a>
				</td>
			</tr>
			</c:forEach>
		</table>

</div>

<p>絞り込み検索</p>
<form action="/searchinn/GuestInfoServlet" method="post">
	<input type="reset" value="検索">
	<input type="submit" value="検索">
</form>

<!-- 以下に 一覧表示 -->

</body>
</html>