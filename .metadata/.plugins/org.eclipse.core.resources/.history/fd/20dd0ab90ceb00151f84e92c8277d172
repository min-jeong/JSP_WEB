package com.ktds.jmj.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.Const;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberSearchVO;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.xml.XML;

public class MemberDAO {
	
	/**
	 * ID & Password Check
	 */
	public MemberVO getMemberByIdAndPassword( MemberVO member ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/getMemberByIdAndPassword/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());
			rs = stmt.executeQuery();
			
			MemberVO validMember = null;
			
			if ( rs.next() ) {
				
				validMember = new MemberVO();
				validMember.setMemberId(rs.getString("MEMBER_ID"));
				validMember.setNickName(rs.getString("NICK_NAME"));
				validMember.setPassword(rs.getString("PASSWORD"));
				validMember.setEmail(rs.getString("EMAIL"));
				validMember.setIsAdmin(rs.getString("IS_ADMIN"));
				
			}
			
			return validMember;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	} //getMemberByIdAndPassword end
	
	public List<MemberVO> getMemberList (MemberSearchVO searchVO) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/getMemberList/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, searchVO.getEndIndex()); // 끝나는 번호
			stmt.setInt(2, searchVO.getStartIndex()); // 시작하는 번호
			rs = stmt.executeQuery();
			
			MemberVO member = null;
			
			while ( rs.next() ) {
				
				member = new ArticleVO();
				
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setNickName(rs.getString("NICK_NAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPassword(rs.getString("PASSWORD"));

				members.add(member);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return members;
	}
	public int getAllMemberCount() {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

			String query = XML.getNodeString("//query/article/getAllMemberCount/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			int memberCount = 0;
			rs.next();
			memberCount = rs.getInt(1);
			
			return memberCount;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	public int deleteMember ( String memberId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/deleteMember/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, memberId);
			
			int deleteAction = stmt.executeUpdate();
			
			return deleteAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //deleteArticle end
	
	/**
	 * Add New Member Task
	 */
	public int addNewMember ( MemberVO member ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/addNewMember/text()");
			stmt = conn.prepareStatement(query);

			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getNickName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getEmail());
			
			int addMemberAction = stmt.executeUpdate();
			
			return addMemberAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	} //addNewMember end
	
	
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
