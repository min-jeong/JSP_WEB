package com.ktds.pingpong.calendar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.pingpong.Const;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.util.DateFormatter;
import com.ktds.pingpong.util.xml.XML;

public class CalendarDAO {

	public int insertNoticesbyChatVO(List<ChatVO> noticeList, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/notice/insertNoticesbyChatVO/text()");
			stmt = conn.prepareStatement(query);

			//4개
			for(int i = 0 ; i < noticeList.size() ; i++ ){
				stmt.setString(1, noticeList.get(i).getDescription());
				System.out.println("공지날짜"+noticeList.get(i).getChatDate());
				stmt.setString(2, DateFormatter.parseNoticeDate(noticeList.get(i).getChatDate()));
				stmt.setString(3, DateFormatter.parseNoticeDate(noticeList.get(i).getChatDate()));
		//		stmt.setString(3, noticeList.get(i).getChatDate());
				stmt.setInt(4, teamId);
				
				result = stmt.executeUpdate();
			}
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
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
			System.out.println("공지 쿼리 가져오기 전");
			
				while( rs.next() ){
				calendar = new CalendarVO();
				calendar.setCalendarId(rs.getInt("CALENDAR_ID"));
				calendar.setTitle(rs.getString("TITLE"));
				calendar.setDescription(rs.getString("DESCRIPTION"));
				calendar.setClassName(rs.getString("CLASS_NAME"));
				calendar.setStartDate(rs.getString("START_DATE"));
				calendar.setEndDate(rs.getString("END_DATE"));
				calendars.add(calendar);
			}
				System.out.println("쿼리값 다 가져옴");
				return calendars;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
		}
		
	}
	public int removeByTeamId(int teamId) {
		int insertCount = 0;
		
	      loadOracleDriver();
	      
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      
	      try {
	    	  
	         conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
	         
	         String query = XML.getNodeString("//query/notice/removeByTeamId/text()");
	         stmt = conn.prepareStatement(query);
	         
	         stmt.setInt(1, teamId);
	         
	         insertCount = stmt.executeUpdate();
	         
	         if( insertCount > 0 ){
	            stmt.close();
	            System.out.println("삭제 성공");
	         }
	         return insertCount;
	         
	      } catch (SQLException e) {
	         throw new RuntimeException(e.getMessage(),e);
	      } finally {
	         closeDB(conn, stmt, null);
	      }
		
	}

	public int removeByCalendarId(int calendarId) {
	      
			int insertCount = 0;
			
	      loadOracleDriver();
	      
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      
	      try {
	    	  
	         conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
	         
	         String query = XML.getNodeString("//query/notice/removeByCalendarId/text()");
	         stmt = conn.prepareStatement(query);
	         
	         stmt.setInt(1, calendarId);
	         
	         insertCount = stmt.executeUpdate();
	         
	         if( insertCount > 0 ){
	            stmt.close();
	            System.out.println("삭제 성공");
	         }
	         return insertCount;
	         
	      } catch (SQLException e) {
	         throw new RuntimeException(e.getMessage(),e);
	      } finally {
	         closeDB(conn, stmt, null);
	      }
	   }
	
	public int updateNotice(CalendarVO changedNotice) {
		System.out.println("updateNotice 메소드 실행");
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
		
			String query = "";
			if ( changedNotice.getTitle() != null && changedNotice.getTitle().length() > 0 ) {
				
				if ( changedNotice.getDescription() != null && changedNotice.getDescription().length() > 0 ) {
					 
					 if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
						 
						 query = XML.getNodeString("//query/notice/updateAllNotice/text()");
					 }
					 else {
						 query = XML.getNodeString("//query/notice/updateTitleAndDescription/text()");
					 }
				}
				else {
					if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
						query = XML.getNodeString("//query/notice/updateTitleAndClassName/text()");
					}
					else {
						query = XML.getNodeString("//query/notice/updateOnlyTitle/text()");
					}
				}
			}
			else {
				if ( changedNotice.getDescription() != null && changedNotice.getDescription().length() > 0 ) {
					
					if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
						query = XML.getNodeString("//query/notice/updateDescriptionAndClassName/text()");
					}
					else {
						query = XML.getNodeString("//query/notice/updateOnlyDescription/text()");
					}
				}
				else {
					if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
						query = XML.getNodeString("//query/notice/updateOnlyClassName/text()");
					}
				}
			}
			
			stmt = conn.prepareStatement(query);
			
				if ( changedNotice.getTitle() != null && changedNotice.getTitle().length() > 0 ) {
					
					if ( changedNotice.getDescription() != null && changedNotice.getDescription().length() > 0 ) {
						 
						 if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
							 
							 	stmt.setString(1, changedNotice.getTitle());
								stmt.setString(2, changedNotice.getDescription());
								stmt.setString(3, changedNotice.getClassName());
								stmt.setInt(4, changedNotice.getCalendarId());
						 }
						 else {
							 	stmt.setString(1, changedNotice.getTitle());
								stmt.setString(2, changedNotice.getDescription());
								stmt.setInt(3, changedNotice.getCalendarId());
						 }
					}
					else {
						if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
							stmt.setString(1, changedNotice.getTitle());
							stmt.setString(2, changedNotice.getClassName());
							stmt.setInt(3, changedNotice.getCalendarId());
						}
						else {
							stmt.setString(1, changedNotice.getTitle());
							stmt.setInt(2, changedNotice.getCalendarId());
						}
					}
				}
				else {
					if ( changedNotice.getDescription() != null && changedNotice.getDescription().length() > 0 ) {
						
						if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
							stmt.setString(1, changedNotice.getDescription());
							stmt.setString(2, changedNotice.getClassName());
							stmt.setInt(3, changedNotice.getCalendarId());
						}
						else {
							stmt.setString(1, changedNotice.getDescription());
							stmt.setInt(2, changedNotice.getCalendarId());
						}
					}
					else {
						if ( changedNotice.getClassName() != null && changedNotice.getClassName().length() > 0 ) {
							stmt.setString(1, changedNotice.getClassName());
							stmt.setInt(2, changedNotice.getCalendarId());
						}
					}
				}
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public CalendarVO getCalNoticebyCalendarId(int calendarId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			// article을 꺼내온다.
			String query = XML.getNodeString("//query/notice/getCalNoticebyCalendarId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, calendarId);
			
			rs = stmt.executeQuery();
			
			CalendarVO calendar = null;
				while( rs.next() ){
				calendar = new CalendarVO();
				
				calendar.setCalendarId(rs.getInt("CALENDAR_ID"));
				calendar.setTitle(rs.getString("TITLE"));
				calendar.setDescription(rs.getString("DESCRIPTION"));
				calendar.setClassName(rs.getString("CLASS_NAME"));
				calendar.setStartDate(rs.getString("START_DATE"));
				calendar.setEndDate(rs.getString("END_DATE"));
				
			}
				return calendar;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);

		} finally {
			closeDB(conn, stmt, rs);
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
