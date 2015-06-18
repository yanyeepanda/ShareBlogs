package com.share.control;
import java.sql.ResultSet;

import com.share.model.User;
import dbconnect.*;
public class UserControl {
	
	/***
	 * 添加一个用户
	 * @param u
	 * @return
	 */
	@SuppressWarnings("finally")
	public static boolean addUser(User u)
	{
		String sql="insert into [user](name,password,email,imagUrl,format)values(?,?,?,?,?)";
		boolean success=false;
		DBConnect dbc=new DBConnect();
		dbc.prepareStatement(sql);
		try {
			dbc.setString(1, u.getName());
			dbc.setString(2, u.getPassword());
			dbc.setString(3, u.getEmail());
			dbc.setString(4, u.getImagUrl());
			dbc.setString(5, u.getFormat());
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
	
	@SuppressWarnings("finally")
	public static boolean checkUserName(String name)
	{
		boolean success=false;
		String sql="select * from [user] where name=?";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		try {
			dbc.setString(1, name);
			rs=dbc.executeQuery();
			if(rs.next())
			{
				rs.first();
				if(rs.getInt(1)>0)
				{
					success=true;
				}
			}
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
	 * 根据用户名返回用户信息
	 * @param uname
	 * @return
	 */
	@SuppressWarnings("finally")
	public static User getUserInfoByName(String uname)
	{
		String sql="select * from [user] where name=?";
		DBConnect dbc = new DBConnect(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=null;
		User u=null;
		try {
			dbc.setString(1, uname);
			rs=dbc.executeQuery();
			while(rs.next()){
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
	public static void main(String args[])
	{
		User u=UserControl.getUserInfoByName("adsmin");
		System.out.println(u.getPassword());
	}
}

