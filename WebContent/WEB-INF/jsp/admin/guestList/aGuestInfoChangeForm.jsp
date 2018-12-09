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
<title>顧客内容入力画面</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>顧客内容入力画面</h2>

<div class="container">
	<div class="center-box">

		<form action="/searchinn/GuestInfoChangeServlet?action=admin" method="post">
		<input type="hidden" name="id" value="${guestDetail.guestId}">
		<table>
			<tr>
				<th>name</th>
				<td>
					<input type="text" name="name" autocomplete="on" list="nowName" required>
					<datalist id="nowName">
						<option value="${guestDetail.name}">
					</datalist>
				</td>
			</tr>
			<tr>
				<th>kana</th>
				<td>
					<input type="text" name="kana" autocomplete="on" list="nowKana" required>
					<datalist id="nowKana">
						<option value="${guestDetail.kana}">
					</datalist>
				</td>
			</tr>
			<tr>
				<th>TEL</th>
				<td>
					<input type ="text" name="tel" autocomplete="on" list="nowTel" required>
					<datalist id="nowTel">
						<option value="${guestDetail.tel}">
					</datalist>
				</td>
			</tr>
			<tr>
				<th>EMail</th>
				<td>
					<input type ="email" name="email" autocomplete="on" list="nowMail" required>
					<datalist id="nowMail">
						<option value="${guestDetail.mail}">
					</datalist>
				</td>
			</tr>

			<tr>
				<th>address</th>
				<td>
					<input type ="text" name="address" autocomplete="on" list="nowAddress" required>
					<datalist id="nowAddress">
						<option value="${guestDetail.address}">
					</datalist>
				</td>
			</tr>

			<tr>
				<th colspan="2">
					<input type="reset" id="submit">
					<input type="submit" value="変更" id="submit">
				</th>
			</tr>
		</table>
		</form>
	</div>
</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>