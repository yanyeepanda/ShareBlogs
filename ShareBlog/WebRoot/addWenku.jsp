<%@ page language="java" import="java.util.*" pageEncoding="gb2312" contentType="text/html; charset=gb2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源上传</title>

<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css"/>
<script type="text/javascript" src="uploadify/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="uploadify/swfobject.js"></script>  
<script type="text/javascript" src="uploadify/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript" src="uploadify/wxhlJQyery.uploadify.js"></script>

<script type="text/javascript" src="js/jquery-1.7.js" language="javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#submit").click(function(){
			if($('#title').val().length==0){
				alert("资源名不能为空");
			}
			else if($('#content').val().length==0)
			{
				alert("资源描述不能为空");
			}
			else if($('#file').val().length==0)
			{
				alert("请选择文件");
			}
		});
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
	margin-left:55px;
}
#navigation ul li a{
	display:block;
	line-height:35px;
	text-decoration:none;
}
#navigation ul li a:hover{
	color:#3078AB;
	}
p{
	margin-top:5px;
}
.float-right{
	font-size:16px;
	float:right;
	margin-right:180px;
	margin-top:10px;
}
#add{
	width:600px;
	margin-top:20px;
	float:left;
	margin-left:250px;
	margin-right:auto;
}
#main{
	width:600px;
	background-color:#F3FAFF;
	height:240px;
}
</style>

</head>

<body>
<div id="navigation">
	<ul>
    	<li><a href="">全部</a></li>
    	<li><a href="">DOC</a></li>
        <li><a href="">PDF</a></li>
        <li><a href="">PPT</a></li>
        <li><a href="">XLS</a></li>
        <li><a href="">TXT</a></li>
	</ul>
</div>
<a href="" class="float-right">返回文库列表</a>

<div id="add">
<table width="600">
<tr>
<td width="80%"><h2>上传文件</h2></td>
</tr></table>

	<div id="main">
	<form action="OtherServlet?method=1" method="post" enctype="multipart/form-data">
	<table width="100%" border="0">
  <tr>
    <td width="18%" height="36">资源名：</td>
    <td width="82%"><input type="text" id="title" name="title" value="" style="width:400px; height:20px "/></td>
  </tr>
  <tr>
    <td height="95">资源描述：</td>
    <td><textarea id="content" cols="55" rows="5"></textarea></td>
  </tr>
    <tr>
    <td height="41">添加资源：</td>
    <td><input type="file" name="address" id="file" value="" style="width:400px; height:30px "/></td>
  </tr>
  <tr>
  	<td><input  type="button" id="submit" name="upload" value="上传" style="width:80px; background-color:#3469C7" /></td>
    <td><input type="button"value="重置" style="width:80px; background-color:#D6D6D6" /></td>
  </tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>
