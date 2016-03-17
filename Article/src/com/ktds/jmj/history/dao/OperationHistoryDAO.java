package com.ktds.jmj.history.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.jmj.Const;
import com.ktds.jmj.history.vo.OperationHistoryVO;
import com.ktds.jmj.util.xml.XML;

public class OperationHistoryDAO {
	public void insertHistory ( OperationHistoryVO history ) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = XML.getNodeString("//query/operationHistory/insertHistory/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, history.getActionCode());
			stmt.setString(2, history.getDescription());
			stmt.setString(3, history.getIp());
			stmt.setString(4, history.getMemberId());
			stmt.setString(5, history.getUrl());
			stmt.setString(6, history.getEtc());
			
			stmt.executeUpdate();
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
	} //wirteArticle end
	
	
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
