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
<title>공지사항 글 상세보기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>글 상세보기</h2>
		<table class="table">
			<tbody>
			<div class="thumb_box">
						<img src='${path1}/festival/${fes.file1 }' alt="${fes.file1 }"/>
			</div>
				<tr>
					<th>글 번호</th>
					<td>${fes.idx }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${fes.title }</td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td>${fes.content }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${fes.name }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<fmt:parseDate value="${fes.resdate }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
					</td>
				</tr>
				<tr>
					<th>읽은 횟수</th>
					<td>${fes.readcnt }</td>
				</tr>
			</tbody>
		</table>
		<div class="btn-group">
			<a href="${path1 }/FestivalList.do" class="btn btn-primary">글 목록</a>
			<c:if test="${fes.author.equals(sid) || sid.equals('admin') }">
			<a href="${path1 }/UpdateFestival.do?idx=${fes.idx }" class="btn btn-primary">글 변경</a>
			<a href="${path1 }/DelFestival.do?idx=${fes.idx }" class="btn btn-primary">글 삭제</a>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>