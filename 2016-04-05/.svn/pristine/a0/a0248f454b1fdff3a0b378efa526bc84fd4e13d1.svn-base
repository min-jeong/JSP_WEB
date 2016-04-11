package com.ktds.pingpong.calendar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			stmt.setString(1, calendarVO.getTitle());
			stmt.setString(2, calendarVO.getDescription());
			stmt.setString(3, calendarVO.getClassName());
			stmt.setString(4, calendarVO.getStartDate());
			stmt.setString(5, calendarVO.getEndDate());
			stmt.setInt(6, calendarVO.getTeamId());
			/*stmt.setString(7, calendarVO.getEventId());*/

			int result = stmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	public List<CalendarVO> getCalNoticebyTeamId(int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			// article을 꺼내온다.
			String query = XML.getNodeString("//query/notice/getCalNoticebyTeamId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			
			rs = stmt.executeQuery();
			
			List<CalendarVO> calendars = new ArrayList<CalendarVO>();
			CalendarVO calendar = null;
			System.out.println("sdfsdfffdfd");
			
				while( rs.next() ){
				calendar = new CalendarVO();
				System.out.println("dddddd");
				calendar.setCalendarId(rs.getInt("CALENDAR_ID"));
				calendar.setTitle(rs.getString("TITLE"));
				calendar.setDescription(rs.getString("DESCRIPTION"));
				calendar.setClassName(rs.getString("CLASS_NAME"));
				calendar.setStartDate(rs.getString("START_DATE"));
				calendar.setEndDate(rs.getString("END_DATE"));
				calendars.add(calendar);
				
			}
				return calendars;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	
	public int getLatestCalendarId ( CalendarVO calendar ) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
		
				stmt.close();
				String query = XML.getNodeString("//query/notice/getLatestCalendarId/text()");
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				int calendarId = 0;

				if (rs.next()) {
					calendarId = rs.getInt(1);
				}

				rs.close();
				return calendarId;
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
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
