<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'others.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body topmargin="0">
  	<form action="" method="post">
  		<table width="100%"  border="1" bordercolor="#9999FF">
  			<tr class="ziti">
  			<td colspan="2" align="right">����:</td>
  			<td colspan="2"><input name="keyword"   type="text" value="�ؼ���" size="44"></td>
  			<td colspan="2" align="left">
    			<input type="hidden" name="method" value="searchOthers"> 
    			<input type="submit" name="Submit" value="����">
    		</td>
    		<td align="right"><span class="style1">
    			<a href="" target="_blank">��Ҫ�ϴ�</a>
    			&nbsp;
    		</span>
    		</td>	
  			</tr>
  			<tr>
   			 <td colspan="7"   background=""><A href="#"></A><A 
				href="#"></A></td>
 		   </tr>
 		   
 		   <tr class="ziti">
 		   		<td width="2%" align="center"><img src="" width="20" height="20"></td>
 		   		<td align="left">���ߣ�</td>
 		   		<td colspan="3" align="left">
 		   		<a href="">
 		   			��Ӱ����
				</a>
 		   		</td>
 		   		<td align="right"> ����:</td>
 		   		<td align="center">��� �� <a href="">���� </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">ɾ��</a>
 		   		</td>	
 		   </tr>
  		</table>
  	</form>  
  </body>
</html>
