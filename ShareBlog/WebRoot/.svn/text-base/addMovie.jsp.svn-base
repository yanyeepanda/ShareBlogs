<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" href="calendar/calendar.css" rel="stylesheet"  />
<script type="text/javascript" src="calendar/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="calendar/cal.js" charset="utf-8"></script>
<script type="text/javascript" >
	jQuery(document).ready(function () {
	$('input.time').simpleDatepicker({ x: 4, y: 30 });
});
</script>
<style>
#navigation{
	width:900px;
	height:35px;
	margin-top:10px;
	border:1px solid #BCD3E5;
	margin-left:auto;
	margin-right:auto;
	}
#navigation ul{

	font-size:20px;
	list-style:none;
	margin-top:5px;
	margin-left:100px;
}
#navigation ul li{
	float:left;
	margin-left:25px;
}
#navigation ul li a{
	display:block;
	line-height:35px;
	text-decoration:none;
}
#navigation ul li a:hover{
	color:#3078AB;
}
#movie{
	width:900px;
	margin:auto;
	margin-top:10px;
	} 
#float-right{
	width:900px;
	height:20px;
}
#main{
	width:900px;
	background-color:#F3FAFF;
}
</style>
<script type="text/javascript" src="xheditor/xheditor-1.1.12-zh-cn.min.js">
</script>
</head>
<%
	if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return;
	}
 %>
<body>
<div id="navigation">
	<ul>
		<%
			List<MovCategory> list=MovieControl.queryCategory();
			for(int i=0;i<list.size();i++)
			{
				MovCategory mc=list.get(i);
		 %>
    	<li><a href="movieList.jsp?category=<%=mc.getId() %>"><%=mc.getCategory() %></a></li>
        <%} %>
    </ul>

</div>
<div id="movie">
    	<p align="right"><a href="">返回电影列表</a></p>
        <h2>上传电影
    </h2>
  <div id="main">
  	<form action="MovieServlet?method=1" method="post" enctype="multipart/form-data">
    <table width="100%" border="0">
      <tr>
    <td width="10%" height="29" align="right">电 影 名：</td>
    <td width="40%"><input type="text" name="title" value="" style="width:300px;height:20px;"/></td>
    <td width="10%" align="right">导演：</td>
    <td width="40%"><input type="text" name="director" value="" style="width:300px; height:20px "/></td>
  </tr>
  <tr>
    <td height="34" align="right">电影类别：</td>
    <td>
    	<select name="category"  class="select" style="width:100px">
		<%
			List<MovCategory> mlist=MovieControl.queryCategory();
			for(int i=0;i<mlist.size();i++)
			{
				MovCategory mc=mlist.get(i);
		 %>
		<option value="<%=mc.getId() %>" selected="selected">
		<%=mc.getCategory() %>                
		</option>
		<%} %>	
		</select> 
    </td>
    <td align="right">主演：</td>
    <td><input type="text" name="actor" value="" style="width:300px; height:20px "/></td>
  </tr>
  <tr>
    <td height="35" align="right">上映时间：</td>
    <td><input type="text" name="time" class="time" value="" style="width:300px; height:20px "/></td>
    <td align="right">时长：</td>
    <td><input type="text" name="long" value="分钟" style="width:300px; height:20px "/></td>
  </tr>
  <tr>
    <td height="35" align="right">下载文件：</td>
    <td><input type="file" name="address" value="" style="width:300px; height:25px "/></td>
    <td align="right">影片海报：</td>
    <td><input type="file" name="img" value="" style="width:300px; height:25px"/></td>
  </tr>
</table>
  <table width="899" border="0">
  <tr>
    <td width="87" height="40" align="right">影片简介：</td>
    <td width="800"><textarea name="synopsis" class="xheditor-simple {skin:'vista',width:'600'}" cols="92" rows="10"></textarea></td>
  </tr>
  </table>
  <table width="596" border="0">
  <tr align="right" >
    <td width="284" height="36"><input type="submit" name="submit" value="提  交" style="width:60px; background-color:#7CACD4" /></td>
    <td width="225"><input type="button" name="reset" value="重  置" style="width:60px; background-color:#D6D6D6"/></td>
</tr>
</table>
	</form>
    </div>
</div>
</body>
</html>
