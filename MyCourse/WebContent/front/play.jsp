<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
    <meta charset="UTF-8">
    <title>用户中心</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/mylessons.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <style type="text/css">
     input,button{font: 12px/1.14 "Arial","Hiragino Sans GB",\5b8b\4f53,"Georgia","serif";color: #333;outline: 0;height:28px;}
     select{height:30px;}

    </style> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/skin/minimalist.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/flowplayer/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/flowplayer/flowplayer.min.js"></script>    
  
  
    
</head>
<body>
<div class="topbar-wrap white">
    <!--<div class="topbar-inner clearfix">-->
    
    <div></div><div></div><div></div>
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">用户中心</a></h1>
            
                测试
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li id="li1"><a href="showcourse?v=list&course_type=course_type"><i class="icon-font">&#xe005;</i>所有课程</a>	</li>
                        <li class="li2"><a href="showcourse?v=list&course_type=旅游">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;旅游</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=运动健身">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;运动健身</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=文学艺术">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文学艺术</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=演讲">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;演讲</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=电影">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电影</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=经济">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经济</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=科技">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;科技</a></li>
                        <li class="li2"><a href="showcourse?v=list&course_type=美食">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;美食</a></li>
                      <!--   <li><a href="customer-订单查询.html"><i class="icon-font">&#xe006;</i>订单查询</a></li>
                        <li><a href="customer-课程出售.html"><i class="icon-font">&#xe008;</i>课程出售</a></li> -->
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">展示课程</span>
            </div>
            
        </div>
       	
        <div class="flowplayer" data-ratio="0.565" data-swf="${pageContext.request.contextPath }/js/flowplayer/flowplayer.swf">
		  <video>
	   <source type="video/mp4" src="/MyCourse/${param.url}">
	  </video>
	  </div>
       
 
    </div>
 
</div>
</body>
</html>