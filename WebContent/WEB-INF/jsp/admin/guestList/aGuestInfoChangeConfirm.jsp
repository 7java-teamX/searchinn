<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更確認</title>
</head>
<body>
<h2>変更確認</h2>
<h3>変更前</h3>
<p>名前:${guestDetail.name} </p>
<p>かな:${guestDetail.kana}</p>
<p>TEL:${guestDetail.tel} </p>
<p>Email:${guestDetail.mail}</p>
<p>住所:${guestDetail.address}</p>
<h3>変更後</h3>
<p>名前:${update.name} </p>
<p>かな:${update.kana}</p>
<p>TEL:${update.tel} </p>
<p>Email:${update.mail}</p>
<p>住所:${update.address}</p>
<p><a href="/searchinn/GuestInfoChangeServlet?action=admin">変更</a></p>
<p><a href="/searchinn/AGuestListServlet">キャンセル</a></p>
</body>
</html>