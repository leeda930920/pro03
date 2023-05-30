<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" /> 
<div id="nav-group">
	<div class="container"> 
		<nav class="navbar" role="navigation" aria-label="main navigation" id="nav">
		  <div class="navbar-brand">
		    <a class="navbar-item" id="logo2" href="<%=request.getContextPath() %>/">
		    	<img src="${path2 }/resource/logo.png" alt="제주 문화관광">
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
				      	관광
				    </a>
				    <div class="navbar-dropdown cate" id="cate01">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=B" class="navbar-link cate">
				      	체험
				    </a> 
		   		    <div class="navbar-dropdown cate" id="cate02">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=C" class="navbar-link cate">
				      	행사
				    </a>
		   		    <div class="navbar-dropdown cate" id="cate03">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=D" class="navbar-link cate">
				      	축제
				    </a>
		    		<div class="navbar-dropdown cate" id="cate04">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=E" class="navbar-link cate">
				      	숙박
				    </a>
		    		<div class="navbar-dropdown cate" id="cate05">
				    
				    </div>
				</div>	
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=F" class="navbar-link cate">
				      	음식
				    </a>
		    		<div class="navbar-dropdown cate" id="cate06">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable">
			    	<a href="${path2 }/GetTourCateListCtrl.do?cate=G" class="navbar-link cate">
				      	쇼핑
				    </a>
		    		<div class="navbar-dropdown cate" id="cate07">
				    
				    </div>
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
			    	<a class="navbar-link">
				      	함께하는 제주
				    </a>
					<div class="navbar-dropdown single">
					     <a class="navbar-item" href="${path2 }/GetNoticeListCtrl.do">
					       	공지사항
					     </a>
					     <a class="navbar-item" href="${path2 }/GetQnaListCtrl.do">
					       	묻고 답하기
					     </a>
					     <a class="navbar-item" href="${path2 }/GetImpressListCtrl.do">
					       	이용후기
					     </a>
					     <a class="navbar-item" href="${path2 }/GetDatabankListCtrl.do">
					       	자료실
					     </a>
					     <a class="navbar-item" href="${path2 }/impress/online.jsp">
					       	온라인 상담
					     </a>
				    </div> 
				</div>
				<div class="navbar-item has-dropdown is-hoverable single">
				    <a class="navbar-link">
				      	제주에 대하여
				    </a>
				
				    <div class="navbar-dropdown single">
				      <a class="navbar-item">
				                  제주소개
				      </a>
				      <a class="navbar-item">
				        	제주 CI/BI
				      </a>
				      <a class="navbar-item">
				        	관광홍보대사
				      </a>
				      <hr class="navbar-divider">
				      <a class="navbar-item">
				        	리플릿
				      </a>
				    </div>
			  </div>
			</div>
			
			<div class="navbar-end" id="tnb">
			  <div class="navbar-item">
			  	<a href="https://www.instagram.com/visitjeju.kr" target="_blank" title="새창으로 이동" style="margin:6px;">
			  		<img src="${path2 }/resource/gnb_instagram.png" alt="instagram">
			  	</a>
			  	<a href="https://www.facebook.com/visitjeju.kr" target="_blank" title="새창으로 이동" style="margin:6px;">
			  		<img src="${path2 }/resource/gnb_facebook.png" alt="facebook">
			  	</a>
			  	<a href="http://blog.naver.com/jtowelcome" target="_blank" title="새창으로 이동" style="margin:6px;">
			  		<img src="${path2 }/resource/gnb_blog.png" alt="Blog">
			  	</a>
			  	<a href="https://www.youtube.com/c/visitjeju" target="_blank" title="새창으로 이동" style="margin:6px;">
			  		<img src="${path2 }/resource/gnb_youtube.png" alt="유튜브">
			  	</a>	
			  	<c:if test="${empty sid }">
				 <div class="buttons" style="margin-left:20px;">
				   <a href="${path2 }/member/agree.jsp" class="button is-primary">
				     <strong>Sign up</strong>
				   </a>
				   <a href="${path2 }/member/login.jsp" class="button is-light">
				     Log in
				   </a>
				 </div>
				</c:if>
				<c:if test="${not empty sid }">
				 <div class="buttons" style="margin-left:20px;">
				   <a href="${path2 }/MemberInfoCtrl.do" class="button is-primary">
				     <strong>Member Info</strong>
				   </a>
				   <a href="${path2 }/MemberLogoutCtrl.do" class="button is-light">
				     LogOut
				   </a>
					<c:if test='${sid.equals("admin")}'>
					   <a href="${path2 }/AdminCtrl.do" class="button is-danger">
					     <strong>Admin</strong>
					   </a>
					 </c:if>
				 </div>
				</c:if>
		  </div>
		</div>
		  </div>
		</nav>
	<script>
	$(document).ready(function(){
		$.ajax({
			url:"${path2 }/MemuLoad.do",
			type:"POST",
			enctype:"UTF-8",
			datatype:"json",
			processData:false,
			contentType:false, 
			cache:false,
			success:function(data){
				$(".navbar-dropdown.cate").empty();
				var trans = $.parseJSON(data);
				console.log(trans);
				$.each(trans, function(key, value){
					if(key=="data"){
						for(var i=0;i<value.length;i++){
							if(value[i].cate=="A"){
								$("#cate01").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="B"){
								$("#cate02").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="C"){
								$("#cate03").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="D"){
								$("#cate04").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="E"){
								$("#cate05").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="F"){
								$("#cate06").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							} else if(value[i].cate=="G"){
								$("#cate07").append("<a href='${path2 }/GetTourDetailCtrl.do?no="+value[i].no+"'>"+value[i].place+"</a>");
							}
						}
					}
				});
				
			}
		});
	});
	</script>
	</div>
</div>