<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<jsp:useBean id="pagination" class="util.Pagination" scope="session"></jsp:useBean>	
<title>博文列表</title>
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
#search{
	width:900px;
	height:30px;
	background:#DEDDDE;
	margin:0 auto;
	border:1px solid #DEDDDE;
	margin-top:5px;
	}
#main{
	width:900px;
	border:1px solid #BCD3E5;
	margin:0 auto;
	margin-top:5px;
}
#foot{
	width:900px;
	height:20px;
	margin:0 auto;
	}
p{
	margin-top:5px;
}
.ziti{
	font-family："微软雅黑";
	font-size:14px;
	}
	
.style{
	boder:1;
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
<div id="search">
	<table class="style">
	<tbody>
	<tr>
		<td >文章搜索</td>
	  	<td>
		  <form action="ArticleServlet?method=4" method="post">
	      <input type="text" name="keyword" class="text" size="25" value="" />
	      <input type="submit" value="搜 索" class="search_btn" />
	      </form>
      </td>
      </tr>
    </tbody>
      </table>
</div>

<div id="main">
<table width="100%" border="0">
	<tr>
		<td>文章列表</td>
		<td align="right"><a href="addArticle.jsp">我要写文章</a></td>
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
			list=ArticleControl.queryArticleAll();
		}else
		{
			int category=Integer.parseInt(request.getParameter("category"));
  		    list=ArticleControl.queryArticleByCategory(category);
		}
		if(pagestr==null){
		list=pagination.getInitPage(list,Page,pagesize);
		}else{
		Page=pagination.getPage(pagestr);
		list=pagination.getAppointPage(Page);
		}
		for(int i=0;i<list.size();i++){
			Article art=(Article)list.get(i);
			User a=ArticleControl.getAuthor(art.getUserId());
			String author=a.getName();
			int id=art.getId();
			String title=art.getTitle();
			String time=art.getCreateTime();
			int read=art.getCount();
    %>
    <tbody>
  <tr>
    <td width="2%">&nbsp;</td>
    <td width="17%">作者：<%=author %></td>
    <td width="40%"><a href="articleDetail.jsp?aid=<%=id %>"><%=title %></a></td>
    <td width="19%"><%=time %></td>
    <td width="22%"><table width="100%" border="0">
      <tr class="ziti">
        <td width="30%">阅读(<%=read %>)</td>
        <td width="30%">评论(4)</td>
        <%if(u.getId()!=a.getId()){ %>
        <td width="20%"></td>
        <td width="20%"></td>
        <%} %>
        <%if(u.getId()==a.getId()){ %>
        <td width="20%"><a href="updateArticle.jsp?aid=<%=id %>">修改</a></td>
        <td width="20%"><a href="ArticleServlet?method=3&aid=<%=id %>">删除</a></td>
       	<%} %>
      </tr>
    </table></td>
  </tr>
  </tbody>
  <%} %>
</table>
</div>

</body>
</html>
