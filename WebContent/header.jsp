<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<div id="nav-group">
	<div class="container" style="max-width: 1480px;"> 
		<nav class="navbar" role="navigation" aria-label="main navigation" id="nav">
		  <div class="navbar-brand">
		    <a class="navbar-item" id="logo2" href="<%=request.getContextPath() %>/">
		    	<img src="${path2 }/img/header_logo.png" alt="포항 문화관광" style="width:300px; height:60px;" >
		    	<a href="${path2 }/Index.do" class="메인 홈으로 이동"></a>
		    </a>
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		  <div id="navbarBasicExample" class="navbar-menu">
		    <div class="navbar-start" id="gnb">
		    	<!-- ajax로 메뉴 로딩하여 추가하기 -->
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=A" class="navbar-link" >
				      	 포항은 지금
				    </a>
				    <div class="navbar-dropdown cate" id="cate01">
				    <a href="${path2 }/special.jsp " class="navbar-link"  >특별한 포항</a>
					<a href="${path2 }/FestivalList.do " class="navbar-link"  >대표축제</a>
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=B" class="navbar-link cate">
				      	포항 놀거리
				    </a> 
		   		    <div class="navbar-dropdown cate" id="cate02">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=C" class="navbar-link cate">
				      	포항 즐길거리
				    </a>
		   		    <div class="navbar-dropdown cate" id="cate03">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/NoticeList.do" class="navbar-link cate">
				      	커뮤니티
				    </a>
		    		<div class="navbar-dropdown cate" id="cate04">
		    		<a href="${path2 }/NoticeList.do " class="navbar-link"  >공지사항</a>
				    <a href="${path2 }/QnaList.do" " class="navbar-link"  >Q&A</a>
				    <a href="${path2 }/ProductList.do " class="navbar-link"  >관광택시</a>
		    		</div>
		    	</div>
				<div class="navbar-item has-dropdown is-hoverable single">
				<c:if test='${sid.equals("admin")}'>
			    	<a class="navbar-link" style="color:#E6E6E6;">
				      	관리자 페이지
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/MemberList.do">
					     	회원관리
					     </a>
					     <a class="navbar-item" href="${path2 }/admin/noticeList.do">
					       	글 관리
					     </a>
				    </div>
				 </c:if> 
				</div>
			</div>
		</div>
	<div class="navbar-end"id="tnb">
			  <div class="navbar-item">
		 <a href="https://www.facebook.com/checkpoint/828281030927956/?next=https%3A%2F%2Fwww.facebook.com%2Finpohang" target="_blank" title="새창으로 이동" style="margin:6px;">
         <img src="${path2 }/img/sns_facebook.png" alt="facebook"></a>
         <a href="https://www.instagram.com/pohang_official/" target="_blank" title="새창으로 이동" style="margin:6px;">
		 <img src="${path2 }/img/sns_instar.png" alt="instagram"></a>
         <a href="https://blog.naver.com/inpohang" target="_blank" title="새창으로 이동" style="margin:6px;">
         <img src="${path2 }/img/sns_blog.png" alt="blog"></a>
         <a href="https://www.youtube.com/user/pohangtv" target="_blank" title="새창으로 이동" style="margin:6px;">
	     <img src="${path2 }/img/sns_youtube.png" alt="youtube">
	     </a>
			  	<c:if test="${empty sid }">
				 <div class="buttons" style="margin-left:20px;">
				   <a href="${path2 }/UserLogin.do" class="button is-primary">
				     로그인
				   </a>
				   <a href="${path2 }/UserTerms.do" class="button is-light">
				     회원가입
				   </a>
				 </div>
				</c:if>
				<c:if test="${not empty sid }">
				 <div class="buttons" style="margin-left:20px;">
				   <a href="${path2 }/MyPage.do" class="button is-primary">
				     <strong>마이페이지</strong>
				   </a>
				   <a href="${path2 }/UserLogout.do" class="button is-light">
				     로그아웃
				   </a>
				 </div>
				</c:if>
			 </div>
			</div>
		</nav>
	</div>
</div>