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
<form>
	<input type="text" name="hotelName" value="<c:out value="${reserveInfo.hotelName}" />"><br>
	<select name="numOfAdult">
		<option value="1">1</option>
		<option value="2">2</option>
	</select>人 / 子供人数
	<select name="numOfChild">
		<option value="1">1</option>
		<option value="2">2</option>
	</select><br>
	<input type="number" name="hotelName" value="<c:out value="${reserveInfo.hotelName}"/>">

	<input type="submit" value="変更">
</form>
</body>
</html>