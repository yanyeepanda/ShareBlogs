package com.share.control;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.share.model.*;

import dbconnect.*;
import util.CountTime;
public class OtherControl {
	
	/**
	 * 添加资源
	 * @param a
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addOther(Others o,int userId)
	{
		boolean success=false;
		String sql="insert into others(userId,category,title,synopsis,fileUrl,uploadTime," +
				"size,format,count)values(?,?,?,?,?,?,?,?,?)";
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, userId);
			dbc.setInt(2, o.getCategory());
			dbc.setString(3, o.getTitle());
			dbc.setString(4,o.getSynopsis());
			dbc.setString(5,o.getFileUrl());
			dbc.setString(6, CountTime.GetCurrentTime());
			dbc.setInt(7, o.getSize());
			dbc.setString(8, o.getFormat());
			dbc.setInt(9,o.getCount());
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
	 * 获得资源分类
	 * 
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<OthCategory> queryCategory()
	{
		List<OthCategory> list=new ArrayList<OthCategory>();
		String sql="select *  from othCategory order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				OthCategory ag=new OthCategory();
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
	 * 根据资料id获得分类
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String getCategory(int id)
	{
		String category=null;
		String sql="select *  from othCategory where id="+id;
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
	 * 取得所有的资源
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Others> queryOthersAll()
	{
		List<Others> list=new ArrayList<Others>();
		String sql="select *  from others order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Others oth=new Others();
				oth.setId(rs.getInt(1));
				oth.setUserId(rs.getInt(2));
				oth.setCategory(rs.getInt(3));
				oth.setTitle(rs.getString(4));
				oth.setSynopsis(rs.getString(5));
				oth.setFileUrl(rs.getString(6));
				oth.setUploadTime(rs.getString(7));
				oth.setId(rs.getInt(8));
				oth.setFormat(rs.getString(9));
				oth.setCount(rs.getInt(10));
				list.add(oth);
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
	 * 根据分类得到资源
	 * @param cateId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<Others> queryOthersByCategory( int cateId)
	{
		List<Others> list=new ArrayList<Others>();
		String sql="select *  from others where category="+cateId+"order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Others oth=new Others();
				oth.setId(rs.getInt(1));
				oth.setUserId(rs.getInt(2));
				oth.setCategory(rs.getInt(3));
				oth.setTitle(rs.getString(4));
				oth.setSynopsis(rs.getString(5));
				oth.setFileUrl(rs.getString(6));
				oth.setUploadTime(rs.getString(7));
				oth.setId(rs.getInt(8));
				oth.setFormat(rs.getString(9));
				oth.setCount(rs.getInt(10));
				list.add(oth);
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
	 * 根据id得到资源
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static Others queryOthersById( int id)
	{	Others oth=null;
		String sql="select *  from others where id="+id;
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			if(rs.next())
			{
				oth=new Others();
				oth.setId(rs.getInt(1));
				oth.setUserId(rs.getInt(2));
				oth.setCategory(rs.getInt(3));
				oth.setTitle(rs.getString(4));
				oth.setSynopsis(rs.getString(5));
				oth.setFileUrl(rs.getString(6));
				oth.setUploadTime(rs.getString(7));
				oth.setId(rs.getInt(8));
				oth.setFormat(rs.getString(9));
				oth.setCount(rs.getInt(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			oth=null;
		}finally
		{
			dbc.close();
			return oth;
		}
	}
	
	/**
	 * 删除资源
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteOthers(int id)
	{
		boolean success=false;
		String sql="delete from others where id="+id;
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
	public static List<Others> searchOthers(String keyword)
	{
		List<Others> list=new ArrayList<Others>();
		String sql="select * from others where title like '%"+keyword+"%'";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				Others oth=new Others();
				oth.setId(rs.getInt(1));
				oth.setUserId(rs.getInt(2));
				oth.setCategory(rs.getInt(3));
				oth.setTitle(rs.getString(4));
				oth.setSynopsis(rs.getString(5));
				oth.setFileUrl(rs.getString(6));
				oth.setUploadTime(rs.getString(7));
				oth.setId(rs.getInt(8));
				oth.setFormat(rs.getString(9));
				oth.setCount(rs.getInt(10));
				list.add(oth);
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
}
