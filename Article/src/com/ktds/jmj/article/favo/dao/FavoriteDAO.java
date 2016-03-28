package com.ktds.jmj.article.favo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.jmj.Const;
import com.ktds.jmj.article.favo.vo.FavoVO;
import com.ktds.jmj.util.xml.XML;

public class FavoriteDAO {
	
	public int selectFavoriteCount(FavoVO favo){
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/favorite/selectFavoriteCount/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, favo.getArticleId()); // 끝나는 번호
			stmt.setString(2, favo.getMemberId()); // 시작하는 번호
			
			rs = stmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	public void insertFavorite(FavoVO favo) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/favorite/insertFavorite/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, favo.getArticleId()); // 끝나는 번호
			stmt.setString(2, favo.getMemberId()); // 시작하는 번호
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public void deleteFavorite(FavoVO favo){
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/favorite/deleteFavorite/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, favo.getArticleId()); // 끝나는 번호
			stmt.setString(2, favo.getMemberId()); // 시작하는 번호
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	
	
	/**
	 * Oracle Driver
	 */
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Close DB
	 */
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}


	
	
}
