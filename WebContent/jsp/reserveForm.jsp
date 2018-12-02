<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<b><c:out value="${calMap.year}年${calMap.month}月の空室状況"/></b>

<div>
	<form action="/searchinn/PlanReserveServlet" method="get">
		<input type="month" name="ym" value="${calMap.ym}">
		<input type="submit" value="決定"/>
	</form>
</div>
<div>
	${calMap.calendar}
</div>
</body>
</html>