<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上集計画面</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/sales.css">
</head>

<body>
<jsp:include page="/include/header.jsp"/>
<h2>売り上げ集計</h2>
<div class="container">
	<p>
		<a href="/searchinn/AdminMenuServlet" class="btn">管理者TOP</a>
	</p>
	<form action="/searchinn/SalesServlet" method="get">
	<p>
		<input type="month" name="term">
		<input type="submit" value="決定" id="submit">
	</p>
	</form>
	<hr>
	<p>
			<c:out value="${term}の売上" />
	</p>

	<div class="sales-box">
	<!-- ホテルの売上 -->
	<div class="box">
		<div class="hotelSales">
			<h4>ホテル</h4>
			<table>
				<tr>
					<th>エリアID</th>
					<th>エリア名</th>
					<th>ホテルID</th>
					<th>ホテル名</th>
					<th>売上</th>
				</tr>
				<c:forEach var="salesInfo" items="${hotelSales}" >
					<tr>
						<td><c:out value="${salesInfo.areaId}" /></td>
						<td><c:out value="${salesInfo.areaName}" /></td>
						<td><c:out value="${salesInfo.hotelId}" /></td>
						<td><c:out value="${salesInfo.hotelName}" /></td>
						<td><c:out value="${salesInfo.sales}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</div> <!-- box -->

		<div class="box">
			<div class="areaSales">
				<h4>エリア</h4>
				<table>
					<tr>
						<th>エリアID</th>
						<th>エリア名</th>
						<th>売上</th>
					</tr>
					<c:forEach var="salesInfo" items="${areaSales}">
						<tr>
							<td><c:out value="${salesInfo.areaId}" /></td>
							<td><c:out value="${salesInfo.areaName}" /></td>
							<td><c:out value="${salesInfo.sales}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div  class="totalSales">
				<h4>全体</h4>
				<table>
					<tr>
						<th>売上</th>
						<td>
							<c:forEach var="salesInfo" items="${totalSales}">
								<c:out value="${salesInfo.sales}" />
							</c:forEach>
						</td>
					</tr>
				</table>
			</div>

		</div> <!-- box -->
	</div>  <!--sales-box  -->
</div>  <!-- continer -->

<jsp:include page="/include/footer.jsp"/>
</body>
</html>