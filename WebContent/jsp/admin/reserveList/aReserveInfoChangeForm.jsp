<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約人数変更</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveList.css">
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>予約人数変更画面</h2>
<div class="container">
	<table>
	<tr class="guest-text2">
			<td class="guest-text2">大人1人当たり</td>
			<td id="adultCh"  class="guest-text2"><c:out value="${reserveInfo.childCharge}"/></td>
	</tr>
	<tr>
		<td  class="guest-text2">子供１人当たり</td>
		<td id="childCh"  class="guest-text2"><c:out value="${reserveInfo.adultCharge}"/></td>
	</tr>
	</table>
	<hr>

	<form action="/searchinn/AReserveInfoChangeServlet" method="post">
		<p>
			大人人数 <select name="numOfAdult">
				<option value="1">1</option>
				<option value="2">2</option>
			</select>人 / 子供人数
			<select name="numOfChild">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
		</select>
		</p>
		<!-- 合計金額：<input type="text" name="charge">円<br> -->
		<p>
		<input type="submit" value="変更" id="submit">
		</p>
	</form>
</div>

<jsp:include page="/include/footer.jsp"/>

<script type="text/javascript">
window.onload = function ()	{
	//var adultCh = document.getElementsById("adultCh").value;
	//var childCh = document.getElementsById("childCh").value;
	var adultNum = document.form.numOfAdult.value;
	var childNum = document.form.numOfChild.value;

	console.log(adultCharge);
	console.log(adultNum);
	console.log(childCharge);
	console.log(childNum);
	console.log(adultCharge * adultNum + childCharge * childNum);
}
    //document.getElementsByName("Charge").innerHTML = (childCh * childNum) + (adultCh * adultNum);
</script>
</body>
</html>