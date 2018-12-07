<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報詳細</title>
</head>
<body>
<h1>顧客情報詳細</h1>

<p>id:${guestDetail.guestId} </p>
<p>名前:${guestDetail.name} </p>
<p>かな:${guestDetail.kana}</p>
<p>誕生日:${guestDetail.birthday}</p>
<p>TEL:${guestDetail.tel} </p>
<p>Email:${guestDetail.mail}</p>
<p>住所:${guestDetail.address}</p>
<p><a href = "/searchinn/aGuestInfoChangeForm.jsp">変更</a></p>
<p><a href = "/searchinn/GuestInfoDeleteServlet">削除</a></p>
<p><a href = "/searchinn/aGuestList.jsp">戻る</a></p>


</body>
</html>