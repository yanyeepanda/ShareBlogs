package com.share.control;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.share.model.*;
import dbconnect.*;
import util.CountTime;
public class CommentControl {
	
	/***
	 * �����������
	 * @param com
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addArticleComment(ArtComment com,int userId)
	{
		boolean success=false;
		String sql="insert into artComment(userId,[content],createTime,articleId)values(?,?,?,?)";
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, userId);
			dbc.setString(2, com.getContent());
			dbc.setString(3, CountTime.GetCurrentTime());
			dbc.setInt(4, com.getArticleId());
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
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteArtComment(int id)
	{
		boolean success=false;
		String sql="delete from artComment where id="+id;
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
	 * ��������idɾ�����µ���������
	 * @param ArtiId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteArtCommentByArtId(int ArtiId)
	{
		boolean success=false;
		String sql="delete from artComment where articleId="+ArtiId;
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
	 * ��������id������е�����
	 * @param artId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<ArtComment> queryArtComment(int artId)
	{
		List<ArtComment> list=new ArrayList<ArtComment>();
		String sql="select *  from artComment where articleId="+artId+"order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				ArtComment a=new ArtComment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setContent(rs.getString(3));
				a.setCreateTime(rs.getString(4));
				a.setArticleId(rs.getInt(5));
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
	 * ��ӵ�Ӱ����
	 * @param com
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addMovComment(MovComment mc,int userId)
	{
		boolean success=false;
		String sql="insert into movComment(userId,[content],createTime,movieId)values(?,?,?,?)";
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setInt(1, userId);
			dbc.setString(2, mc.getContent());
			dbc.setString(3, CountTime.GetCurrentTime());
			dbc.setInt(4, mc.getMovieId());
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
	 * ����idɾ����Ӱ����
	 * @param id
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteMovComment(int id)
	{
		boolean success=false;
		String sql="delete from movComment where id="+id;
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
	 * ���ݵ�Ӱidɾ����Ӱ����������
	 * @param ArtiId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean deleteMovCommentByMovId(int movId)
	{
		boolean success=false;
		String sql="delete from movComment where movieId="+movId;
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
	 * ���ݵ�Ӱid������е�����
	 * @param artId
	 * @return
	 */
	@SuppressWarnings("finally")
	public static List<MovComment> queryMovComment(int movId)
	{
		List<MovComment> list=new ArrayList<MovComment>();
		String sql="select *  from movComment where movieId="+movId+"order by id desc";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			rs=dbc.executeQuery();
			while(rs.next())
			{
				MovComment a=new MovComment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setContent(rs.getString(3));
				a.setCreateTime(rs.getString(4));
				a.setMovieId(rs.getInt(5));
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
		if(deleteArtComment(2))
		{
			System.out.println("ok");
		}
	}
}
