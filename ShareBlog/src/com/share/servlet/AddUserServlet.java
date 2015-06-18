package com.share.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.*;
import com.share.model.*;
import com.share.control.*;
import util.*;
public class AddUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			SmartUpload su=new SmartUpload();
			try {
				su.initialize(this.getServletConfig(),request,response);
				su.setMaxFileSize(1000000);
				su.setAllowedFilesList("jpg,gif,png");
				su.upload();
				String username=su.getRequest().getParameter("username");
				String password=su.getRequest().getParameter("password");
				String ConfirmPass=su.getRequest().getParameter("ConfirmPass");
				String email=su.getRequest().getParameter("email");
				IPTimeStamp its=new IPTimeStamp(request.getLocalAddr());
				String format=su.getFiles().getFile(0).getFileExt();//扩展名
				System.out.println(format);
				String fileName=its.getIpTimeRand()+"."+format;
				String url=this.getServletContext().getRealPath("/")+"files\\touxiang"+java.io.File.separator+fileName;
				if(UserControl.checkUserName(username))
				{
					out.print("<script language=javascript>alert('该用户已存在！');history.go(-1);</script>");
				}
				if(!ConfirmPass.equals(password))
				{
					out.print("<script language=javascript>alert('两次输入密码不一致！');history.go(-1);</script>");
				}
				//if(!su.getFiles().getFile(0).getFieldName().matches("^\\w+(jpg|gif|png)$"))
				//{
				//	out.print("<script language=javascript>alert('头像格式不正确！');history.go(-1);</script>");
				//}
				su.getFiles().getFile(0).saveAs(url);
				Encode encode=new Encode();
				password=encode.encodeByMD5(password);
				User u =new User();
				u.setName(username);
				u.setPassword(password);
				u.setEmail(email);
				u.setImagUrl(url);
				u.setFormat(format);
				if(UserControl.addUser(u))
				{
					System.out.println("okokok");
					response.sendRedirect("login.jsp");
				}else
				{
					out.print("<script language=javascript>alert('注册失败！');history.go(-1);</script>");
				}
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				out.close();
			}
			
	}
}
