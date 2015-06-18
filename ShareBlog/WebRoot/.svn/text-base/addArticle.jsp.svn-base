<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加文章</title>
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
#main{
	width:600px;
	margin-top:20px;
	float:left;
	margin-left:240px;
	margin-right:auto;
}
.float-right{
	font-size:16px;
	float:right;
	margin-right:220px;
	margin-top:10px;
}
h2{
	margin-top:5px;
	font-size:20px;
	font-weight:bold;
}
#title{
	width:600px;
	margin:auto;
}
#the-title{
	width:600px;
	height:30px;
	font-size:18px;
	border:1px solid #CCCCCC;
}
#text{
	width:600px;
	margin:auto;
	margin-top:20px;
}
#editor{
	width:600px;
	font-size:15px;
	border:1px solid #CCCCCC;
	float:left;
}
#category{
	width:600px;
	margin:auto;
	margin-top:20px;
}
.label{
	font-size:15px;
	color:#666666;
	font-weight:bold;
}
.select{
	width:200px;
}
#submit{
	width:600px;
	margin:auto;
	margin-top:20px;
}
.submit{
	height:20px;
	width:60px;
	background-color:#89BBDE;
	font-size:15px;
}
.reset{
	height:20px;
	width:60px;
	background-color:#D6D6D6;
	font-size:15px;
}
</style>
<script type="text/javascript" src="xheditor/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="xheditor/xheditor-1.1.12-zh-cn.min.js">
</script>
</head>
<%
User u=null;
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect("login.jsp");
	return;
}else{
	u=(User)request.getSession().getAttribute("user");	
}
List<ArtCategory> cateLst=ArticleControl.queryCategory();
%>
<body>
<div id="navigation">
	<ul>
    	<%for(int i=0;i<cateLst.size();i++){%>
    	<li><a href="articleList.jsp?category=<%=cateLst.get(i).getId() %>"><%=cateLst.get(i).getCategory() %></a></li>
    	<%} %>
    </ul>

</div>
<a href="" class="float-right">返回文章列表</a>
<div id="main">
	<h2>发布新文章</h2>
	<form action="ArticleServlet?method=1" method="post">
    <div id="title">
    	<input type="text" name="title" id="title" value="" />
    	<input type="hidden" name="uid" value="<%=u.getId() %>"/>
     </div>
     <div id="text">
    <textarea name="content" id="editor"  class="xheditor-simple {skin:'vista',width:'600'}" cols="30" rows="20"></textarea> 	 
    </div>
    <div id="category">
    	<label class="label">文章分类:</label> 
		<select name="category"  class="select">
		<%for(int i=0;i<cateLst.size();i++){%>
		<option value="<%=cateLst.get(i).getId() %>" selected="selected">
		<%=cateLst.get(i).getCategory() %>
		</option>
		<%} %>
		</select> 
    </div>
    <div id="submit">
    	<input type="submit" value="发 布" class="submit"/>
        <input type="reset" value="取 消" class="reset" />
    </div>
  </form>
</div>
</body>
</html>
