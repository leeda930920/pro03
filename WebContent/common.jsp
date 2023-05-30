<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path0" value="<%=request.getContextPath() %>" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<meta name="keywords" content="포항관광,포항여행,포항정보,포항맛집,포항 가볼만한 곳,퐝퐝여행">
<meta name="description" content="포항관광을 단디 즐기는방법!’ 해양문화관광도시 포항을 소개합니다!">
<title>포항 문화관광</title>
<link rel="icon" href="${path0 }/img/favicon.png">
<script src="${path0 }/img/jquery-1.10.1.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

      






<style>
body, html { font-family: 'Noto Sans KR', sans-serif; }
ul { list-style:none; }
img { border: none; }
.table { min-width:960px; }
#logo2 { display:block; max-height:90px; min-height:60px; }
#logo2 img { display:block; max-height:70px; min-height:60px; }
#nav-group { border-bottom:1px solid #ddd;}
#gnb .navbar-link { font-size: 19px; }
#gnb .navbar-link::after { content:""; display:none; }
#sidebar .navbar { display:block; width:100%; background-color:transparent; }
#sidebar .navbar-item { float:none; clear:both; display:block; width:100%; }
#frm1.search_form { border-top:2px solid #ddd; border-bottom:2px solid #ddd; height:60px; padding-top:10px; padding-bottom:10px;  }
#frm1 .inline { width:70%; float:left; margin-right:2%; }
#frm1.search_form .inline { display:inline-block; width:auto; } 
.navbar-item.has-dropdown.is-hoverable { min-width:110px; position:static; }
.navbar-item.has-dropdown.is-hoverable a { font-weight:800; }
.navbar-item.has-dropdown.is-hoverable.single { position:relative; }
#nav .navbar-dropdown.cate { min-width:940px; width:940px; position:absolute; left:50px; }
#nav .navbar-dropdown.single { min-width:150px; width:150px; left:auto; top:68px; }
#nav .navbar-dropdown.cate a { display:inline-block; padding:8px; margin-right:20px;  
width:120px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap; 
font-weight:500; }
#nav .navbar-dropdown.single a { display:inline-block; width:150px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap; 
font-weight:500; }
p.title { font-size:1.4rem; }
p.subtitle { font-size:1.1rem; }
.item_com { overflow: hidden;  text-overflow: ellipsis;  display: -webkit-box;
  -webkit-line-clamp: 3;  -webkit-box-orient: vertical; font-size:0.9rem; }
.breadcrumb ul li:last-child { padding-right:1.5rem; }
p.comment2 { max-width:400px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap; 
max-height:40px; }
.hidden_item { display:none; }

.star_data { height:36px; position:relative; background-image:url("${path0 }/data/star.png"); 
background-repeat:no-repeat; background-position:left center; background-size:100px auto; }

#star_group { width:100px; height:36px; position:relative; }
#star_group #stardate { width:100px; height:36px; background-image:url("${path0 }/data/star1.png"); 
background-repeat:no-repeat; background-position:left center; background-size:100px auto; }
#star_group #starrate { width:100px; height:36px; background-image:url("${path0 }/data/star.png"); 
background-repeat:no-repeat; background-position:left center; background-size:100px auto; }
#star10:checked ~ #star_group #starrate { width:100px; }
#star9:checked ~ #star_group #starrate { width:90px; }
#star8:checked ~ #star_group #starrate { width:80px; }
#star7:checked ~ #star_group #starrate { width:70px; }
#star6:checked ~ #star_group #starrate { width:60px; }
#star5:checked ~ #star_group #starrate { width:50px; }
#star4:checked ~ #star_group #starrate { width:40px; }
#star3:checked ~ #star_group #starrate { width:30px; }
#star2:checked ~ #star_group #starrate { width:20px; }
#star1:checked ~ #star_group #starrate { width:10px; }

#star_btn { width:100px; height:36px; position:absolute; z-index:20; top:0; left:0;  }
#star_btn label { display:block; width:10px; height:36px; position:relative; float:left; }

#page1 .page_wrap {text-align: center;}
#page2 .page_wrap {text-align: center;}
#page3 .page_wrap {text-align: center;}
#page4 .page_wrap {text-align: center;}

#fnb { width:1000px; margin: 0px auto; }
#f_addr { color: #FFFFFF; display: block; margin-bottom: 0.5em; line-height: 2;}
#f_copy { color: #c9d0e1; display: block; font-size: .75em; letter-spacing: 0.07em;}







</style>