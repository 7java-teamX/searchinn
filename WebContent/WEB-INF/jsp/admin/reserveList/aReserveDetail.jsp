<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約詳細</title>

<link rel="stylesheet" type="text/css" href="/searchinn/css/common.css" >
<link rel="stylesheet" type="text/css" href="/searchinn/css/admin.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserveList.css">
<title>予約キャンセル確定画面</title>
</head>

<body>
<jsp:include page="/include/header.jsp"/>

<h2>予約詳細画面</h2>
<div class="container">

	<div class="contents-box">
		<div class="title">sssss
			<c:out value="${reserveInfo.planName}"/><!-- プラン名前 -->&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${reserveInfo.hotelName}"/><br><!-- ホテル名前 -->
		</div>
		<div class="info">
			<div class="text-box"  >
				<div class="text" style="height:160px;">

					<c:out value="${reserveInfo.planDetail}"/><br><!-- プラン詳細 -->
				</div>
				<div class="text">
					大人1人当たり \<c:out value="${reserveInfo.adultCharge}"/><!--大人料金 --><br>
					子供1人当たり \<c:out value="${reserveInfo.childCharge}"/><!--子供料金 -->
				</div>
			</div>
			<div class="photo">
				<img src="/searchinn/image/imagesPlan/<c:out value="${reserveInfo.planImage}"/>" width="370" height="240"><br><!-- プラン画像-->
			</div>

		</div>
	</div>

	<div class="contents-box">
		<div class="title">予約情報</div>
		<div class="info">
				<div class="text-box" style="border:solid 1px white;">
					<table class="guest-text">
						<tr>
							<th class="guest-text">予約ID</th>
							<td class="guest-text"><c:out value="${reserveInfo.reserveId}"/>
						</tr>
						<tr>
							<th class="guest-text">日程</th>
							<td class="guest-text"><c:out value="${reserveInfo.reserveDate}"/></td>
						</tr>
						<tr>
							<th class="guest-text">大人</th>
							<td class="guest-text"><c:out value="${reserveInfo.numOfAdults}"/>人</td>
						</tr>
						<tr>
							<th class="guest-text">子供</th>
							<td class="guest-text"><c:out value="${reserveInfo.numOfChildren}"/>人</td>
						</tr>
						<tr>
							<th class="guest-text">合計料金</th>
							<td class="guest-text">\<c:out value="${reserveInfo.charge}"/></td>
						</tr>
						<tr>
							<th class="guest-text">メモ</th>
							<td class="guest-text"><c:out value="${reserveInfo.reserveMemo}"/></td>
						</tr>
					</table>
				</div>

				<div class="text-box"  style="border:solid 1px white;">
					<table class="guest-text">
						<tr>
							<th class="guest-text">顧客ID</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestId}"/></td>
						</tr>
						<tr>
							<th class="guest-text">顧客名</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestName}"/></td>
						</tr>
						<tr>
							<th class="guest-text">顧客カナ</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestKana}"/></td>
						</tr>
						<tr>
							<th class="guest-text">生年月日</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestBirthday}"/></td>
						</tr>
						<tr>
							<th class="guest-text">住所</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestAddress}"/></td>
						</tr>
						<tr>
							<th class="guest-text">電話番号</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestTel}"/></td>
						</tr>
						<tr>
							<th class="guest-text">メールアドレス</th>
							<td class="guest-text"><c:out value="${reserveInfo.guestMail}"/></td>
						</tr>
					</table>
				</div>

		</div>
	</div>
	<p style="text-align:center;margin-bottom:10px;">
		<a class="btn" href="AReserveInfoChangeServlet">予約変更</a>
		&nbsp;&nbsp;
		<a class="btn" onclick="doConfirm()">削除</a>
	</p>

</div>

<jsp:include page="/include/footer.jsp"/>


<script>
function doConfirm(){
  if(window.confirm("予約のキャンセル確認になります\nよろしければ<はい>を押してください")){
    location.href = "/searchinn/AReserveInfoDeleteServlet";
  }
}
</script>

</body>
</html>