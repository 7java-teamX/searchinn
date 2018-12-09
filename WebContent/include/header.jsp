<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    	<div id="nav">
			<img src="/searchinn/image/rogo.png"  width="300" height="100"
    		style="background-color:skyblue;">
    		<div class="link">
	    			<a href="/searchinn/MainServlet?action=top" class="button">TOP</a>&nbsp;	&nbsp;
	    			<a href="/searchinn/MainServlet?action=reserve" class="button">宿泊予約</a>&nbsp;	&nbsp;

	    			<!-- ログイン中: ログアウトボタン　マイページ表示  -->
	    			<c:if test="${loginUser.name!=null}">
	    				<a href="/searchinn/MainServlet?action=mypage"  class="button">マイページ</a>&nbsp;	&nbsp;
	    			</c:if>

	    			<c:choose>
						<c:when test="${loginUser.name!=null}">
						</c:when>
						<c:when test="${loginUser.name == null}">
							<a href="/searchinn/MainServlet?action=login" class="button">ログイン/会員登録</a>&nbsp;	&nbsp;
						</c:when>
					</c:choose>&nbsp;	&nbsp;
    		</div>
    		<div class="userInfo">
    			<c:if test="${loginUser.name!=null}">
	    				<c:out value="ログイン中：${loginUser.name}さん" />
	    				<a href="/searchinn/MainServlet?action=mypage"  class="button">ログアウト</a>&nbsp;	&nbsp;
	    			</c:if>
			</div>
		</div>
