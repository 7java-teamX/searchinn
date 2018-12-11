<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    	<div id="nav">
			<img src="/searchinn/image/rogo.png" width="300" height="100"
    		style="background-color:skyblue;">
    		<div class="link">
	    			<a href="/searchinn/MainServlet?action=top" class="button">TOP</a>&nbsp;&nbsp;
	    			<a href="/searchinn/MainServlet?action=reserve" class="button">宿泊予約</a>&nbsp;&nbsp;
    		</div>

    		<div class="userInfo">
    			<!-- ログイン中:ログアウトボタン/マイページ表示
	    			ログアウト中: ログイン/会員登録 ボタン-->
    			<c:choose>
					<c:when test="${loginUser.name!=null}">
						<small><c:out value="ログイン中：${loginUser.name}さん" /></small><br>
						<div class="loginArea">
							<a href="/searchinn/MainServlet?action=mypage"  class="button2">マイページ</a><br>
	    					<a href="/searchinn/GuestLoginServlet" class="button2">ログアウト</a>
						</div>
					</c:when>
					<c:when test="${loginUser.name == null}">
						<div class="logoutArea"><br>
							<small style="line-height:2; ">
								会員登録後にログインください</small>

							<a href="/searchinn/MainServlet?action=login" class="button2">ログイン/会員登録</a>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
