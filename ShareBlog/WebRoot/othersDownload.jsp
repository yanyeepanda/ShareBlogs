<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'othersDownload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#CCCCFF">
<table width="100%"  border="1" bordercolor="#9999FF">
  <tr>
    <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <h1><font color="#008800">����������</font></h1></td>
  </tr>
 
 
 
  <tr>
    <td colspan="2"><span style="font-size: 12px;"><span style="color: black;"><span style="color: red;"><strong>�ļ���ʽ</strong></span></span></span></td>
  </tr>
  <tr>
    <td colspan="2"><span style="font-size: 12px;"><span style="color: black;">��С:</span></span></td>
  </tr>
 
  <tr>
    <td colspan="2"><span style="font-size: 12px;"><span style="color: black;">���<br>
         <br>
         
    </span></span></td>
  </tr>
  <tr>
    <td colspan="2"><span style="font-size: 12px;"><font size="3" color="#ff0000"><strong>�����ص�ַ��</strong></font></span></td>
  </tr>
  <tr>
    <td width="26%"> <span style="font-size: 12px;"><font color="red">���ص�ַ1��<a title="Ѹ������" href="" target="_self">�������Ѹ�׸�������</a> </font></span></td>
    <td width="74%"><span style="font-size: 12px;"><font color="red">���ص�ַ2��<a title="Ѹ������" href="" target="_self">�������Ѹ�׸�������</a> </font></span></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
<p class="ziti">��������</p>
 <table width="100%"  border="1" bordercolor="#9999FF">
 <tr>
  <td width="3%">
 <table width="3%"  border="1" align="left" bordercolor="#9999FF" class="ziti">
     <tr>
      <td><img src="" width="70" height="75"></td>
     <td><img src="images/articleback.gif" width="70" height="75"></td>
    </tr>
  <tr>
   <td>����������</td>
  </tr>
</table>
</td>
<td width="92%" valign="top">
<table  height="100%" width="100%"    class="ziti">
  <tr>  <td width="85%">&nbsp;</td>
  <td width="15%">����</td> </tr>
  <tr><td colspan="2">����</td></tr>
</table></td>
</tr>
  </table>
<p><span class="ziti">��Ҫ����</span>��</p>
<form name="form1" method="post" action="others.do">
  <table width="100%"  border="1" bordercolor="#9999FF" class="ziti">
    <tr>
      <th width="8%" scope="col">&nbsp;
      <input type="hidden" name="method" value="criticOthers">
      <input type="hidden" name="id" value="">
      
      </th>
      <th width="92%" align="left" scope="col"><textarea name="synopsis" cols="85" rows="6"></textarea></th>
    </tr>
    <tr>
      <th align="right" scope="row"><input type="submit" name="Submit" value="����"></th>
      <td><input type="reset" name="Submit" value="����"></td>
    </tr>
  </table>
</form>
</body>
</html>
