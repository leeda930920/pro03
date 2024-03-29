<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>대표축제</title>
<style>
.container-fluid { width:100%; }
.thumbnail { height:480px; }
.comment { width:auto; height:60px; overflow: hidden;  text-overflow: ellipsis; 
 display: -webkit-box;  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical; }
.thumb_box { width:250px; margin:24px auto; margin-bottom:10px; height:auto; overflow:hidden;
padding-top:5px; padding-bottom:5px; 
border:1px solid #e0e0f0; text-align:center; }
.thumb_box::after { content:""; display:block; clear:both; }
.thumb_box img { width:auto; height:193px; }  
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; min-height:500px;">
	<div class="container-fluid">
	  <div class="sub_title1" style="text-align: center; display: flex; justify-content: center">
		<img src="${Path1}./img/main/title_left.png" alt="타이틀_왼" style="padding-right: 5px;">
		<h2>대표축제</h2>
		<img src="${Path1}./img/main/title_right.png" alt="타이틀_왼" style="padding-left: 5px;">
		<br><hr><br>
	  </div>
		<fmt:setLocale value="ko_kr" />
		<article class="row">
			<c:forEach var="fes" items="${fesList }" varStatus="status">
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="thumbnail">
					<div class="thumb_box">
						<img src='${path1}/WEB-INF/festival/${fes.file1 }' alt="${fes.file1 }"/>
					</div>
					<div class="caption">
							<h3><strong>${fes.title }</strong></h3>
							<p class="comment"><strong>축제 소개</strong> :<br>${fes.content }</p>
							<p><strong>등록일</strong> : 
							<fmt:parseDate value="${fes.resdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /></p>
					</div>
				  </div>
			    </div>
			  </c:forEach>
			</article>
		  </div>
	</div>
	<div class="btn-group">
	<c:if test="${sid.equals('admin') }">
	<a href="${path1 }/InsertFestival.do" class="btn btn-primary">글 등록</a>
	</c:if>
</div>
<%@ include file="/../footer.jsp" %>
</body>
</html>