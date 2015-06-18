<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:useBean id="pagination" class="util.Pagination" scope="session"></jsp:useBean>	
<title>无标题文档</title>
<style>
#list{
	width:630px;
	margin:0 auto;
	}
.movie{
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
	List mlist=MovieControl.queryMovieAll();
	int Page=1;
	int pagesize=8; 
	if(pagestr==null){
	mlist=pagination.getInitPage(mlist,Page,pagesize);
	}else{
		Page=pagination.getPage(pagestr);
		mlist=pagination.getAppointPage(Page);
	}
 %>
<body>
	<p>	<a href="movieList.jsp">查看所有电影</a></p>
	<%
		for(int i=0;i<mlist.size();++i){
		Movie m=(Movie)mlist.get(i);
		User a=null;
		if(mlist!=null)
		{
	 		a=ArticleControl.getAuthor(m.getUserId());
		}
		int id=m.getId();
		String title=m.getTitle().trim();
		String author=a.getName();
		String time=m.getUpdateTime();
		String synopsis=m.getSynopsis();
		synopsis=synopsis.replaceAll("</?[^>]+>","");
		synopsis=synopsis.replace("&nbsp;","");
		synopsis=synopsis.replace("&ldquo;","“");
		synopsis=synopsis.replace("&rdquo;","”");    
		synopsis=synopsis.replace(".",""); 
    	synopsis=synopsis.replace("\"","‘");
   	    synopsis=synopsis.replace("'","‘");
		if(synopsis.length()>200){
    	synopsis=synopsis.substring(0,200)+"...";
    	}
    	int read=m.getCount();
	 %>
<div id="list">
	<div class="movie">
    <div class="img">
    <img src="./images/user.jpg"  height="70px" width="70px"/>
    </div>
    <div class="table">
	<table width="100%"  border="0">
        <tr class="ziti">
          <td><a href="movieDetail.jsp?mid=<%=id %>"><%=title %></a></td>
        </tr>
        <tr class="ziti">
          <td><%=author %></td>
        </tr>
        <tr class="time">
          <td><%=time %></td>
        </tr>
        <tr class="ziti">
        	<td>剧情简介</td>
        </tr>
        <tr class="ziti">
          <td height="93">
          	<%=synopsis %>
     	 </td>
        </tr>
        <tr class="ziti">
          <td height="21"><a href="movieDetail.jsp?mid=<%=id %>">详细</a></td>
        </tr>
      </table>
  </div>
  </div>
</div>
<%} %>
<div id="foot"><%=pagination.printCtrlByURL(Page,"center.jsp") %></div>
</body>
</html>
