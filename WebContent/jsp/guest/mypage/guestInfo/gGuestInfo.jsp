<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/guestInfo.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<title>ユーザ情報</title>
</head>
<body>

<jsp:include page="/include/header.jsp"/>
</head>
<body>
<h2>ユーザー登録情報</h2>
<div class="container">

</div>
<p>ユーザー名:${loginUser.name}</p>
<p>かな:${loginUser.kana}</p>
<p>TEL:${loginUser.tel}</p>
<p>EMail:${loginUser.mail}</p>
<p>Adress:${loginUser.address}</p>
<p><a href="/searchinn/gGuestInfoChangeForm.jsp">変更</a></p>
<p><a href="/searchinn/jsp/guest/mypage.jsp">マイページへ</a></p>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>