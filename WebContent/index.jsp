<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.net.InetAddress" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${request.getContextPath() }" /> 
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="${path1 }/common.jsp" />
</head>
<body>
  	<jsp:include page="${path1 }/header.jsp" />
	<div class="content">
            <figure class="vs">
                <div class="img_box">
                    <img src="${path1 }./img/main/main_1.jpg" alt="퐝퐝여행" style="position: relative; padding: 0px; background-position: 50%; width: 100%; height: 880px;">
                </div>
            </figure>
    </div>
    
		<section class="page" id="page1" style="width:1500px; height:auto; margin: 0 auto;">
	<h1 class="title" style="margin-left: 2%; color: #253b5c;">BEST 퐝퐝</h1><br>
	<div class="page_wrap">
	<div class="tile is-ancestor">
	 <div class="tile is-parent">
        <article class="tile is-child box" style="height: 465px;">
          <p class="title" style="color: #fa8604;">대표축제</p>
          <figure class="image is-4by3">
            <img src="${path1 }./img/main/festival1.jpg" alt="대표축제" class="festival"><br>
          </figure>
          <a href="" class="item_more">CLICK ↗</a>
        </article>
 	  </div>
  	  <div class="tile is-parent">
        <article class="tile is-child box" style="height: 465px;">
          <p class="title" style="color: #fa4a67;">음식점(맛집)</p>
          <figure class="image is-4by3">
            <img src="${path1 }./img/main/food2.jpg" alt="음식점" class="foodspot"><br>
          </figure>
          <a href="" class="item_more">CLICK ↗</a>
        </article>
      </div>
 	  <div class="tile is-parent">
        <article class="tile is-child box" style="height: 465px;">
          <p class="title" style="color: #288ed7;">숙박</p>
          <figure class="image is-4by3">
            <img src="${path1 }./img/main/hotel3.jpg" alt="숙박" class="hotel"><br>
          </figure>
          <a href="" class="item_more">CLICK ↗</a>
        </article>
  	  </div>
     </div>
    </div>
	</section>
	
	<section class="page" id="page2" style="width:1500px; padding-top: 30px; height:auto; margin: 0 auto;">
	<h1 class="title" style="margin-left: 2%; color: #253b5c;">관광택시</h1>
	<div class="page_wrap">
	<div class="content is-small" style="text-align: center;">
	<div class="course" style="text-align: center; width: 100%; display: inline-block;">
    <h1>운행 코스 안내</h1>
    <div class="tag1">
    <span class="tag is-success">A코스</span>
    <li class="tag">연오랑세오녀테마공원 → 호미반도 해안둘레길 → 호미곶 해맞이광장 → 구룡포 일본인가옥거리 → 장기읍성/장기유배체험문화촌</li>
    </div><div style= "clear: both;"></div>
    <div class="tag2" style="margin-right: 13px; padding-top: 3px;">
    <span class="tag is-success">B코스</span>
    <li class="tag">포항운하&크루즈 → 죽도시장 → 영일대해수욕장 → 스페이스워크&스카이워크 → 이가리 닻 전망대 → 보경사&내연산 12폭포</li>
    </div>
    <P style="padding-top: 3px; color: #2E9AFE;">☑ 자유코스: 손님이 원하는 장소 어디든!! 포항 토박이 베테랑 기사님의 찐 추천코스까지!!</P>
  	<div class="card">
  			<div class="card-image">
    			<figure class="image is-128X128" style="float: left; width: 45%;">
      				<img src="${path1 }./img/main/taxitour_1.jpg" alt="관광택시">
    			</figure>
  			</div>
  			<div class="card-image">
    			<figure class="image is-128X128" style="float: right; width: 45%;">
      			<img src="${path1 }./img/main/taxitour_2.png" alt="관광택시예약배너">
      			<a href="${path2 }/ProductList.do" class="button is-info is-outlined"> ☞ 관광택시 온라인 신청 · 예약 ☞   </a>
    			</figure>
  			</div>
  	</div>
  	</div>
  	</div><div style="clear:both:"></div>
  	</div>
	</section>
	
	<section class="page" id="page3" style="width:1500px; padding-top: 60px; height:auto; margin: 0 auto;">
	<h1 class="title" style="margin-left: 2%; color: #253b5c;">SNS</h1>
	<div class="page_wrap">
	<div class="tile is-ancestor">
  <div class="tile is-parent">
        <article class="tile is-child box">
        <a href="https://www.instagram.com/p/CsnqP6HvNrZ/?utm_source=ig_web_copy_link&igshid=MmJiY2I4NDBkZg==">
          <p class="title">∥ 2023 포항국제불빛축제 개최 안내…</p>
          <p class="subtitle" style="color: blue;">#포항 #포항국제불빛축제 #포항관광 #축제 #포항볼거리</p>
          <figure class="image is-square">
            <img src="${path1 }./img/main/sns_1.png" alt="sns1">
          </figure>
        </article>
  </div>
  <div class="tile is-parent">
        <article class="tile is-child box">
        <a href="https://www.instagram.com/p/CrNf20JyXua/?utm_source=ig_web_copy_link&igshid=MmJiY2I4NDBkZg==">
          <p class="title">∥ 공식 랜드마크:스페이스 워크…</p>
          <p class="subtitle" style="color: blue;">#포항여행 #포항여행코스 #포항여행추천</p>
          <figure class="image is-square">
            <img src="${path1 }./img/main/sns_2.png" alt="sns2">
          </figure>
        </article>
  </div>
  <div class="tile is-parent">
        <article class="tile is-child box">
        <a href="https://www.instagram.com/p/CsabI7pSB9Q/?utm_source=ig_web_copy_link&igshid=MmJiY2I4NDBkZg==">
          <p class="title">∥ 영일민속박물관으로…</p>
          <p class="subtitle" style="color: blue;">#포항흥해 #흥해 #포항박물관 #민속박물관</p>
          <figure class="image is-square">
            <img src="${path1 }./img/main/sns_3.png" alt="sns3">
          </figure>
        </article>
  </div>
</div>
	
	<div></div>
	
	</div>
	</section>
	
    <section class="page" id="page4" style="width:1500px; padding-top: 30px; height:auto; margin: 0 auto;">
    <h1 class="title"style="margin-left: 2%; color: #e03e85;">공지사항</h1>
    <div class="page_wrap">
      <a href="${path1 }/NoticeList.do" class="navbar-link cate"></a>
    <div class="content">
  <table>
    <thead>
				<tr><th>연번</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
			</thead>
			<tbody>
				<c:forEach var="noti" items="${notiList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>

						<span>${noti.title }</span>


						<a href="${path1 }/GetNotice.do?idx=${noti.idx }">${noti.title }</a>

						
					</td>
					<td>${noti.name }</td>
					<td>
						<fmt:parseDate value="${noti.resdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				</c:forEach>
				<c:if test="${empty notiList }">
				<tr>
					<td colspan="4">해당 공지사항이 존재하지 않습니다.</td>
				</tr>
				</c:if>	
    </tbody>
  </table>
  </div>
                </div>
            </section>	
  	
	<jsp:include page="${path1 }/footer.jsp" />
</body>
</html>