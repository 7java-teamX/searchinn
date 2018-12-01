<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOKINN | プラン選択</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:forEach var="plan" items="${planList}" varStatus="status">
	<div>
		<div>
			<c:out value="${plan.planName}" />
			<c:out value="${plan.planDetail}" />
			部屋タイプ：<c:out value="${plan.roomTypeName}" /><br>
			大人：<c:out value="${plan.adultCapacity}" />・
			小人：<c:out value="${plan.childCapacity}" />まで<br>

			大人：<c:out value="${plan.adultCharge}" />円
			小人：<c:out value="${plan.childCharge}" />円
		</div>
		<div>
			<c:out value="${plan.planImage}" />
		</div>
		<div>
			<a href="/searchinn/PlanSelectServlet?index=${status.index}">空室確認・予約</a>
		</div>
	</div>
</c:forEach>

<jsp:include page="footer.jsp" />


</body>
</html>