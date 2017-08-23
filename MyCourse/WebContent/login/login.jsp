<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page import="java.sql.*" %>    
<!DOCTYPE html>
<head>
	<title>Login One</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Now ! Sign in</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="Login.do" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="username" placeholder="Username" name="username">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" placeholder="Password" name="password">
		            	<br>
		            	<span style="color: red">${msg}</span>
		            </div>
		          </div>
		        </div>
		          <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="text" name ="code" style="width: 150px">
		            	<img id="imgId" src="Checkcode" onclick="this.src='Checkcode?d='+Math.random();">
		            	<a href="# " onclick="this.src='Checkcode?d='+Math.random();" >看不清楚，点击图片</a>
		            	<br>
		            	<span style="color: red">${yzmsg}</span>	
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="checkbox">记住密码
                		</label>
	              	</div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="登录" class="btn btn-info">
		          		<a href="forgot-password.html" class="text-right pull-right" style="margin-right: 270px">忘记密码?</a>
		          	</div>
		          </div>
		        </div>
		        <hr>
		        <div class="form-group">
		        	<div class="col-md-12">
		        		<label>Login with: </label>
		        		<div class="inline-block">
		        			<a href="#"><i class="fa fa-facebook-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-twitter-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-google-plus-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-tumblr-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-github-square login-with"></i></a>
		        		</div>		        		
		        	</div>
		        </div>
		      </form>
		      <div class="text-center">
		      				<a href="../front/index.jsp" class="templatemo-create-new">返回主页<i class="fa fa-arrow-circle-o-right"></i>&nbsp;&nbsp;&nbsp;</a>
		      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      		      	<a href="regist.jsp" class="templatemo-create-new">立即注册<i class="fa fa-arrow-circle-o-right"></i></a>	
		      </div>
		</div>
	</div>
</body>
</html>