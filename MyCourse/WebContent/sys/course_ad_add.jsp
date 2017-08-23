<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="course_ad_add.jsp">公告管理</a><span class="crumb-step">&gt;</span><span>新增公告</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="Course?v=add" method="post" id="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                       	 <tr>
                            <th width="120"><i class="require-red">*</i>课程类型：</th>
                            <td>
                                <select name="course_type" id="catid" class="required">
                                    <option value="${course.course_type}">${course.course_type}</option>
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
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>课程名称：</th>
                                <td>
                                    <input class="common-text required"  name="course_name" size="50"  type="text" >
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>课程价格：</th>
                                <td>
                                    <input class="common-text required"  name="course_price" size="50"  type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>课程时长：</th>
                                <td>
                                    <input class="common-text required"  name="course_time" size="50"  type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>课程图片：</th>
                                <td><input name="course_img"  type="file"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>课程视频：</th>
                                <td><input name="course_video" type="file" ></td>
                            </tr>
                             <tr>
							<th><i class="require-red">*</i>课程状态：</th>
							<td>
								<input type="radio" name="course_status" value="1" />出售中
								<input type="radio" name="course_status" value="0"/>已下架
							</td>
							</tr>
                            <tr>
                                <th>课程介绍：</th>
                                <td><textarea name="course_desc" class="common-textarea" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="增加" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>