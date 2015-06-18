package com.share.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Encode;
import com.share.control.*;
import com.share.model.*;
public class UserLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String passwd=request.getParameter("password");
		if(username==null||"".equals(username)||(passwd==null)||"".equals(passwd))
		{
			out.print("<script language=javascript>alert('用户名和密码不能为空');history.go(-1);</script>");
			
		}else
		{
			User u=UserControl.getUserInfoByName(username);
			String passdata=u.getPassword();
			Encode enc=new Encode();
			passwd=enc.encodeByMD5(passwd);
			if(passdata.equals(passwd))
			{
				System.out.println("登陆成功");
				//传递user对象到mian.jsp
				request.getSession().setAttribute("user", u);
				response.sendRedirect("center.jsp");
			}else
			{
				response.sendRedirect("login.jsp");
			}
		}
	}

}
