<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/registerGuestForm.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<script type="text/javascript" src="js/formCheck.js"></script>
<script type="text/javascript" src=""></script>
<title>会員情報入力</title>
</head>
<body>

<jsp:include page="/include/header.jsp"/>
	<div class="container">
		<h2>会員情報登録</h2>
		<div class="box">
			<form action="/searchinn/RegisterGuestServlet"method="post">
				<table>
					<tr>
						<th>お名前</th>
						<td><input type="text" size="50" name="guestName"></td>
					</tr>
					<tr>
						<td id="btn1" class="btn"></td>
					</tr>
					<tr>
						<th>カナ</th>
						<td><input type="text" size="50" name="guestKana"></td>
					</tr>
					<tr>
						<td id="btn2" class="btn"></td>
					</tr>
					<tr>
						<th>生年月日</th>
						<td><input type="text" size="50"name="guestBirthday"></td>
					</tr>
					<tr>
						<td id="btn3" class="btn"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" size="50" name="guestPass"></td>
					</tr>
					<tr>
						<td id="btn4" class="btn"></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><input type="text" size="50" name="guestTel"></td>
					</tr>
					<tr>
						<td id="btn5" class="btn"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="email" size="50"name="guestMail"></td>
					</tr>
					<tr>
						<td id="btn6" class="btn"></td>
					</tr>
					<tr>
						<th>ご自宅住所</th>
						<td><input type="text" size="50" name="guestAddress"></td>
					</tr>
					<tr>
						<td id="btn7" class="btn"></td>
					</tr>
				</table>
				<p>
					<input type="submit" value="確認">
					<input type="reset" value="リセット">
				</p>
			</form>
		</div>
		<div class="errmsg">
			<c:if test="${not empty errmsg}">
		 		<c:out value="${errmsg}"></c:out>
		 	</c:if>
		</div>
	</div>

	<p>
		<a class="center" href="/searchinn/jsp/index.jsp">TOPへ戻る</a>
	</p>

<jsp:include page="/include/footer.jsp"/>
</body>

</html>