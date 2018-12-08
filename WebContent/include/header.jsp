<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<div id="nav">
		<ul>
			<li><a href="/searchinn/MainServlet?action=top">TOP</a></li>
			<li><a href="/searchinn/MainServlet?action=login">ログイン/会員登録</a></li>
			<li><a href="/searchinn/MainServlet?action=reserve">宿泊予約</a></li>
			<li><a href="/searchinn/MainServlet?action=mypage">マイページ</a></li>
			<li><a href="/searchinn/MainServlet?action=admin">管理者画面</a></li>
			<li>
				<c:choose>
					<c:when test="${loginUser.name!=null}">
						<b><c:out value="ログイン中：${loginUser.name}さん" /></b>
					</c:when>
				</c:choose>
			</li>
		</ul>
	</div>

