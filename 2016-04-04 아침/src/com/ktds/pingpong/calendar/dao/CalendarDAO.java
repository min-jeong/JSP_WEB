package com.ktds.pingpong.calendar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.pingpong.Const;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.util.xml.XML;

public class CalendarDAO {

	public int insertNotice(CalendarVO calendarVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/notice/insertNotice/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, calendarVO.getEventId());
			stmt.setString(2, calendarVO.getTitle());
			stmt.setString(3, calendarVO.getDescription());
			stmt.setString(4, calendarVO.getClassName());

			int result = stmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
