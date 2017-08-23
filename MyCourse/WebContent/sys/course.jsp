<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js">
    </script>
    <!-- 全选功能  -->
    <script type="text/javascript">
       function allCheck(check){
    	var checkbox=document.getElementsByName("ck");
    	if(check.checked){
    	for(var i=0;i<checkbox.length;i++){
    	checkbox[i].checked="checked";
    	} 
    	}else{
    	for(var i=0;i<checkbox.length;i++){
    	checkbox[i].checked="";
    	} 
    	}
    	};
    	
    	//利用js实现提交
    	function sendDel(){
    		document.getElementById("myform").submit();//表单提交
    	};
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
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
                        <li><a href="Course?v=list"><i class="icon-font">&#xe008;</i>课程管理</a></li>
                        <li><a href="course_ad_add.jsp"><i class="icon-font">&#xe005;</i>公告发布</a></li>
                        <li><a href="Order?v=list"><i class="icon-font">&#xe006;</i>订单查询</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>后续操作</a></li> 
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">课程管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="Course?v=findByType" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="course_type" id="">
                                     <option value="course_type">全部</option>
                                     <option value="运动健身">运动健身</option>
                                     <option value="旅游">旅游</option>
                                     <option value="文学艺术">文学艺术</option>
                                     <option value="演讲">演讲</option>
                                     <option value="经济">经济</option>
                                     <option value="电影">电影</option>
                                     <option value="科技">科技</option>
                                     <option value="美食">美食</option>
                                </select>
              				</td>
                           <td> &nbsp;<input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post" action="Course?v=batchDel">
                <div class="result-title">
                    <div class="result-list">
                        <a href="course_add.jsp"><i class="icon-font"></i>新增课程</a>
                        <a id="batchDel" href="javascript:void(0)" onclick="sendDel();"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                        <a href="javascript:void(0)">${mess}</a>	
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                        	<td width="100px"><input name="all" type="checkbox" style="margin-left: 20px"	id="main" onclick="allCheck(this);" >&nbsp;&nbsp;&nbsp;全选</td>
                        	<!-- <th class="tc" ></th> -->
                            <th>课程名称</th>
                            <th>课程类型</th>
                            <th>课程价格</th>
                            <th>课程时长</th>
                            <th>课程状态</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach items="${pb.list}" var="list">
                        
                           <tr>
                            <td class="tc"><input value="${list.course_id}" type="checkbox" name = "ck"></td>
                            <td><a target="_blank" href="#">${list.course_name}</a> 
                            </td>
                            <th>${list.course_type}</th> 
                            <th>${list.course_price}</th> 
                            <td>${list.course_time}</td>
                           	<c:choose>
                           	<c:when test="${list.course_status eq '1'}">
                           	  	<td>出售中</td>
                           	</c:when>
                           	<c:when test="${list.course_status eq '0'}">
                           	  	<td>已下架</td>
                           	</c:when>
                         	<c:otherwise>
                         		<td>不确定状态</td>
                         	</c:otherwise>
                           	</c:choose>
                           
                            <td>
                                <a class="link-update" href="Course?v=editCourse&course_id=${list.course_id}">修改</a>	
                                <a class="link-del" href="Course?v=del&course_id=${list.course_id}" onclick="alert('确认删除吗？')">删除</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>	
                    <div class="list-page"> 
                    	
                 	 共  <span style="color: red">${pb.totalCount}</span> 条记录 
                 	 共 <span style="color: red"> ${pb.totalPage}</span> 页
                 	 当前第 <span style="color: red"> ${pb.pageNum}</span> 页  &nbsp;&nbsp;&nbsp;&nbsp; 
                   	<a href="Course?v=list&pageNum=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                   	<c:if test="${pb.pageNum == 1}">
                   	上一页&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum != 1}">
                   	<a href="Course?v=list&pageNum=${pb.pageNum-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum == pb.totalPage}">
                   	下一页&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum != pb.totalPage}">
                   	<a href="Course?v=list&pageNum=${pb.pageNum+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                   	</c:if>
                   	<a href="Course?v=list&pageNum=${pb.totalPage}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                <!--  <input type="text" name="pageNum" style="width: 20px;height: 10px;"> -->
                    </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>