package com.ktds.jmj.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.member.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.xml.XML;

public class ArticleDAO {
	
	public List<ArticleVO> getArticleInfo() {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getArticleInfo/text()");
			stmt = conn.prepareStatement(query);
		
			rs = stmt.executeQuery();
			
			ArticleVO article = null;
			while ( rs.next() ) {
				article = new ArticleVO();
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
				article.setTitle(rs.getString("TITLE"));
				article.setNickName(rs.getString("NICK_NAME"));
				
				articles.add(article);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return articles;
		
	}
	
	public ArticleVO getOneArticleInfoByArticleId( int articleId ) {

		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getOneArticleInfoByArticleId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, articleId );
			rs = stmt.executeQuery();
			
			
			if( rs.next() ){
				
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
				article.setTitle(rs.getString("TITLE"));
				article.setNickName(rs.getString("NICK_NAME"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return article;	
			
	}
	
	
	public ArticleVO getUpdateRecommends(int articleId) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getUpdateRecommends/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, articleId);
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
		return null;
		
	}
	
	public ArticleVO getUpdateHits( int articleId ) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		ArticleVO article = new ArticleVO();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/getUpdateHits/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, articleId );
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
		return article;	
	}
	
	public ArticleVO deleteArticleByArticleId( int articleId ){
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/deleteArticleByArticleId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, articleId );
			stmt.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
		return null;	
	}
	
	public void writeArticle( ArticleVO article, MemberVO loginMember ){
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/article/writeArticle/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, article.getDescript() );
			stmt.setString(2, loginMember.getMemberId() );
			stmt.setString(3, article.getTitle() );
			stmt.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int updateArticle(ArticleVO changedArticle) {
			
			loadOracleDriver();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
				
				String query = "";
				if ( changedArticle.getTitle() != null
						&& changedArticle.getTitle().length() > 0 ){
					if ( changedArticle.getDescript() != null 
							&& changedArticle.getDescript().length() > 0 ) {
						// 둘다 있는 경우
						query = XML.getNodeString("//query/article/updateArticle/text()");
					}
					else {
						//타이틀만 있는 경우
						query = XML.getNodeString("//query/article/updateArticleOnlyTitle/text()");
					}
					
				}
				else {
					if ( changedArticle.getDescript() != null 
							&& changedArticle.getDescript().length() > 0 ) {
						//타이틀은 없지만 내용은 있는 경우
						query = XML.getNodeString("//query/article/updateArticleOnlyDescription/text()");
					}
				}
								
				stmt = conn.prepareStatement(query);
				if ( changedArticle.getTitle() != null
						&& changedArticle.getTitle().length() > 0 ){
					if ( changedArticle.getDescript() != null 
							&& changedArticle.getDescript().length() > 0 ) {
						// 둘다 있는 경우
						stmt.setString(1, changedArticle.getTitle());
						stmt.setString(2, changedArticle.getDescript());
						stmt.setInt(3, changedArticle.getArticleId());
					}
					else {
						//타이틀만 있는 경우
						query = XML.getNodeString("//query/article/updateArticleOnlyTitle/text()");
						stmt.setString(1, changedArticle.getTitle());
						stmt.setInt(2, changedArticle.getArticleId());
					}
					
				}
				else {
					if ( changedArticle.getDescript() != null 
							&& changedArticle.getDescript().length() > 0 ) {
						//타이틀은 없지만 내용은 있는 경우
						stmt.setString(1, changedArticle.getDescript());
						stmt.setInt(2, changedArticle.getArticleId());
					}
				}		
				return stmt.executeUpdate();
							
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