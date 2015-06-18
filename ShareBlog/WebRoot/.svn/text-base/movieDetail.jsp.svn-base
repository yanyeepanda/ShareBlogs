<%@ page language="java" import="java.util.*,com.share.control.*,com.share.model.*" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影详细</title>
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
	border-bottom:1px solid #CEE1EE;
}
.submit{
	height:20px;
	width:60px;
	background-color:#89BBDE;
	font-size:15px;
}
a{
	font-size:17px;
	font-weight:bold;
	color:#3078AB;
}
#movie{
	width:710px;
	float:left;
	margin-top:10px;
	border-right:1px dashed #999999;
}
#img{
	width:250px;
	height:350px;
	float:left;
	border:1px solid blue;
	margin-right:5px;
}
#content{
	width:460;
	float:right;
	}
#download{
	width:700px;
	margin-top:20px;
	float:left;
	background-color:#F6F6F6;
	font-size:14px;
	color:blue;
	font-family:"Times New Roman";
	border-bottom:3px solid #DEDDDE;
}
h4{
	font-weight:bold;
}
#story{
	width:700px;
	background-color:#FFFBF7;
	margin-top:15px;
	border-bottom:3px solid #DEDDDE;
}
#comment{
	width:700px;
	margin-top:20px;

}
.commentDetail{
	width:700px;
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
	width:630;
}
.img{
	width:70px;
	height:70px;
	float:left;
}
.detail{
	width:630px;
	float:right;
}
span{
	font-size:12px;
	color:#666666;
	margin-top:5px;
}
#table tr{
	padding:5px;
	border:1px dashed
	#999999;
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
	if(request.getSession().getAttribute("user")==null)
	{
		response.sendRedirect("login.jsp");
		return;
	}else
	{
		user=(User)request.getSession().getAttribute("user");
	}
	int mid;
	if(request.getParameter("mid")==null)
	{
		mid=(Integer)request.getAttribute("mid");
	}else
	{
 	 	mid=Integer.parseInt(request.getParameter("mid"));
 	 }
  	Movie m=null;
  	User u=null;
  	if(mid!=0)
  	{
  		 m=MovieControl.getMovieById(mid);
  		 u=ArticleControl.getAuthor(m.getUserId());
  	}
  	 String category=MovieControl.getCategory(mid);
  	 int read=m.getCount();
   %>
<%
List<MovCategory> cateLst=MovieControl.queryCategory();
%>

<body>
<div id="page">
<div id="navigation">
	<ul>
    	<%for(int i=0;i<cateLst.size();i++){%>
    	<li><a href="movieList.jsp?category=<%=cateLst.get(i).getId() %>"><%=cateLst.get(i).getCategory() %></a></li>
    	<%} %>
    </ul>
</div>
<div id="author"><a><%=u.getName() %>&nbsp;的电影</a></div>
<div id="movie">
	<h3> <%=m.getTitle()	 %></h3>
	<div class="img"><img src="<%=m.getImageUrl() %>" /></div>
	<div id="content">
	<table width="60%"  border="0" id="table">
  <tr>
    <td width="22%" height="34">导演：</td>
    <td width="78%"><%=m.getDirector() %></td>
  </tr>
  <tr>
    <td height="38">主演：</td>
    <td><p><%=m.getActor() %></p>
    </td>
  </tr>
  <tr>
    <td height="37">类型：</td>
    <td><%=category %></td>
  </tr>
  <tr>
    <td height="40">时长：</td>
    <td><%=m.getMovieTime() %>分钟</td>
  </tr>
   <tr>
    <td height="48">上映时间：</td>
    <td><%=m.getProductTime() %></td>
  </tr>
    <tr>
    <td height="48">文件格式：</td>
    <td><%=m.getFormat() %></td>
  </tr>
</table>
</div>
<div id="download">
	<h4>[下载地址]</h4>
	<table width="100%" border="0">
  <tr>
    <td width="13%" height="30">下载地址1：</td>
    <td width="87%"><a href="MovieServlet?method=4&url=<%=m.getMovieUrl() %>">迅雷高速下载1</a></td>
  </tr>
  <tr>
    <td height="36">下载地址2：</td>
    <td><a href="MovieServlet?method=4&url=<%=m.getMovieUrl() %>">迅雷高速下载2</a></td>
  </tr>
</table>
</div>
<div id="story">
	<h3> 剧情介绍:</h3>
	<p><%=m.getSynopsis() %></p>
</div>
<div id="comment">
	<h3>影片评价</h3>
	<%
 			List<MovComment> acList=CommentControl.queryMovComment(m.getId());
 			for(int i=0;i<acList.size();i++)
 			{
 				MovComment ac=acList.get(i);
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
				<div class="detail">
				<%=ac.getContent() %>
                </div>
        	</div>
     	 </div>
     	 <%} %>
	<p><a id="com">我要评论</a></p>
	<div id="comdiv">
        	<form action="CommentServlet?method=2" method="post">
        	<textarea name="comment" cols="90" rows="5"></textarea>
        	<input type="submit" name="submit" class="submit" value="评论"/>
        	<input type="hidden" name="movId" value="<%=m.getId() %>"/>
        	</form>
     </div>
   </div>
</div>
</div>
</body>
</html>
