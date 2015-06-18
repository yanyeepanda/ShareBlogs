<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'othersUpload.jsp' starting page</title>
    
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
<div align="center">
  	<h1 class="style1">其他内容上传
	</h1>
  <form action="" method="post" enctype="multipart/form-data" name="form1">
    <table width="100%"  border="1" bordercolor="#9999FF" bgcolor="#CCCCFF">
      <tr>
        <td width="5%" align="right">标题:</td>
        <td width="28%" align="left"><input name="title" type="text" size="55"></td>
        <td width="6%" align="right">内容:</td>
        <td width="37%" align="left">
        <input type="hidden" name="method" value="addOthers">
        <input name="name" type="file" size="40"></td>
      </tr>
      <tr>
        <td align="right">简介:</td>
        <td align="left"><textarea name="synopsis" cols="53%" rows="10"></textarea></td>
        <td align="right">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td align="right"><input type="submit" name="Submit" value="提交"></td>
        <td align="left"><input type="reset" name="Submit" value="重置"></td>
        <td>&nbsp;</td>
      </tr>
    </table>
  </form>
  <p class="style1">&nbsp; </p>
</div>
  </body>
</html>
