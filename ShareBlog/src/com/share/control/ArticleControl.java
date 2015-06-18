package com.share.control;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.share.model.*;
import dbconnect.*;
import util.CountTime;
public class ArticleControl {
	
	/**
	 * 添加博文
	 * @param a
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addArticle(Article a,int userId)
	{
		boolean success=false;
		String sql="insert into article(userId,title,category,createTime,[content],count)values(?,?,?,?,?,?)";
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, userId);
			dbc.setString(2, a.getTitle());
			dbc.setInt(3, a.getCategory());
			dbc.setString(4,CountTime.GetCurrentTime());
			dbc.setString(5, a.getContent());
			dbc.setInt(6, 0);
			success=dbc.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			dbc.close();
			return success;
		}
	}
	/***
	 * 获得文章分类
	 * 
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<ArtCategory> queryCategory()
	{
		List<ArtCategory> list=new ArrayList<ArtCategory>();
		String sql="select *  from artCategory order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				ArtCategory ag=new ArtCategory();
				ag.setId(rs.getInt(1));
				ag.setCategory(rs.getString(2));
				list.add(ag);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			list=null;
		}finally{
			dbc.close();
			return list;
		}
	}
	
	/**
	 * 根据文章id获得分类
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String getCategory(int id)
	{
		String category=null;
		String sql="select *  from artCategory where id="+id;
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			if(rs.next())
			{
				category=rs.getString(2);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			category=null;
		}finally{
			dbc.close();
			return category;
		}
	}
	
	
	/***
	 * 取得所有的文章
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Article> queryArticleAll()
	{
		List<Article> list=new ArrayList<Article>();
		String sql="select *  from article order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Article a=new Article();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setCategory(rs.getInt(4));
				a.setCreateTime(rs.getString(5));
				a.setContent(rs.getString(6));
				a.setCount(rs.getInt(7));
				list.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			list=null;
		}finally
		{
			dbc.close();
			return list;
		}
	}
	
	/***
	 * 根据分类得到文章
	 * @param cateId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Article> queryArticleByCategory( int cateId)
	{
		List<Article> list=new ArrayList<Article>();
		String sql="select *  from article where category="+cateId+"order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Article a=new Article();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setCategory(rs.getInt(4));
				a.setCreateTime(rs.getString(5));
				a.setContent(rs.getString(6));
				a.setCount(rs.getInt(7));
				list.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			list=null;
		}finally
		{
			dbc.close();
			return list;
		}
	}
	
	/***
	 * 根据id得到文章
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static Article queryArticleById( int id)
	{	Article a=null;
		String sql="select *  from article where id="+id;
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			if(rs.next())
			{
				a=new Article();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setCategory(rs.getInt(4));
				a.setCreateTime(rs.getString(5));
				a.setContent(rs.getString(6));
				a.setCount(rs.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			a=null;
		}finally
		{
			dbc.close();
			return a;
		}
	}
	
	/***
	 * 根据文章id查作者
	 * @param artId
	 * @return
	 */
	
	@SuppressWarnings("finally")
	public static User getAuthor(int artuId)
	{
		User u=null;
		String sql="select *  from [user] where [user].id="+artuId;
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setImagUrl(rs.getString(5));
				u.setFormat(rs.getString(6));		
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			u=null;
		}finally
		{
			dbc.close();
			return u;
		}
	}
	
	/***
	 * 根据id修改文章
	 * @param a
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean updateArticle(Article a)
	{
		boolean success=false;
		String sql="update article set title=?,category=?,createTime=?,content=? where id=?";
		DBConnect dbc=new DBConnect(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		dbc.prepareStatement(sql);
		try {
			dbc.setString(1, a.getTitle());
			dbc.setInt(2, a.getCategory());
			dbc.setString(3, CountTime.GetCurrentTime());
			dbc.setString(4, a.getContent());
			dbc.setInt(5, a.getId());
			success=dbc.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			dbc.close();
			return success;
		}
	}
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteArticle(int id)
	{
		boolean success=false;
		String sql="delete from article where id="+id;
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			success=dbc.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			dbc.close();
			return success;
		}
	}
	
	/***
	 * 根据关键字查找
	 * @param keyword
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Article> searchArticles(String keyword)
	{
		List<Article> list=new ArrayList<Article>();
		String sql="select * from article where title like '%"+keyword+"%'";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Article a=new Article();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setCategory(rs.getInt(4));
				a.setCreateTime(rs.getString(5));
				a.setContent(rs.getString(6));
				a.setCount(rs.getInt(7));
				list.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			list=null;
		}finally
		{
			dbc.close();
			return list;
		}
	}
	
	public static void main(String args[])
	{
		//System.out.println(searchArticles("麦迪").get(0).getTitle());
	}
}
