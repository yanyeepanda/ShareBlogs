package com.share.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CountTime;

import com.share.control.*;
import com.share.model.Article;
public class ArticleServlet extends HttpServlet {

	
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
			this.addArticle(request, response);
			break;
		case 2:
			this.updateArticle(request, response);
			break;
		case 3:
			this.deleteArticle(request, response);
			break;
		case 4:
			this.searchArticles(request, response);
			break;
			default:
				break;
		}
	}
	
	public void addArticle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		int userId=Integer.parseInt(request.getParameter("uid"));
		String title=request.getParameter("title");
		int category=Integer.parseInt(request.getParameter("category"));
		String content=request.getParameter("content");
		content.replaceAll("<br>", "\n");
		if(userId!=0&&category!=0)
		{
			if(title!=null&&!"".equals(title))
			{
				if(content!=null&&!"".equals(content))
				{
					Article a=new Article();
					a.setUserId(userId);
					a.setCategory(category);
					a.setTitle(title);
					a.setContent(content);
					a.setCount(0);
					if(ArticleControl.addArticle(a, userId))
					{
						System.out.println("添加文章成功");
						response.sendRedirect("articleList.jsp");
					}else
					{
						System.out.println("添加文章失败");
						response.sendRedirect("writeArtcle.jsp");
					}
				}
			}
		}
		
	}
	
	public void updateArticle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
			int aid=Integer.parseInt(request.getParameter("aid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			int cateId=Integer.parseInt(request.getParameter("category"));
			int count=Integer.parseInt(request.getParameter("count"));
			String title=request.getParameter("title");
			String cont=request.getParameter("content");
			
			Article a=new Article();
			a.setId(aid);
			a.setUserId(uid);
			a.setCategory(cateId);
			a.setTitle(title);
			a.setContent(cont);
			a.setCount(count);
			a.setCreateTime(CountTime.GetCurrentTime());
			
			if(ArticleControl.updateArticle(a))
			{
				System.out.println("修改成功");
				response.sendRedirect("articleList.jsp");
			}
		}
	
	public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
			int id=Integer.parseInt(request.getParameter("aid"));
			if(CommentControl.deleteArtCommentByArtId(id))
			{
				if(ArticleControl.deleteArticle(id))
				{
					System.out.println("删除成功");
					response.sendRedirect("articleList.jsp");
				}
			}else
			{
				System.out.println("删除文章评论失败");
			}
	}
	
	public void searchArticles(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("gb2312");
			String keyword=request.getParameter("keyword");
			List<Article> listSearch=ArticleControl.searchArticles(keyword);
			request.setAttribute("keyList",listSearch);
			this.getServletConfig().getServletContext().getRequestDispatcher("/articleList.jsp").forward(request, response);
	}
}
