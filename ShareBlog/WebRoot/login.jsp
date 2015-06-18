<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="UserLoginServlet" method="post" >"
    <table align="center">
    	<tr>
    		<td>用户名：</td>
    		<td><input type="text" name="username"/></td>
    		<td>不存在该用户</td>
    	</tr>
    	<tr>
    		<td>密码：</td>
    		<td><input type="password" name="password"/></td>
    		<td>密码错误</td>
    	</tr>
    	<tr>
    		<td><input type="submit" name="submit" value="登录"/></td>
    		<td><input type="reset" name="reset" value="重置"/></td>
    	</tr>
    </table>
    </form> 
  </body>
</html>
