package com.share.control;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.share.model.*;

import dbconnect.*;
import util.CountTime;
public class MovieControl {
	/***
	 * 上传电影
	 * @param m
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addMovie(Movie m,int userId){
		boolean success=false;
		String sql="insert into movie(userId,movieUrl,category,format,size,count," +
				"title,productTime,movieTime,director,actor,synopsis,imageUrl," +
				"updateTime)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, userId);
			dbc.setString(2, m.getMovieUrl());
			dbc.setInt(3, m.getCategory());
			dbc.setString(4, m.getFormat());
			dbc.setInt(5, m.getSize());
			dbc.setInt(6,0);
			dbc.setString(7,m.getTitle());
			dbc.setString(8, m.getProductTime());
			dbc.setInt(9, m.getMovieTime());
			dbc.setString(10, m.getDirector());
			dbc.setString(11, m.getActor());
			dbc.setString(12, m.getSynopsis());
			dbc.setString(13, m.getImageUrl());
			dbc.setString(14, CountTime.GetCurrentTime());
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
	 * 获得电影分类
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<MovCategory> queryCategory()
	{
		List<MovCategory> list=new ArrayList<MovCategory>();
		String sql="select *  from movieCategory order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				MovCategory mc=new MovCategory();
				mc.setId(rs.getInt(1));
				mc.setCategory(rs.getString(2));
				list.add(mc);
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
	
	/***
	 * 获得所有电影
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Movie> queryMovieAll()
	{
		List<Movie> list=new ArrayList<Movie>();
		String sql="select *  from movie order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setUserId(rs.getInt(2));
				m.setMovieUrl(rs.getString(3));
				m.setCategory(rs.getInt(4));
				m.setFormat(rs.getString(5));
				m.setSize(rs.getInt(6));
				m.setCount(rs.getInt(7));
				m.setTitle(rs.getString(8));
				m.setProductTime(rs.getString(9));
				m.setMovieTime(rs.getInt(10));
				m.setDirector(rs.getString(11));
				m.setActor(rs.getString(12));
				m.setSynopsis(rs.getString(13));
				m.setImageUrl(rs.getString(14));
				m.setUpdateTime(rs.getString(15));
				list.add(m);
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
	 * 根据id获得所有电影
	 * @return
	 */
	@SuppressWarnings("finally")
	public static Movie getMovieById(int id)
	{
		Movie m=null;
		String sql="select *  from movie where id="+id;
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			if(rs.next())
			{
				m=new Movie();
				m.setId(rs.getInt(1));
				m.setUserId(rs.getInt(2));
				m.setMovieUrl(rs.getString(3));
				m.setCategory(rs.getInt(4));
				m.setFormat(rs.getString(5));
				m.setSize(rs.getInt(6));
				m.setCount(rs.getInt(7));
				m.setTitle(rs.getString(8));
				m.setProductTime(rs.getString(9));
				m.setMovieTime(rs.getInt(10));
				m.setDirector(rs.getString(11));
				m.setActor(rs.getString(12));
				m.setSynopsis(rs.getString(13));
				m.setImageUrl(rs.getString(14));
				m.setUpdateTime(rs.getString(15));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m=null;
		}finally
		{
			dbc.close();
			return m;
		}
	}
	
	/***
	 * 根据分类获得电影
	 * @param cateId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Movie> queryMovieByCateg(int cateId)
	{
		List<Movie> list=new ArrayList<Movie>();
		String sql="select *  from  movie where category="+cateId+" order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setUserId(rs.getInt(2));
				m.setMovieUrl(rs.getString(3));
				m.setCategory(cateId);
				m.setFormat(rs.getString(5));
				m.setSize(rs.getInt(6));
				m.setCount(rs.getInt(7));
				m.setTitle(rs.getString(8));
				m.setProductTime(rs.getString(9));
				m.setMovieTime(rs.getInt(10));
				m.setDirector(rs.getString(11));
				m.setActor(rs.getString(12));
				m.setSynopsis(rs.getString(13));
				m.setImageUrl(rs.getString(14));
				m.setUpdateTime(rs.getString(15));
				list.add(m);
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
	 * 根据关键字查找
	 * @param keyword
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Movie> searchMovies(String keyword)
	{
		List<Movie> list=new ArrayList<Movie>();
		String sql="select * from movie where title like '%"+keyword+"%'";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Movie m=new Movie();
				m.setId(rs.getInt(1));
				m.setUserId(rs.getInt(2));
				m.setMovieUrl(rs.getString(3));
				m.setCategory(rs.getInt(4));
				m.setFormat(rs.getString(5));
				m.setSize(rs.getInt(6));
				m.setCount(rs.getInt(7));
				m.setTitle(rs.getString(8));
				m.setProductTime(rs.getString(9));
				m.setMovieTime(rs.getInt(10));
				m.setDirector(rs.getString(11));
				m.setActor(rs.getString(12));
				m.setSynopsis(rs.getString(13));
				m.setImageUrl(rs.getString(14));
				m.setUpdateTime(rs.getString(15));
				list.add(m);
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
	 * 根据id修改电影
	 * @param a
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean updateMovie(Movie m)
	{
		boolean success=false;
		String sql="update movie set category=?,title=?,productTime=?," +
				"movieTime=?,director=?, actor=?, synopsis=?, updateTime=? where id=?";
		DBConnect dbc=new DBConnect(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, m.getCategory());
			dbc.setString(2, m.getTitle());
			dbc.setString(3, m.getProductTime());
			dbc.setInt(4,m.getMovieTime());
			dbc.setString(5, m.getDirector());
			dbc.setString(6, m.getActor());
			dbc.setString(7, m.getSynopsis());
			dbc.setString(8, CountTime.GetCurrentTime());
			dbc.setInt(9, m.getId());
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
	 * 根据电影id获得分类
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String getCategory(int id)
	{
		String category=null;
		String sql="select *  from movieCategory where id="+id;
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
	
	/**
	 * 删除电影
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteMovie(int id)
	{
		boolean success=false;
		String sql="delete from movie where id="+id;
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
	
	public static void main(String args[])
	{
		List<Movie> list=queryMovieAll();
		for(int i=0;i<list.size();i++)
		{
			//System.out.println(list.get(i).getImageUrl());
			//System.out.println(list.get(i).getUpdateTime());
		}
	}
}
