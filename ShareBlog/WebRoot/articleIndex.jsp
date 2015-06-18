<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="pagination" class="util.Pagination" scope="session"></jsp:useBean>	
<title>无标题文档</title>
<style type="text/css">
#list{
	width:630px;
	margin:0 auto;
	}
.article{
	width:630px;
	height:200px;
	border-bottom:1px solid #BCD3E5;
}
.img{
	width:70px;
	height:70px;
	margin-left:5px;
	float:left;
	margin-right:5px;
	margin-top:5px;}
.table{
	width:550px;
	height:200px;
	float:right;
	}
#foot{
	width:630px;
	height:20px;
	margin:0 auto;
	}
.ziti{
	font-family："微软雅黑";
	font-size:14px;
	color:#005EAC;
	}
.time{
	font-family："微软雅黑";
	font-size:12px;
	color:#888888;
	}
p{
	color:red;
	float:right;
}
a:link{
	text-decoration: none;
}
a:HOVER {
	text-decoration:underline;
}
</style>
</head>
<%
	String pagestr=(String)request.getParameter("Page");
	List alist=ArticleControl.queryArticleAll();
	int Page=1;
	int pagesize=8; 
	if(pagestr==null){
	alist=pagination.getInitPage(alist,Page,pagesize);
	}else{
		Page=pagination.getPage(pagestr);
		alist=pagination.getAppointPage(Page);
	}
 %>
<body>
<p><a href="articleList.jsp">查看所有文章</a></p>
<%
	for(int i=0;i<alist.size();++i){
	Article at=(Article)alist.get(i);
	User a=null;
	if(alist!=null)
	{
	 	a=ArticleControl.getAuthor(at.getUserId());
	}
	int id=at.getId();
	String title=at.getTitle().trim();
	String author=a.getName();
	String time=at.getCreateTime();
	String content=at.getContent();
	content=content.replaceAll("</?[^>]+>","");
	content=content.replace("&nbsp;","");
	content=content.replace("&ldquo;","“");
	content=content.replace("&rdquo;","”");    
	content=content.replace(".",""); 
    content=content.replace("\"","‘");
    content=content.replace("'","‘");
    if(content.length()>200){
    content=content.substring(0,200)+"...";
    }
	int read=at.getCount();
 %>
<div id="list">
	<div class="article">
    <div class="img">
    <img src="./images/user.jpg"  height="70px" width="70px"/>
    </div>
    <div class="table">
	<table width="100%"  border="0">
        <tr class="ziti">
          <td><a href="articleDetail.jsp?aid=<%=id %>"><%=title %></a></td>
        </tr>
        <tr class="ziti">
          <td><%=author %></td>
        </tr>
        <tr class="time">
          <td><%=time %></td>
        </tr>
        <tr >
          <td>
          	<%=content %>
          </td>
        </tr>
        <tr class="ziti">
          <td>阅读（<%=read %>）| <a href="">评论（）</a></td>
        </tr>
      </table>
  </div>
  </div>

</div>
<%} %>
<div id="foot"><%=pagination.printCtrlByURL(Page,"center.jsp") %></div>
</body>
</html>
