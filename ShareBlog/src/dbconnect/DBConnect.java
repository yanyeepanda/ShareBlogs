package dbconnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 *数据库连接对象
 * @author: zhangm
 * 
 */

public class DBConnect {

	private Connection conn = null;

	private Statement stmt = null;

	private PreparedStatement prepstmt = null;
	
	private CallableStatement prepCall =null;

	/**
	 * 初始化数据库连接
	 *
	 */
	void init() {
		conn = Proxool.getInstance().getConnection();
	}
	/**
	 * 构造数据库的连接和访问类
	 */
	public DBConnect() {
		init();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public DBConnect(String sql,int i) {
		init();
		try {
			stmt = conn.createStatement();
			this.prepCall = conn.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DBConnect(int resultSetType, int resultSetConcurrency) {
		init();
		try {
			stmt = conn.createStatement(resultSetType, resultSetConcurrency);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 构造数据库的连接和访问类 预编译SQL语句
	 * 
	 * @param sql
	 */
	public DBConnect(String sql) { 
		init();
		try {
			this.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 带有设置ResultSet类型的构造函数
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 */
	public DBConnect(String sql, int resultSetType, int resultSetConcurrency) {
		init();
		try {
			this.prepareStatement(sql, resultSetType, resultSetConcurrency);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回一个数据库连接
	 * 
	 * @return Connection 连接
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * 设置数据库是否自动提交
	 * 
	 * @param autoCommit<br>
	 * 当为<code>TRUE</code>自动提交，默认情况为此<br>
	 * 当为<code>false</code>的时候，数据库连接部位自动提交，需要手工提交
	 */
	public void setAutoCommit(boolean autoCommit) {
		try {
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当数据库的自动提交为false的时候，手工提交事务
	 * 
	 */
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当数据库更新失败的时候，数据回滚
	 * 
	 */
	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * PreparedStatement
	 * 
	 * @return sql 预设SQL语句
	 */
	public void prepareStatement(String sql) {
		try {
			prepstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * SQL预编译语句
	 * 
	 * @param sql
	 *            对应的SQL语句
	 * @param resultSetType
	 *            ResultSet对应的类型
	 * @param resultSetConcurrency
	 * 
	 */
	public void prepareStatement(String sql, int resultSetType, int resultSetConcurrency) {
		try {
			prepstmt = conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置对应值
	 * 
	 * @param index
	 *            参数索引
	 * @param value
	 *            对应值
	 */
	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setShort(int index, Short value) throws SQLException {
		prepstmt.setShort(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setBytes(int index, byte[] value) throws SQLException {
		prepstmt.setBytes(index, value);
	}

	public void clearParameters() throws SQLException {
		prepstmt.clearParameters();
		prepstmt = null;
	}

	/**
	 * 返回预设状态
	 */
	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	public CallableStatement getPrepCall() {
		return prepCall;
	}	
	/**
	 * 返回状态
	 * 
	 * @return Statement 状态
	 */
	public Statement getStatement() {
		return stmt;
	}

	/**
	 * 执行SQL语句返回字段集
	 * 
	 * @param sql
	 *            SQL语句
	 * @return ResultSet 字段集
	 */

	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else
			return null;
	}

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @return true 如果语句执行成功<br>
	 *         false 如果没有语句执行，或者出现异常就出现了SQLException
	 * 
	 * @throws SQLException
	 */
	public boolean executeUpdate(String sql) throws SQLException {
		if (stmt != null)
			if (stmt.executeUpdate(sql) >= 0)
				return true;
		return false;
	}
	/**
	 * 执行Prepared-SQL语句
	 * 
	 * @return true  如果语句执行成功<br>
	 *         false 如果没有语句执行，或者出现异常就出现了SQLException
	 * 
	 * @throws SQLException
	 */
	public boolean executeUpdate() throws SQLException {
		if (prepstmt != null)
			if (prepstmt.executeUpdate() >= 0)
				return true;
		return false;
	}
	
	
	/**
	 * 关闭数据库连接
	 */
	public void close() {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (prepstmt != null) {
				prepstmt.close();
				prepstmt = null;
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 关闭Statement
	 * 
	 * @param sm
	 */
	public void close(Statement sm) {
		try {
			if (sm != null)
				sm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭PreparedStatement
	 * 
	 * @param ptm
	 */
	public void close(PreparedStatement ptm) {
		try {
			if (ptm != null)
				ptm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param rs
	 */
	public void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}