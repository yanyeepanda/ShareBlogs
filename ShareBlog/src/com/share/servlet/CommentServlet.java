package com.share.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.share.control.*;
import com.share.model.ArtComment;
import com.share.model.*;
public class CommentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
		int method=Integer.parseInt(request.getParameter("method"));
		switch(method)
		{
		case 1:
			this.articleComm(request, response);
			break;
		case 2:
			this.MovieComm(request, response);
			break;
		case 3:
			
			break;
		case 4:
			
			break;
			default:
				break;
		}
		
	}
	
	public void articleComm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User u=null;
		if(request.getSession().getAttribute("user")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}else{
			u=(User)request.getSession().getAttribute("user");
		}
		String comment=request.getParameter("comment");
		int artId=Integer.parseInt(request.getParameter("artId"));
		ArtComment ac=new ArtComment();
		ac.setArticleId(artId);
		ac.setContent(comment);
		ac.setUserId(u.getId());
		if(CommentControl.addArticleComment(ac, u.getId()))
		{
			System.out.println("添加文章回复成功");
		}
		request.setAttribute("aid", artId);
		this.getServletConfig().getServletContext().getRequestDispatcher("/articleDetail.jsp").forward(request, response);
	}
	
	public void MovieComm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User u=null;
		if(request.getSession().getAttribute("user")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}else{
			u=(User)request.getSession().getAttribute("user");
		}
		String comment=request.getParameter("comment");
		int movId=Integer.parseInt(request.getParameter("movId"));
		MovComment mc=new MovComment();
		mc.setMovieId(movId);
		mc.setContent(comment);
		mc.setUserId(u.getId());
		if(CommentControl.addMovComment(mc, u.getId()))
		{
			System.out.println("添加文章回复成功");
		}
		request.setAttribute("mid", movId);
		this.getServletConfig().getServletContext().getRequestDispatcher("/movieDetail.jsp").forward(request, response);
	}

}
