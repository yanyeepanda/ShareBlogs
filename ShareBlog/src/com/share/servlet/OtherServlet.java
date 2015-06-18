package com.share.servlet;
import com.jspsmart.upload.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.CountTime;
import util.IPTimeStamp;

import java.sql.SQLException;
import java.util.List;
import com.share.control.*;
import com.share.model.*;
public class OtherServlet extends HttpServlet {

	
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
			this.addOthers(request, response);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
			default:
				break;
		}
		
	}
	
	public void addOthers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String title =request.getParameter("title");
		System.out.println(title);
		User u = null;
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		} else {
			u = (User) request.getSession().getAttribute("user");
		}
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
			String format = su.getFiles().getFile(0).getFileExt();
			System.out.println(format);
			String fileName = its.getIpTimeRand().substring(20, 30) + "."
					+ format;
			System.out.println(fileName);
			String url = this.getServletContext().getRealPath("/")
					+ "files\\wenku" + java.io.File.separator + fileName;
				int size = su.getFiles().getFile(0).getSize();
				System.out.println(size);
			com.jspsmart.upload.File file = su.getFiles().getFile(0);
			try {
				file.saveAs(url);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
