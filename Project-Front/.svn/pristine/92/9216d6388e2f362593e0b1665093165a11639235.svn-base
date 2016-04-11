package com.ktds.pingpong.chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.pingpong.Const;
import com.ktds.pingpong.chat.vo.ChatRate;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.util.DateFormatter;
import com.ktds.pingpong.util.xml.XML;

public class ChatDAO {

	public void deleteAllKeyWordByTeamId(int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/deleteAllKeyWordByTeamId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	public void deleteAllChatByTeamId(int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/deleteAllChatByTeamId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}

	}

	public List<String> getAllMember(int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<String> member = new ArrayList<String>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getNickNamebyTeamId/text()");
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);

			rs = stmt.executeQuery();

			while (rs.next()) {
				member.add(rs.getString("NICK_NAME"));
			}

			return member;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public List<ChatVO> getAllChat(int teamId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatVO chat = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getAllChat/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			rs = stmt.executeQuery();
			List<ChatVO> chatList = new ArrayList<ChatVO>();
			while (rs.next()) {
				chat = new ChatVO();
				chat.setChatID(rs.getInt("CHAT_ID"));
				chat.setChatDate(rs.getString("CHAT_DATE"));
				chat.setNickName(rs.getString("NICK_NAME"));
				chat.setDescription(rs.getString("DESCRIPTION"));

				chatList.add(chat);
			}

			return chatList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public int insertChatText(List<ChatVO> chat, int teamId) {
		loadOracleDriver();

		int insertCount = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		DateFormatter df = new DateFormatter();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/insertChat/text()");
			stmt = conn.prepareStatement(query);

			System.out.println("insertChatText");
			for (ChatVO chatVO : chat) {

				stmt.setString(1, df.parseDate(chatVO.getChatDate()));
				stmt.setString(2, chatVO.getNickName());
				stmt.setString(3, chatVO.getDescription());
				stmt.setInt(4, teamId);

				insertCount = stmt.executeUpdate();

				if (insertCount < 1) {
					break;
				}
			}
			return insertCount;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (java.text.ParseException pe) {
			throw new RuntimeException(pe.getMessage(), pe);
		} finally {
			closeDB(conn, stmt, null);
		}
	}	

	public List<String> getAllMemberInChat() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<String> memberList = new ArrayList<String>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getAllArticles/text()");
			stmt = conn.prepareStatement(query);
			/*
			 * stmt.setInt(1, searchVO.getEndIndex()); stmt.setInt(2,
			 * searchVO.getStartIndex());
			 */

			rs = stmt.executeQuery();

			while (rs.next()) {
				memberList.add(rs.getString("NICK_NAME"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

		return memberList;
	}

	public List<ChatVO> getAllChatByDay(String selectDay, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatVO chat = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getAllChatByDay/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(selectDay);
			stmt.setString(1, '%' + selectDay + '%');
			stmt.setInt(2, teamId);

			List<ChatVO> chatList = new ArrayList<ChatVO>();

			rs = stmt.executeQuery();
			while (rs.next()) {
				chat = new ChatVO();
				chat.setChatID(rs.getInt("CHAT_ID"));
				chat.setChatDate(rs.getString("CHAT_DATE"));
				chat.setNickName(rs.getString("NICK_NAME"));
				chat.setDescription(rs.getString("DESCRIPTION"));
				chat.setNotice(rs.getString("NOTICE"));
				chat.setTeamId(rs.getInt("TEAM_ID"));

				chatList.add(chat);
			}

			return chatList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatVO> getAllChatByNickName(String nickName, int teamId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatVO chat = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getAllChatByNickName/text()");
			stmt = conn.prepareStatement(query);
			System.out.println(query);
			System.out.println(nickName);
			stmt.setString(1, nickName);
			stmt.setInt(2, teamId);

			/*
			 * stmt.setInt(1, searchVO.getEndIndex()); stmt.setInt(2,
			 * searchVO.getStartIndex());
			 */

			List<ChatVO> chatList = new ArrayList<ChatVO>();

			rs = stmt.executeQuery();

			while (rs.next()) {
				chat = new ChatVO();
				chat.setChatID(rs.getInt("CHAT_ID"));
				chat.setChatDate(rs.getString("CHAT_DATE"));
				chat.setNickName(rs.getString("NICK_NAME"));
				chat.setDescription(rs.getString("DESCRIPTION"));
				chat.setNotice(rs.getString("NOTICE"));
				chat.setTeamId(rs.getInt("TEAM_ID"));

				chatList.add(chat);
			}

			return chatList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

	}

	public List<ChatRate> getChatRateByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getChatRateByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICKNAME"));
				rate.setMemberChatRate(rs.getDouble("GCT"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getTimeChatCountByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getTimeChatCountByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);
			stmt.setInt(3, teamid);
			stmt.setInt(4, teamid);
			

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICK_NAME"));
				rate.setNightChatCount(rs.getInt("NC"));
				rate.setMorningChatCount(rs.getInt("MC"));
				rate.setSumMorningChatCount(rs.getInt("SUM_MC"));
				rate.setSumNightChatCount(rs.getInt("SUM_NC"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getFirstChatCountByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getFirstChatCountByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);
			stmt.setInt(3, teamid);
			stmt.setInt(4, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("REPLY_NICK"));
				rate.setFirstChatCount(rs.getInt("SUN_TALK"));
				rate.setSumFirstChatCount(rs.getInt("SUM_ST"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getFastReplyChatCountByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getFastReplyChatCountByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);
			stmt.setInt(3, teamid);
			stmt.setInt(4, teamid);
			stmt.setInt(5, teamid);
			stmt.setInt(6, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("REPLY_NICK"));
				rate.setFirstReplyCountTalk(rs.getInt("COUNT_TALK"));
				rate.setFirstReplySumTalk(rs.getInt("SUM_TALK"));
				rate.setFirstReplyAvgTalk(rs.getInt("ACT"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getHowManyChatByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getHowManyChatByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);
			stmt.setInt(3, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICK_NAME"));
				rate.setHowManySumText(rs.getInt("SUM_TEXT"));
				rate.setHowManyAvgText(rs.getInt("AVG_TEXT"));
				rate.setHowMnayTotalCount(rs.getInt("TOTAL_COUNT"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getSmileChatByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getSmileChatByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICK_NAME"));
				rate.setSmileChatCount(rs.getInt("POSI_COUNT"));
				rate.setSmileSumChatCount(rs.getInt("SUM_POSI"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getAngryChatByTeamId(int teamid) {
	
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getAngryChatByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICK_NAME"));
				rate.setAngryChatCount(rs.getInt("BAD_COUNT"));
				rate.setAngrySumChatCount(rs.getInt("SUM_BAD"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	public List<ChatRate> getDayChatByTeamId(int teamid) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatRate rate = null;

		try {

			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/chat/getDayChatByTeamId/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, teamid);
			stmt.setInt(2, teamid);

			rs = stmt.executeQuery();
			List<ChatRate> rates = new ArrayList<ChatRate>();

			while (rs.next()) {
				rate = new ChatRate();
				rate.setNickName(rs.getString("NICK_NAME"));
				rate.setDayChatCount(rs.getInt("COUNT_TALK"));
				rate.setChatDay(rs.getString("CHAT_DAY"));
				rate.setDaySumChatCount(rs.getInt("SUM_COUNT_TALK"));

				rates.add(rate);
			}

			return rates;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	public List<ChatVO> getNearChatByKeyword(String keyword, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChatVO chat = null;
		List<ChatVO> chatList = new ArrayList<ChatVO>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/getNearChatByKeyword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			stmt.setInt(2, teamId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				chat = new ChatVO();
				chat.setChatID(rs.getInt("CHAT_ID"));
				chat.setChatDate(rs.getString("CHAT_DATE"));
				chat.setNickName(rs.getString("NICK_NAME"));
				chat.setDescription(rs.getString("DESCRIPTION"));
				chat.setKeywordId(rs.getInt("KEY_CHAT_ID"));
				
				chatList.add(chat);
			}
			if( chatList.size() > 0 ) {
			System.out.println(chatList.get(0).getKeywordId());
			}
			return chatList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public int insertKeywordIntoDB(String keyword, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/insertKeywordIntoDB/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			stmt.setInt(2, teamId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	
	public List<Integer> getChatIdByKeyword(String keyword, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Integer> chatIdList = new ArrayList<Integer>();

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/getChatIdByKeyword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			stmt.setInt(2, teamId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				chatIdList.add(rs.getInt("CHAT_ID"));
			}

			return chatIdList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

	}
	public List<String> getKeywordByTeamId(int teamId) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		List<String> keywords = null;

		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/getKeywordByTeamId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			rs = stmt.executeQuery();

			keywords = new ArrayList<String>();
			
			while (rs.next()) {
				keywords.add(rs.getString("KEYWORD"));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return keywords;
	}

	public int updateKeywordInDB(String keyword, int teamId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/updateKeywordInDB/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			stmt.setInt(2, teamId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int updateTeamInfoChatUpdate(String loginName, int teamId ) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/updateTeamInfoChatUpdate/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, loginName);
			stmt.setInt(2, teamId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, null);
		}
	}

	public List<ChatRate> getAddFileChatByTeamId(int teamId) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		List<ChatRate> addFileChat = null;
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/chat/getAddFileChatByTeamId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, teamId);
			stmt.setString(2, "<사진 읽지 않음>");
			stmt.setInt(3, teamId);
			stmt.setString(4, "<사진 읽지 않음>");
			
			rs = stmt.executeQuery();

			addFileChat = new ArrayList<ChatRate>();
			
			ChatRate fileChat = null;
			while (rs.next()) {
				fileChat = new ChatRate();
				fileChat.setNickName(rs.getString("NICK_NAME"));
				fileChat.setAddFileCount(rs.getInt("MEM_COUNT"));
				fileChat.setSumAddFileCount(rs.getInt("SUM_COUNT"));
				addFileChat.add(fileChat);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
		return addFileChat;
	
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


	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}


}