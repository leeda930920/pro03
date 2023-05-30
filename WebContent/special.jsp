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
<title>특별한 포항</title>
<style>
.subpage {position: relative; padding-bottom: 4em; width: 100%; overflow: hidden;}
.special_pohang { width: 100%; background-size: cover; background-position: center;}

</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="subpage">
	<div class="special_pohang">
	<img src="${Path1}./img/special/sub_1.png" alt="특별한 포항" style="width: 100%;">
	<img src="${Path1}./img/special/sub_2.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_3.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_4.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_5.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_6.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_7.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_8.png" alt="특별한 포항">
	<img src="${Path1}./img/special/sub_9.png" alt="특별한 포항">
	</div>
</div>
<%@ include file="/../footer.jsp" %>
</body>
</html>