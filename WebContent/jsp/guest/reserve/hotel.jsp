<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホテル選択</title>

<link rel="stylesheet" type="text/css" href="/searchinn/css/include.css">
<link rel="stylesheet" type="text/css" href="/searchinn/css/reserve.css">
</head>
<body>
<header>
	<jsp:include page="/include/header.jsp"/>
	<div id="main">
		<h4 class="ao">ご予約の流れ</h4><span class="spanao">→</span>
		<h4 class="siro">エリア/ホテル選択</h4><span class="spanao">→</span>
		<h4 class="ao">プラン選択</h4><span class="spanao">→</span>
		<h4 class="ao">予約情報入力</h4><span class="spanao">→</span>
		<h4 class="ao">会員登録</h4><span class="spanao">→</span>
		<h4 class="ao">入力確認</h4><span class="spanao">→</span>
		<h4 class="ao">予約確定</h4>
	</div>
</header>



	<div class="container">
		<div id="map">
			<img id="mapPhoto" src="/searchinn/image/imagesArea/japan.png" alt="日本地図" style="width:500px;" id="japan">
			<a href="#kinki" class="btn kinki">近畿</a>
			<a href="#ho" class="btn hokkaido">北海道</a>
			<a href="#kanto" class="btn kanto">関東</a>
			<a href="#tyugoku" class="btn tyugoku">中国</a>
			<a href="#sikoku" class="btn sikoku">四国</a>
			<a href="#kyuusyuu" class="btn kyusyu">九州</a>
		</div>

		<div class ="area">
			<div class="box" id="ho">
				<div class="areaName">&nbsp;&nbsp;北海道エリア</div>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/image/imagesArea/niseko.jpg" width="280" align="top"></a>
					<div class="hotel">
						<div class="textarea">
							北海道といえば、国内外から高い人気を集める日本屈指の観光地！<br>
							札幌や函館、小樽など夜景のきれいな大都市や、富良野のラベンダーなど季節の花々、
							知床・大雪山といった雄大な大自然、水の美しい支笏湖や摩周湖など見どころは盛りだくさん。
						</div>
						<div class="hotelarea">
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=1"  class="btn2">コロポックル</a>
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=2" class="btn2">ススキノ</a><br>
						</div>
					</div>
				</div>
			</div>

			<div class="box" id="kanto">
				<div class="areaName">&nbsp;&nbsp;関東エリア</div>
					<div class="descriptArea">
						<a href="#"><img  src="/searchinn/image/imagesArea/kyoto.jpeg" width="280" align="top"></a>
						<div class="hotel">
							<div class="textarea">
								関東地方は有名なテーマパークや定番の観光地だけでなく、温泉地など癒しスポットも数多く点在する関東エリア。
								他にも科学センターやミュージアムなど、大人も子どもも夢中になる施設が目白押し！船で江戸の風情を感じたり、
								工場夜景を楽しんだりと、いろんな場所でクルージングも運行されているので要チェック。
							</div>
							<div class="hotelarea">
								<!-- ホテルのリスト -->
							</div>
					</div>
				</div>
			</div>

			<div class="box" id="kinki">
				<div class="areaName">&nbsp;&nbsp;近畿エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/image/imagesArea/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<div class="textarea">
								近畿地方は公園や寺社など、自然や文化に触れるおすすめスポットが豊富。<br>
								世界にも注目されるテーマパークや、古き良き日本の姿を残す街並みなど、
								関西を巡るだけでタイムトリップしたような気分に。
								家族と、友達と、一人旅とシチュエーションに合わせて楽しみ方はさまざま。
								また、日本最大の湖で楽しめるアクティビティもおすすめ！
						</div>
						<div class="hotelarea">
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=3"   class="btn2">琵琶湖</a>
						</div>
					</div>
				</div>
			</div>

			<div class="box" id="tyugoku">
				<div class="areaName">&nbsp;&nbsp;中国エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/image/imagesArea/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<div class="textarea">
								中国地方は大自然や歴史的なスポットが数多くある日本海と瀬戸内海に面した地域を有するエリアです。
								<br>主な見どころとしては、鳥取県の「鳥取砂丘」、島根県の「出雲大社」、
								岡山県の「岡山城」や「後楽園」、広島県の「厳島神社」、山口県の「錦帯橋」などがあります。
						</div>
						<div class="hotelarea">
							<!-- ホテルのリスト -->
						</div>
					</div>
				</div>
			</div>

			<div class="box" id="sikoku">
				<div class="areaName">&nbsp;&nbsp;四国エリア</div><br>
				<div class="descriptArea">
					<a href="#"><img src="/searchinn/image/imagesArea/kyoto.jpeg" width="280" align="top"></a>
					<div class="hotel">
						<div class="textarea">
							四国地方は四季折々でさまざまな魅力があります。<br>
							＜春＞
							一番気候が穏やかで桜も満開になるため、観光名所と桜があります<br>
							＜夏＞
							気温がとても高くなるため、海水浴などのマリンアクティビティがとてもおすすめ！
							高原では夏のキャンプと、夏らしいアクティビティが満載です。<br>
							＜秋＞
							山の幸、海の幸共に食べごろを迎えます！<br>
							＜冬＞
							観光名所と雪景色が一緒になった絶景が見られます！

						</div>
						<div class="hotelarea">
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=4"   class="btn2">河童庵</a>
						</div>
					</div>
				</div>
			</div>

			<div class="box" id="kyuusyuu">
				<div class="areaName">&nbsp;&nbsp;九州・沖縄エリア</div><br>
				<div class="descriptArea">
					<a href="#" class="btn" >
						<img src="/searchinn/image/imagesArea/okinawa.jpg" width="280" align="top">
					</a>
					<div class="hotel">
						<div class="textarea">
								海はもちろん自然豊かな山々など景勝地の特色を生かしたレジャースポットが豊富。<br>
								各県にはさまざまな特徴を持つ温泉地が点在しており、
								四季折々の景色と温泉を目当てに、一年を通して国内外の観光客で賑わっている。<br>
								沖縄は首里城跡や中城城跡、今帰仁城跡など世界遺産に登録された琉球王国関連遺産群は
								この地に旅行で訪れたのなら必ず足を運んで頂きたいスポット。<br>
								また、本州では見られないような美しい大自然も魅力的
						</div>
						<div class="hotelarea">
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=5"   class="btn2">キジムナー</a>
							<a href="/searchinn/PlanSelectServlet?action=toPlan&hotelId=6"   class="btn2">マリーナ</a>
						</div>

					</div>
				</div>
			</div>
			<p id="pageTop"><a href="#"><i class="fa fa-chevron-up "></i></a></p>
		</div>

	</div>


	<jsp:include page="/include/footer.jsp"/>


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