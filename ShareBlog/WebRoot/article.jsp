<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ShareBlog在线资源共享</title>
<style>
#main{
	margin:0 auto;
	width:900px;
	border:none;
}
#head{
	width:900px;
	height:40px;
}
#head table{
	margin-top:6px;
}
#navigation{
	width:900px;
	height:40px;
	margin-top:10px;
	border:1px solid #BCD3E5;
	margin-left:auto;
	margin-right:auto;

	}
#navigation ul{

	font-size:24px;
	list-style:none;
	margin-top:5px;
	margin-left:150px;
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
#middle{
	width:900px;
	margin-top:10px;
	border:1px solid #BCD3E5;

	}
#left{
	width:240px;
	float:left;
	margin-left:5px;
	border:1px solid #BCD3E5;
	margin-top:10px;
}
#right{
	width:640px;
	float:right;
	margin-right:5px;
	border:1px solid #BCD3E5;
	margin-top:10px;

}
#foot{
	width:900px;
	height:40px;
	}
</style>
</head>
<%
	User u=null;
	u=(User)request.getSession().getAttribute("user"); 
 %>
<body>
<div id="main">
<div id="head">
  <table width="40%" border="0" align="right">
    <tr>
      <%
      	if(u!=null){
       %>
      <td width="24%">欢迎你：<%=u.getName() %></td>
      <%}else{ %>
      <td width="38%">您还没有登陆</td>
      <%} %>
      <td width="13%"><a href="login.jsp">登陆</a></td>
      <td width="12%"><a href="regester.jsp">注册</a></td>
      <td width="13%"><a href="logout.jsp">退出</a></td>
    </tr>
  </table>
</div>
<div id="navigation">
	<ul>
    	<li id="index"><a href="center.jsp">首页</a></li>
        <li id="article"><a href="article.jsp">博文</a></li>
        <li id="music"><a href="">音乐</a></li>
        <li id="movie"><a href="movie.jsp">电影</a></li>
        <li id="wenku"><a href="wenku.jsp">文库</a></li>
        <li><a href="">我的博客</a></li>
    </ul>
</div>
<div id="middle">
    <div id="left">
    <jsp:include page="left.jsp" flush="true" />
    </div>
    <div id="right">
	<jsp:include page="articleIndex.jsp" flush="true" />
    </div>
</div>
<div id="foot">
</div>
</div>
</body>
</html>
