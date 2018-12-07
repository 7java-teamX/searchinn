<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
</head>
<body>
<p><a href = "/searchinn/jsp/admin/admin.jsp">"管理者機能一覧へ</a></p>
<p><a href = "/searchinn/AGuestListServlet?action=list">"顧客情報一覧へ</a></p>
<p>絞り込み検索</p>
<form action="/searchinn/GuestInfoServlet" method="post">
	<p>ゲストID:<input type="number" name="id"></p>
	<p>ユーザー名:<input type="text" name="name"></p>
	<p>かな:<input type="text" name="kana"></p>
	<p>TEL:<input type ="tel" name="tel"></p>
	<p>EMail:<input type ="email" name="email"></p>
	<input type="submit" value="検索">
</form>

<!-- 以下に 一覧表示 -->
<c:forEach var="guest" items="${guestList}">
	<p>id:${guest.guestId} 名前:${guest.name} かな:${guest.kana} TEL:${guest.tel} Email:${guest.mail}
	<a href="/searchinn/GuestInfoServlet?id=<c:out value="${guest.guestId}"/>">詳細</a></p>
</c:forEach>
</body>
</html>