<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="#">
	<script type="text/javascript" src="m.js"></script>
	<title>売上集計</title>
	<style>
		*{
			color:lime;
			background:black;
		}

		.title{
			margin:10px 20px;
		}

		.subcontainer{
			border-style: solid;
			margin:10px 20px;
			float:left;
		}

		.space{
			margin: 5px;
		}


	</style>
</head>
<body>

<form action="#" method="post">
	<div class="title">
		<h2>売上集計</h2>
		<a href= "../admin/admin.html">管理者画面へ</a>
		<p>
			<input type="month">
			<input type="submit" value="表示">
		</p>
	</div>
	</form>
		<div class ="subcontainer">
			<table border="1">
				<p class="space">▼ホテル</p>
					<tr>
						<th>ホテル</th>
			   			<th>エリア</th>
			   			<th>合計金額</th>
					</tr>
				<c:forEach var="#" items="${#}">
					<tr>
			 			<td><c:out value="${#}"/></td>
			 			<td><c:out value="${#}"/></td>
			 			<td><c:out value="${#}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	<div class ="subcontainer">
		<table border="1">
			<p class="space">▼エリア</p>
				<tr>
		   			<th>エリア</th>
		   			<th>合計金額</th>
				</tr>
			<c:forEach var="#" items="${#}">
				<tr>
		 			<td><c:out value="${#}"/></td>
		 			<td><c:out value="${#}"/></td>
				</tr>
			</c:forEach>
		</table>
		<table border="1">
			<p class="space">▼全体</p>
				<tr>
	   				<th>合計金額</th>
				</tr>
			<c:forEach var="#" items="${#}">
				<tr>
		 			<td><c:out value="${#}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>