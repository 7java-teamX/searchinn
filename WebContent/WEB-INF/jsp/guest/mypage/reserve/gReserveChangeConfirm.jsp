<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約変更確認</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">

<style>
.container{
	margin: 0 auto;
	width: 1000px;
}
.str{
	border-bottom: solid 2px #D3D3D3;
	display: inline-block;
	margin-bottom:5px;
}

.reserveBox, .planArea, .reserveArea,.text{
	border: solid 2px silver;
	padding:10px 15px;
}
.planArea{
	display:flex;
	justify-content: space-around;
	margin-bottom:10px;
}
.btn{
	text-decoration: none;
	border-bottom: solid 4px #B0E0E6;
	background-color:#AFEEEE;
	padding : 3px 10px;
	display: inline-block;
	border-radius: 5px;
	margin-right:5px;
}
.btn:active{
	 transform: translateY(4px);
	 border: none;
}
.reserveBox{
	background-color : #FFEBCD ;
}
.planArea, .reserveArea,.text{
	background-color : #fff ;
}
.btn:visited {
	color: black;
}
.btnArea{
	text-align:center;
}
</style>
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
</header>
<h1>予約内容変更確認</h1>
以下の内容に予約を変更します。<br>
よろしければ確定ボタンを，修正したい場合は戻るボタンを押してください。<br>
<c:out value="${reserveInfo.planName}"/><br>
予約ID:<c:out value="${reserveInfo.reserveId}"/><br>
メモ:<br><c:out value="${reserveInfo.reserveMemo}"/><br>
宿泊日数：<c:out value="${reserveInfo.numOfNights}"/>日<br>
宿泊期間：<c:out value="${reserveInfo.reserveDate}"/><br>
大人人数：<c:out value="${reserveInfo.numOfAdults}"/>人<br>
子供人数：<c:out value="${reserveInfo.numOfChildren}"/>人<br>
合計料金：<c:out value="${reserveInfo.charge}"/>
<div class="">
こちらの内容で問題ないですか？
<div class="btnArea">
	<a class="btn" href="GReserveInfoChangeServlet?index=done">確定</a>
	<a class="btn" href="GReserveInfoChangeServlet">戻る</a>
</div>

</div>
<footer>
	<jsp:include page="/include/footer.jsp" />
</footer>

</body>
</html>