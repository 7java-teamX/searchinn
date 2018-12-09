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
<title>顧客情報詳細</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>顧客情報削除完了</h2>

<div class="container">
	<div class="center-box">
		<table>
			<tr>
				<th>id:</th>
				<td>${guestDetail.guestId}</td>
			</tr>
			<tr>
				<th>名前:</th>
				<td>${guestDetail.name}</td>
			</tr>
			<tr>
				<th>かな:</th>
				<td>${guestDetail.kana}</td>
			</tr>
			<tr>
				<th>誕生日:</th>
				<td>${guestDetail.birthday}</td>
			</tr>
			<tr>
				<th>TEL:</th>
				<td>${guestDetail.tel}</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td>${guestDetail.mail}</td>
			</tr>
			<tr>
				<th>住所:</th>
				<td>${guestDetail.address}</td>
			</tr>

		</table>

<p><a href="/searchinn/aGuestInfoChangeForm.jsp" class="btn">変更</a>
<a href="/searchinn/GuestInfoDeleteServlet" class="btn">削除</a>
<a href="/searchinn/aGuestList.jsp" class="btn">戻る</a></p>
	</div>

</div>


<jsp:include page="/include/footer.jsp"/>
</body>
</html>