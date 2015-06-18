<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影资源列表</title>

<script type="text/javascript" src="js/jquery-1.7.js" language="javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".tb tr").mouseover(function(){
			$(this).addClass("over");})
			
		$(".tb tr").mouseout(function(){
			$(this).removeClass("over");})
			
		$(".tb tr:even").addClass("alt");
	});
</script>

<jsp:useBean id="pagination" class="util.Pagination" scope="session"></jsp:useBean>	
<style>
#navigation{
	width:900px;
	height:35px;
	margin-top:10px;
	border:1px solid #BCD3E5;
	margin-left:auto;
	margin-right:auto;
	-webkit-border-radius: 10px;
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
#search{
	width:900px;
	height:25px;
	background:#DEDDDE;
	margin:0 auto;
	border:1px solid #DEDDDE;
	margin-top:5px;
	}
#main{
	width:900px;
	border:1px solid #F3FAFF;
	margin:0 auto;
	margin-top:5px;
}
p{
	margin-top:5px;
}
.ziti{
	font-family："微软雅黑";
	font-size:14px;
	}
	
.style{
	boder:0;
	height:20px;
	font-size:16px;
	width:400px;
	}
.color1 {background-color:#F0F5F8;}
tr.alt td{
	background:#ecf6fc;
}
tr.over td {
	background:#bcd4ec;
}
</style>
</head>
<%
User u=null;
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect("login.jsp");
	return;
}else{
	u=(User)request.getSession().getAttribute("user");	
}
List<MovCategory> cateLst=MovieControl.queryCategory();
%>
<body>
<div id="navigation">
	<ul>
		<%for(int i=0;i<cateLst.size();i++){%>
    	<li><a href="movieList.jsp?category=<%=cateLst.get(i).getId() %>"><%=cateLst.get(i).getCategory() %></a></li>
    	<%} %>
    </ul>

</div>
<div id="search">
	  
	<form action="MovieServlet?method=2" method="post">
	  <label>电影搜索：</label>
      <input type="text" name="keyword" class="text" size="25" value="" />
      <input type="submit" value="搜 索" class="search_btn" />
    </form>
</div>
<div id="main">
<table width="100%">
<tr>
<td width="88%"><p>电影列表：</p></td>
<td width="12%"><a href="addMovie.jsp">我要上传电影</a></td>
</tr>
</table>
<table class="tb" width="100%" border="0" cellspacing="0" cellpadding="0">
<%
		String pagestr=(String)request.getParameter("Page");
  		List list=null;
  		int Page=1;
  		int pagesize=10;
  		if(request.getAttribute("keyList")!=null)
  		{
  			list=(List)request.getAttribute("keyList");
  		}
  		else if(request.getParameter("category")==null)
  		{
			list=MovieControl.queryMovieAll();
		}else if(request.getParameter("category")!=null)
		{
			int category=Integer.parseInt(request.getParameter("category"));
  		    list=MovieControl.queryMovieByCateg(category);
		}
		if(pagestr==null){
		list=pagination.getInitPage(list,Page,pagesize);
		}else{
		Page=pagination.getPage(pagestr);
		list=pagination.getAppointPage(Page);
		}
		for(int i=0;i<list.size();i++){
			Movie m=(Movie)list.get(i);
			User a=ArticleControl.getAuthor(m.getUserId());
			String author=a.getName();
			int id=m.getId();
			String title=m.getTitle();
			String time=m.getUpdateTime();
			int read=m.getCount();
    %>
  <tr>
    <td width="2%">&nbsp;</td>
    <td width="18%">发布人：<%=author %></td>
    <td width="35%"><a href="movieDetail.jsp?mid=<%=id %>"><%=title %></a></td>
    <td width="15%"><%=time %></td>
    <td width="30%"><table width="100%" border="0">
      <tr>
      	<td width="23%">点击(<%=read %>)</td>
        <td width="23%">评论(3)</td>
        <td width="18%"><a href="">下载</a></td>
        <%if(u.getId()==m.getUserId()){ %>
        <td width="18%"><a href="updateMovie.jsp?mid=<%=id %>">修改</a></td>
        <td width="18%"><a href="MovieServlet?method=5&mid=<%=id %>">删除</a></td>
        <%}else{ %>
         <td width="18%"></td>
         <td width="18%"></td>
        <%} %>
      </tr>
    </table></td>
  </tr>
  <%} %>
</table>
</div>
<div id="foot"><%=pagination.printCtrlByURL(Page,"movieList.jsp") %></div>
</body>
</html>
