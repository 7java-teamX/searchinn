<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOKINN | プラン選択</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserve.css">
</head>
<body>
<header>
	<jsp:include page="header.jsp"/>
</header>

<div class="container">
	<c:forEach var="plan" items="${planList}" varStatus="status">
	<div class="box">
		<span class="planName">
			<c:out value="${plan.planName}" />
		</span>

		<div class="descriptArea">
			<div class="descript">
				部屋タイプ：<c:out value="${plan.roomTypeName}" /><br>

				<small>詳細</small>
				<div class="text">
					<c:out value="${plan.planDetail}" />
				</div>
				<p>
					大人：<c:out value="${plan.adultCapacity}" />人・
					小人：<c:out value="${plan.childCapacity}" />人まで<br>
				</p>
				<p>
					大人：<c:out value="${plan.adultCharge}" />円
					小人：<c:out value="${plan.childCharge}" />円
				</p>
			</div>
			<img src="<c:out value="${plan.planImage}" />" width="300" height="300">
		</div>

		<a href="/searchinn/PlanSelectServlet?action=toReserve&index=${status.index}">空室確認・予約</a>

	</div>
	</c:forEach>
</div>



<footer>
	<jsp:include page="footer.jsp" />
</footer>



</body>
</html>