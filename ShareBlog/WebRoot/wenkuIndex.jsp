<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
#list{
	width:630px;
	margin:0 auto;
	}
.movie{
	width:630px;
	height:160px;
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

<body>

<div id="list">
	<p>	<a href="wenkuList.jsp">查看所有资源</a></p>
	<div class="movie">
    <div class="img">
    <img src="./images/user.jpg"  height="70px" width="70px"/>
    </div>
    <div class="table">
	<table width="100%"  border="0">
        <tr class="ziti">
          <td height="34"><a href="">资源名</a></td>
        </tr>
        <tr class="ziti">
          <td>上传人</td>
        </tr>
        <tr class="time">
          <td>上传时间</td>
        </tr>
        <tr >
          <td height="50">
      </td>
        </tr>
        <tr class="ziti">
          <td height="21"><a>阅读() </a><a>|</a><a>评论()  </a><a>|</a><a href="">下载</a></td>
        </tr>
      </table>
  </div>
  </div>

</div>
<div id="foot"></div>
</body>
</html>
