<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestForm.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<title>会員情報入力確認</title>

</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div class="container">
	<div class="main1">
	<h2>会員情報確認画面</h2>
		<p>下記のユーザーを登録します</p>
		<table >
			<tr>
				<th>お名前</th>
				<td><c:out value="${regGuest.name}" /></td>
			</tr>

			<tr>
				<th>カナ</th>
				<td><c:out value="${regGuest.kana}" /></td>
			</tr>

			<tr>
				<th>パスワード</th>
				<td><c:out value="${regGuest.pass}" /></td>
			</tr>

			<tr>
				<th>生年月日</th>
				<td><c:out value="${regGuest.birthday}" /></td>
			</tr>

			<tr>
				<th>メールアドレス</th>
				<td><c:out value="${regGuest.mail}" /></td>
			</tr>

			<tr>
				<th>電話番号</th>
				<td><c:out value="${regGuest.tel}" /></td>
			</tr>

			<tr>
				<th>住所</th>
				<td><c:out value="${regGuest.address}" /></td>
			</tr>
		</table>
		<input type="button" value="登録" onClick="location.href='/searchinn/RegisterGuestServlet?action=done'">
		<input type="button" value="キャンセル" onClick="location.href='/searchinn/RegisterGuestServlet?action=null'">

		<h3><a href="registerGuestDone.html"></a></h3>
		<p>
			<a class="center" href="/searchinn/index.jsp">TOPへ戻る</a>
		</p>
	</div>
</div>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>