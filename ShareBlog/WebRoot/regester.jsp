<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/userVerify.js"></script>
  </head>
  
  <body>
    <form action="AddUserServlet" method="post" enctype="multipart/form-data">
    	<table align="center">
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="username" class="username"/>
    				<input type="button" value="校验" id="verifyButton" />
    				<div id="result"></div>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="password"/></td>
    		</tr>
    		<tr>
    			<td>重复密码：</td>
    			<td><input type="password" name="ConfirmPass"/></td>
    		</tr>
    		<tr>
    			<td>Email：</td>
    			<td><input type="text" name="email"/></td>
    		</tr>
    		<tr >
    			<td rowspan="4">头像</td>
    			<td><input type="file" name="touxiangURL" />
    				预览<img alt="" src="">
    			</td>
    		</tr>
    		<tr>
    			<td><input type="submit" name="submit" value="登录"/></td>
    			<td><input type="reset" name="reset" value="重置"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
