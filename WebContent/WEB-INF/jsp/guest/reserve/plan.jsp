<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOKINN | プラン選択</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserve.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
	<div id="main">
		<h4 class="ao">ご予約の流れ</h4><span class="spanao">→</span>
		<h4 class="ao">エリア/ホテル選択</h4><span class="spanao">→</span>
		<h4 class="siro">プラン選択</h4><span class="spanao">→</span>
		<h4 class="ao">予約情報入力</h4><span class="spanao">→</span>
		<h4 class="ao">会員登録</h4><span class="spanao">→</span>
		<h4 class="ao">入力確認</h4><span class="spanao">→</span>
		<h4 class="ao">予約確定</h4>
	</div>
</header>

<p>ホテル名:${planList.get(0).getHotelName() }</p>
<p>住所:${planList.get(0).getHotelAddress() }</p>
<p>電話番号:${planList.get(0).getHotelTel() }</p>
<p>eMail:${planList.get(0).getHotelmail()}</p>
<p>${planList.get(0).getHotelImage() }</p>
<p>ホテル情報:${planList.get(0).getHotelDetail() }</p>
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
			<img src="/searchinn/image/imagesPlan/<c:out value="${plan.planImage}" />" width="300" height="300">
		</div>
		<div class="btn_area">
			<a href="/searchinn/PlanSelectServlet?action=toReserve&index=${status.index}" class="btn">空室確認・予約</a>
		</div>
	</div>
	</c:forEach>
</div>



	<jsp:include page="/include/footer.jsp" />




</body>
</html>