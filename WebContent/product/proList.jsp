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
<title>상품 목록</title>
<style>
.container-fluid { width:1280px; text-align: center; }
.thumbnail { width:200px; height:480px; }
.comment { width:auto; height:80px; overflow: hidden;  text-overflow: ellipsis; 
 display: -webkit-box;  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical; }
.thumb_box { width:200px; margin-bottom:10px; height:auto; overflow:hidden;
padding-top:5px; padding-bottom:5px; 
border:1px solid #e0e0f0; text-align:center; }
.tile is-parent {width: 1200px;}
.thumb_box::after { content:""; display:block; clear:both; }
.thumb_box img { width:200px; height:120px; text-align: center; }  
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid" style="padding-left:300px; width:1280px; text-align: center;" >
		<div class="title" style="padding-left:200px;"><h3>관광택시 예약 </h3> </div>
		<div class="taxi info" style="width:1200px;">
		<img src="${path1 }/img/taxiinfo.png" alt="관광택시 안내">
		</div>
		<hr>
		<fmt:setLocale value="ko_kr" />
		<article class="tile is-parent" style="width: 1200px;">
			<c:forEach var="pro" items="${proList }" varStatus="status">
			<div class="tile is-child box">
				<div class="thumbnail">
					<div class="thumb_box">
						<img src='${path1 }/product/${pro.pic }' alt="${pro.pname }"/>
					</div>
					<div class="caption">
						<a href="${path1 }/ProductDetail.do?pcode=${pro.pcode}">
							<h3><strong>${pro.pname }</strong></h3>
							<p class="comment"><strong>관광코스 안내</strong> :<br>${pro.pinfo }</p>
							<p><strong>가격</strong> : <fmt:formatNumber value="${pro.price }" type="currency" /></p>
						</a>
						<hr>
						<div class="btn-group">
							<c:if test="${sid.equals('admin') }">
								<a href="${path1 }/DeleteProduct.do?pcode=${pro.pcode }" class="btn btn-warning" role="button">상품 삭제</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			
			<button class="button is-large is-fullwidth">관광택시 예약하기</button>
		</article>
		<c:if test="${empty proList }">
		<div class="container">
			<h3>해당 상품이 존재하지 않습니다.</h3>
		</div>
		</c:if>	
		<c:if test="${sid.equals('admin') }">
		<div class="btn-group">
			<a href="${path1 }/InsertProduct.do" class="btn btn-danger">상품 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>