package com.ktds.jmj.file.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.Const;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.file.vo.FileVO;
import com.ktds.jmj.util.xml.XML;

public class FileDAO {
	
	/**
	 * file List
	 * @param articleId
	 * @return
	 */
	public List<FileVO> getFileInfo( int articleId ){ // articleId에 해당하는 file 정보
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/file/getFileInfo/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId); 
			
			rs = stmt.executeQuery();
			
			List<FileVO> fileList = new ArrayList<FileVO>();
			FileVO file = null;
			
			while ( rs.next() ) {
				file = new FileVO();
				file.setFileId(rs.getInt("FILE_ID"));
				file.setFileLocation(rs.getString("FILE_LOCATION"));
				file.setFileName(rs.getString("FILE_NAME"));	
				fileList.add(file);
			}
			
			if ( file == null ){
				return null;
			}
			return fileList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public int writeFile ( FileVO file ){ // file 정보 입력
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/file/writeFile/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, file.getArticleId());
			stmt.setString(2, file.getFileName());
			stmt.setString(3, file.getFileLocation());
			
			int writeAction = stmt.executeUpdate();
			
			return writeAction;
						
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}

	public int deleteFile( int articleId ) { // articleId에 해당하는 file 삭제
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = XML.getNodeString("//query/file/deleteFile/text()");
			stmt = conn.prepareStatement(query);

			stmt.setInt(1, articleId);
			
			int deleteAction = stmt.executeUpdate();
			
			return deleteAction;
			
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
