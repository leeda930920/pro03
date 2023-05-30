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
<title>제품 등록 하기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>제품 등록</h2>
		<p>${msg }</p>
		<form action="${path1 }/InsertProductPro.do" method="POST" enctype="multipart/form-data">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="pcode">택시코드</label></th>
						<td>
							<input type="text" name="pcode" id="pcode" title="40자 내로 작성" placeholder="40자 내로 작성" class="form-control" required>
						</td>
					</tr>
					<tr>
						<th><label for="pname">택시기사</label></th>
						<td>
							<input type="text" name="pname" id="pname" title="40자 내로 작성" placeholder="40자 내로 작성" class="form-control" required>
						</td>
					</tr>
					<tr>
						<th><label for="psize">운행지역</label></th>
						<td>
							<input type="text" name="psize" id="psize" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required>
						</td>
					</tr>
					<tr>
						<th><label for="pinfo">코스 설명</label></th>
						<td>
							<textarea rows="5" cols="100" name="pinfo" id="pinfo" maxlength="500" title="500자 내로 작성" class="form-control">500자 이내</textarea>
						</td>
					</tr>
					<tr>
						<th><label for="price">가격</label></th>
						<td>
							<input type="number" name="price" id="price" value="1000" min="0" max="5000000" step="100" title="0~5000000" class="form-control">
						</td>
					</tr>
					<tr>
						<th><label for="pic">이미지 첨부</label></th>
						<td>
							이미지 : <p id="picAttac1"></p><input type="file" accept="./img/*" name="pic" id="pic" class="form-control file"><br>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="제품 등록" class="btn btn-danger">
							<a href="${path1 }/AdminProductList.do" class="btn btn-primary">글 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		$(document).ready(function(){
			$("#pinfo").click(function(){
				if($(this).text()=="500자 이내"){
					$(this).text("");
				}
			});
			$(".pic").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
				}
			});
			
				});				
	</script>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>