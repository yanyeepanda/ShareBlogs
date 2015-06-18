package com.share.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import com.jspsmart.upload.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import util.CountTime;
import util.IPTimeStamp;

import java.sql.SQLException;
import java.util.List;
import com.share.control.*;
import com.share.model.*;

public class MovieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
		int method = Integer.parseInt(request.getParameter("method"));
		switch (method) {
		case 1:
			this.addMovie(request, response);
			break;
		case 2:
			this.searchMovies(request, response);
			break;
		case 3:
			this.updateMovies(request, response);
			break;
		case 4:
			this.downloadMovie(request, response);
			break;
		case 5:
			this.deleteMovie(request, response);
			break;
			default:
				break;
		}
	}

	public void addMovie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = null;
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		} else {
			u = (User) request.getSession().getAttribute("user");
		}
		Movie m = new Movie();
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(100 * 1024 * 1024);
		su.setAllowedFilesList("torrent,avi,rmvb,rm,mp4,flv,bmp,jpg,png,gif");
		su.setTotalMaxFileSize(100 * 1024 * 1024);
		try {
			su.setDeniedFilesList("exe,bat,jsp,htm,html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IPTimeStamp its = new IPTimeStamp(request.getLocalAddr());
		for (int i = 0; i < su.getFiles().getCount(); i++) {
			String format = su.getFiles().getFile(i).getFileExt();
			String fileName = its.getIpTimeRand().substring(20, 30) + "."
					+ format;
			System.out.println(fileName);
			String url = this.getServletContext().getRealPath("/")
					+ "files\\movies" + java.io.File.separator + fileName;
			if (i == 0) {
				m.setFormat(format);
				m.setMovieUrl(url);
				int size = su.getFiles().getFile(i).getSize();
				System.out.println(size);
				m.setSize(size);// 文件大小
			} else {
				m.setImageUrl(url);
			}
			com.jspsmart.upload.File file = su.getFiles().getFile(i);
			if (file.isMissing())
				continue;
			try {
				file.saveAs(url);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String title = su.getRequest().getParameter("title");
		String director = su.getRequest().getParameter("director");
		int cateId = Integer.parseInt(su.getRequest().getParameter("category"));
		String actor = su.getRequest().getParameter("actor");
		String time = su.getRequest().getParameter("time");
		int movieLong = Integer.parseInt(su.getRequest().getParameter("long"));
		String synopsis = su.getRequest().getParameter("synopsis");
		m.setActor(actor);
		m.setCategory(cateId);
		m.setDirector(director);
		m.setMovieTime(movieLong);
		m.setProductTime(time);
		m.setSynopsis(synopsis);
		m.setTitle(title);
		m.setUserId(u.getId());

		if (MovieControl.addMovie(m, u.getId())) {
			System.out.println("上传电影成功");
			response.sendRedirect("movieList.jsp");
		} else {
			System.out.println("上传电影失败");
			response.sendRedirect("addMovie.jsp");
		}
	}

	public void searchMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
		String keyword = request.getParameter("keyword");
		List<Movie> listSearch = MovieControl.searchMovies(keyword);
		request.setAttribute("keyList", listSearch);
		this.getServletConfig().getServletContext().getRequestDispatcher(
				"/movieList.jsp").forward(request, response);
	}

	public void updateMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
		User a = null;
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
		} else {
			a = (User) request.getSession().getAttribute("user");
		}
		int mid = Integer.parseInt(request.getParameter("mid"));
		Movie m = MovieControl.getMovieById(mid);
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		int category = Integer.parseInt(request.getParameter("category"));
		String actor = request.getParameter("actor");
		String time = request.getParameter("time");
		System.out.println(time);
		int movlong = Integer.parseInt(request.getParameter("long"));
		String synopsis = request.getParameter("synopsis");
		m.setTitle(title);
		m.setCategory(category);
		m.setDirector(director);
		m.setActor(actor);
		m.setProductTime(time);
		m.setMovieTime(movlong);
		m.setSynopsis(synopsis);

		if (MovieControl.updateMovie(m)) {
			System.out.println("电影修改成功");
			response.sendRedirect("movieList.jsp");
		} else {
			System.out.println("电影修改失败");
			response.sendRedirect("updateMovie.jsp");
		}

	}

	public void downloadMovie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String url = request.getParameter("url");
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			mySmartUpload.initialize(this.getServletConfig(), request, response);
			mySmartUpload.setContentDisposition(null);
			mySmartUpload.downloadFile(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMovie(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
			int id=Integer.parseInt(request.getParameter("mid"));
			if(CommentControl.deleteMovCommentByMovId(id))
			{
				if(MovieControl.deleteMovie(id))
				{
					System.out.println("删除成功");
					response.sendRedirect("movieList.jsp");
				}
			}else
			{
				System.out.println("删除电影台评论失败");
			}
	}
}
