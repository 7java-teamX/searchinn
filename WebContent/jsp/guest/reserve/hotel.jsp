<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホテル選択</title>
<link rel="stylesheet" type="text/css" href="/searchinn/css/headerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/footerStyle.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserve.css">
</head>
<body>
	<header>
		<jsp:include page="/include/header.jsp"/>
	</header>

	<div class="container">
		<div id="map">
			<img id="mapPhoto" src="/searchinn/photo/japan.png" alt="日本地図" style="width:500px;" id="japan">
			<a href="#kinki" class="btn kinki">近畿</a>
			<a href="#ho" class="btn hokkaido">北海道</a>
			<a href="#kanto" class="btn kanto">関東</a>
			<a href="#tyugoku" class="btn tyugoku">中国</a>
			<a href="#sikoku" class="btn sikoku">四国</a>
			<a href="#kyuusyuu" class="btn kyusyu">九州</a>
		</div>

		<div class ="area">
			<div class="box" id="kinki">
				<div class="areaName">近畿エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=3">琵琶湖</a>
					</div>
				</div>
			</div>

			<div class="box" id="ho">
				<div class="areaName">北海道エリア</div>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=1">コロポックル</a><br>
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=2">ススキノ</a><br>
					</div>
				</div>
			</div>

			<div class="box" id="kanto">
				<div class="areaName">関東エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img  src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">

					</div>
				</div>
			</div>

			<div class="box" id="tyugoku">
				<div class="areaName">中国エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">

					</div>
				</div>
			</div>

			<div class="box" id="sikoku">
				<div class="areaName">四国エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=4">河童庵</a>
					</div>
				</div>
			</div>

			<div class="box" id="kyuusyuu">
				<div class="areaName">九州エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/photo/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=5">キジムナー</a><br>
						<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=6">マリーナ</a><br>
					</div>
				</div>
			</div>
		</div>
	<p id="pageTop"><a href="#"><i class="fa fa-chevron-up "></i></a></p>
	</div>

	<footer>
		<jsp:include page="/include/footer.jsp"/>
	</footer>

<script>
	// Javascriptの記述
	//■page topボタン
	$(function(){
	var topBtn=$('#pageTop');
	topBtn.hide();

	//◇ボタンの表示設定
	$(window).scroll(function(){
		if($(this).scrollTop()>80){
	//---- 画面を80pxスクロールしたら、ボタン表示
			topBtn.fadeIn();
		}else{
	//---- 画面が80pxより上なら、ボタン非表示
			topBtn.fadeOut();
		}
	});

	// ◇ボタンをクリックしたら、スクロールして上に戻る
	topBtn.click(function(){
		$('body,html').animate({
			scrollTop: 0},500);
			return false;
		});
	});
</script>

</body>
</html>