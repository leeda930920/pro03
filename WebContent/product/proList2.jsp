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
		<h2>관광택시 신청 · 예약</h2>
		<img src="${Path1}./img/main/title_right.png" alt="타이틀_왼" style="padding-left: 5px;">
		<br><hr><br>
	  </div>
		<div class="taxi info" style="text-align: center;">
		<img src="${Path1}./img/taxiinfo.png" alt="관광택시 안내">
		</div>
		<div class="taxi info2" style="text-align: center;">
		<img src="${Path1}./img/taxiinfo2.png" alt="관광택시 안내">
		</div>
		<hr>
		<fmt:setLocale value="ko_kr" />
		<article class="tile is-parent" style="text-align: center; max-width: 1400px; margin: 0 auto;">
			<c:forEach var="pro" items="${proList }" varStatus="status">
			<div class="tile is-child box">
				<div class="thumbnail">
					<div class="thumb_box">
						<img src='${path1 }/product/${pro.pic }' alt="${pro.pname }"/>
					</div>
					<div class="caption">
						<a href="${path1 }/ProductDetail.do?pcode=${pro.pcode}">
							<h3><strong>${pro.pname }</strong></h3>
							<p class="comment" style="margin-bottom: 0px;"><strong>관광코스 안내</strong> :<br>${pro.pinfo }</p>
							<p><strong>가격</strong> : <fmt:formatNumber value="${pro.price }" type="currency" /></p>
						</a>
						<hr>
						<div class="btn-group">
							<c:if test="${sid.equals('admin') }">
								<a href="${path1 }/DeleteProduct.do?pcode=${pro.pcode }" class="button is-danger" role="button">해당 상품 삭제</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</article>
		<br><hr><br>
		<button href="${path1 }/sales/addSales.jsp " class="button is-info is-large is-light" style="display: flex; margin: 0 auto;">온라인 신청 및 예약</button>
		<br>
		<c:if test="${empty proList }">
		<div class="container">
			<h3>해당 상품이 존재하지 않습니다.</h3>
		</div>
		</c:if>	
		<div class="btn-group-bottom">
			<c:if test="${sid.equals('admin') }">
			<a href="${path1 }/InsertProduct.do" class="button is-primary" role="buttons" style="display: table; margin: 0 auto;">상품 등록</a>
		</c:if>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>