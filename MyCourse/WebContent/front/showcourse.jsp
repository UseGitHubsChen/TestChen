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
       
       <!--  <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">运动健身</option>
                                    <option value="20">旅游</option>
                                    <option value="21">文学艺术</option>
                                    <option value="22">演讲</option>
                                    <option value="23">经济</option>
                                    <option value="24">电影</option>
                                    <option value="25">科技</option>
                                    <option value="26">美食</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
 -->
            <form name="" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">

                    </div>
                </div>
                <div class="result-content">
                    <div class="m-main-b"> 
                        <div class="auto-1460270624541-parent" id="j-pool">
                            <div class="m-basepool f-cb auto-1460270624541">
                                <div class="j-list">
                                    <div class="m-data-lists f-cb f-pr j-data-list">

                                        <div class="first">
                                            <div class="w-main-lib" id="MBHOHHVI7" style="height: 180px">  
                                                <a class="link" href="#"  target="_blank"> 
                                                <div class="w-his f-pr" href=""> 
                                                    <img width="160px" height="120px" src="http://vimg1.ws.126.net/image/snapshot_movie/2016/3/I/8/MBHOHHVI8.jpg" alt="中国传统人生智慧 第1集"> 
                                                </div> 
                                                <h7>中国传统人生智慧 第1集</h7> 
                                                </a> 
                                             	 <span class="playli">点击按钮观看:</span><br>
                                                <form name="formmark2" id="formmark2" method="get">
                                                <input type="submit" id="submit-mark2" value="&nbsp;&nbsp;观&nbsp;&nbsp;看&nbsp;&nbsp;" onclick="check()">
                                                </form>
                                            </div> 
                                        </div>
		                                        
                                       <c:forEach items="${list}" var="list">
                                               <div class=""> 
                                            <div class="w-main-lib" id="M9DOKVO3K" style="height: 200px">  
                                                <div class="w-his f-pr" href=""> 
                                                    <img width="160px" height="120px" src="	/MyCourse/${list.course_img}" alt="科学究竟是什么 第1集"> 
                                                </div> 
                                                <h7>${list.course_name}</h7> 
                                                </a> <br>
                                                <span class="playli">点击按钮观看:</span><br>
                                                <form name="formmark2" id="formmark2" method="post" action ="/MyCourse/front/play.jsp?url=${list.course_video}">
                                                <input type="submit" id="submit-mark2" value="&nbsp;&nbsp;观&nbsp;&nbsp;看&nbsp;&nbsp;" onclick="check()">
                                                </form>
                                            </div> 
                                        </div>
                                     </c:forEach> 
                                        
                                        
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>
                    
                </div>
            </form>
    </div>
    <!--/main-->
</div>
</body>
</html>