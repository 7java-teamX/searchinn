<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約状況変更</title>
</head>
<body>
<h1>予約状況変更</h1>
<table>
<tr>
	<td>大人料金：\</td><td id="adultCh"><c:out value="${reserveInfo.childCharge}"/></td>
</tr>
<tr>
	<td>子供料金：\</td><td id="childCh"><c:out value="${reserveInfo.adultCharge}"/></td>
</tr>
</table>


<hr>
<form action="/searchinn/AReserveInfoChangeServlet" method="post">
	大人人数 <select name="numOfAdult">
		<option value="1">1</option>
		<option value="2">2</option>
	</select>人 / 子供人数
	<select name="numOfChild">
		<option value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
	</select><br>
	<!-- 合計金額：<input type="text" name="charge">円<br> -->
	<input type="submit" value="変更">
</form>


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