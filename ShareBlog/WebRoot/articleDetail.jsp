<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
#page{
	width:900px;
	margin:auto;

}
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
#author{
	width:600px;
	float:left;
	height:20px;
	margin-top:15px;
}
a{
	font-size:17px;
	font-weight:bold;
	color:#3078AB;
}
#article{
	width:600px;
	float:left;
	margin-top:20px;

}
#title{
	width:600px;
	margin:auto;
	border-top:1px solid #CEE1EE;
}
strong{
	font-size:20px;
	font-weight:bold;
	margin-top:10px;
}
span{
	font-size:12px;
	color:#666666;
	margin-top:5px;
}
#content{
	width:600px;
	margin:auto;
	margin-top:20px;
	border-bottom:1px solid #CEE1EE;
}
h{
	font-size:15px;
	color:#0078C0;
}
.submit{
	height:20px;
	width:60px;
	background-color:#89BBDE;
	font-size:15px;
}
.commentDetail{
	width:600px;
	float:left;
	margin-top:1px;	
	background-color:#F0F5F8;
}
.white{
	height:1px;
	width:inherit;
	background-color:white;
}
.comment-right{
	width:530;
}
.img{
	width:70px;
	height:70px;
	float:left;
}
.detail{
	width:530px;
	float:right;
	font-family："微软雅黑";
	font-size:12px;
}
</style>
<script type="text/javascript" src="js/jquery-1.7.js" language="javascript"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	$('#comment').find('#comdiv').hide().end().find('a').click(function(){
		$('#comdiv').toggle();
	});
});
</script>
</head>
<%
	User user=null;
	if(request.getSession().getAttribute("user")==null){
		response.sendRedirect("login.jsp");
	}else{
		user=(User)request.getSession().getAttribute("user");//当前登录用户
	}
	int id;
	if(request.getParameter("aid")==null)
	{
		id=(Integer)request.getAttribute("aid");
	}else
	{
 	 	id=Integer.parseInt(request.getParameter("aid"));
 	 }
  	Article a=null;
  	User u=null;
  	if(id!=0)
  	{
  		 a=ArticleControl.queryArticleById(id);
  		 System.out.print(a.getTitle());
  		 u=ArticleControl.getAuthor(a.getUserId());
  	}
  	 String category=ArticleControl.getCategory(a.getCategory());
  	 int read=a.getCount();
   %>
<%
List<ArtCategory> cateLst=ArticleControl.queryCategory();
User loginUser=(User)request.getSession().getAttribute("user");
%>
<body>
<div id="page">
<div id="navigation">
	<ul>
    	<%for(int i=0;i<cateLst.size();i++){%>
    	<li><a href="articleList.jsp?category=<%=cateLst.get(i).getId() %>"><%=cateLst.get(i).getCategory() %></a></li>
    	<%} %>
    </ul>
</div>
<div id="author"><a><%=u.getName() %>的博文</a></div>
<div id="article">
	<div id="title">
		<p><strong><%=a.getTitle() %></strong>	</p>
        <p><span><%=a.getCreateTime() %></span><span>|</span><span>(分类:<%=category %>)</span></p>
	</div>
    <div id="content">
    	<%=a.getContent() %>
    </div>
    <div id="comment">
 		<p align="right"><span>阅读（<%=read %>）</span><span>|</span><span>评论(2)</span></p>
 		
 		<%
 			List<ArtComment> acList=CommentControl.queryArtComment(a.getId());
 			for(int i=0;i<acList.size();i++)
 			{
 				ArtComment ac=acList.get(i);
 				User comUser=ArticleControl.getAuthor(ac.getUserId());
 				String userName=comUser.getName();
 				String time=ac.getCreateTime();
 		 %>
 		<div class="commentDetail">
        	<div class="white"></div>
        	<div class="img"><img src="./images/user.jpg" width="64" height="69" /></div>
            <div class="comment-right">
            	<table width="42%" border="0">
                  <tr>
                    <td width="33%"><a><%=userName %></a></td>
                    <td width="67%"><span><%=time %></span></td>
                  </tr>
                </table>
				<div class="detail" >
 				<%=ac.getContent() %>
                </div>
        	</div>
     	 </div>
		<%} %>
        <p><a id="com">我要评论</a></p>
        <div id="comdiv">
        	<form action="CommentServlet?method=1" method="post">
        	<textarea name="comment" cols="75" rows="5"></textarea>
        	<input type="submit" name="submit" class="submit" value="评论"/>
        	<input type="hidden" name="artId" value="<%=a.getId() %>"/>
        	</form>
        </div>  
    </div>
</div>
</div>
</body>
</html>
