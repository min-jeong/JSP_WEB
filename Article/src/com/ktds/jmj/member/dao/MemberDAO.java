package com.ktds.jmj.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.jmj.Const;
import com.ktds.jmj.article.vo.ArticleVO;
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
				validMember.setIsBlock(rs.getString("IS_BLOCK"));
				
			}
			
			return validMember;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
	} //getMemberByIdAndPassword end
	
	
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
	

	public int selectIdCount(String memberId) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/member/selectIdCount/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberId); // 끝나는 번호
			
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
