<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员中心</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
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
    <!--<div class="topbar-inner clearfix">-->
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">管理员中心</a></h1>
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
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp" color="#white">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="1">已处理</option>
                                    <option value="0">未处理</option>
                                </select>
                            </td>
                            <td>&nbsp;<input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                        	<td width="100px"><input name="all" type="checkbox" style="margin-left: 20px"	id="main" onclick="allCheck(this);" >&nbsp;&nbsp;&nbsp;全选</td>
                            <th>订单号</th>
                            <th>购买者用户名</th>
                            <th>课程名字</th>
                            <th>订单时间</th>
                            <th>课程价格</th>
                            <th>操作</th>
                        </tr>
                       
                           <c:forEach items="${pb.listorder}" var="list">
                        
                           <tr>
                            <td class="tc"><input value="${list.order_id}" type="checkbox" name = "ck"></td>
                            <th>${list.order_id}</th>
                            
                            <th>1111</th> 
                            <th>1111111</th> 
                            <td>${list.order_time}</td>
                           	<c:choose>
                           	<c:when test="${list.order_status eq '1'}">
                           	  	<td>已处理</td>
                           	</c:when>
                           	<c:when test="${list.order_status eq '0'}">
                           	  	<td>未处理</td>
                           	</c:when>
                         	<c:otherwise>
                         		<td>不确定状态</td>
                         	</c:otherwise>
                           	</c:choose>
                           
                            <td>
                                <a class="link-update" href="Course?v=editCourse&course_id=${list.order_id}">处理</a>	
                            </td>
                        </tr>
                        </c:forEach>
                    </table>	
                    <div class="list-page"> 
                    
                 	 共  <span style="color: red">${pb.totalCount}</span> 条记录 
                 	 共 <span style="color: red"> ${pb.totalPage}</span> 页
                 	 当前第 <span style="color: red"> ${pb.pageNum}</span> 页  &nbsp;&nbsp;&nbsp;&nbsp; 
                   	<a href="Order?v=list&pageNum=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                   	<c:if test="${pb.pageNum == 1}">
                   	上一页&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum != 1}">
                   	<a href="Order?v=list&pageNum=${pb.pageNum-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum == pb.totalPage}">
                   	下一页&nbsp;&nbsp;&nbsp;&nbsp;
                   	</c:if>
                   	<c:if test="${pb.pageNum != pb.totalPage}">
                   	<a href="Order?v=list&pageNum=${pb.pageNum+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                   	</c:if>
                   	<a href="Order?v=list&pageNum=${pb.totalPage}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
                <!--  <input type="text" name="pageNum" style="width: 20px;height: 10px;"> -->
                    </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>