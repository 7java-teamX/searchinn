<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/registerGuestFormStyle.css">
<title>会員情報入力</title>
</head>
<body>
<div class="main">
		<h2>会員情報登録</h2>
		<div class="container">
			<form action="/registerGuest"method="post">
				<table>
					<tr>
						<th>お名前</th>
						<td><input type="text" size="30" name="guestName"></td>
					</tr>
					<tr>
						<th>カナ</th>
						<td><input type="text" size="30" name="guestKana"></td>
					</tr>
					<tr>
						<th>生年月日</th>
						<td><input type="text" size="30"name="guestBirthday"></td>
					</tr>
					<tr>
						<th>ユーザーID</th>
						<td><input type="text" size="30" name="guestId"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="text" size="30" name="guestPass"></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><input type="text" size="30" name="guestTel"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="email" size="30"name="guestMail"></td>
					</tr>
					<tr>
						<th>ご自宅住所</th>
						<td><input type="text" size="30" name="guestAdress"></td>
					</tr>
				</table>
				<p>
					<input type="submit" formaction="registerGuestConfirm.html"value="確認">
					<input type="reset" value="リセット">
				</p>
			</form>
		</div>
	</div>
	<p>
		<a class="center" href="../index/index.html">TOPへ戻る</a>
	</p>
</body>
</html>