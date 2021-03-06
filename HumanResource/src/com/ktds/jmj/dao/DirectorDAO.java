package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.util.xml.XML;
import com.ktds.jmj.vo.DirectorVO;

public class DirectorDAO {
	
	public List<DirectorVO> getDirectorsByMovieId( int movieId ) {
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<DirectorVO> directors = new ArrayList<DirectorVO>();
		DirectorVO director = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getDirectorsByMovieId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, movieId);
			
			rs = stmt.executeQuery();
			
			
			while( rs.next() ) {
				director = new DirectorVO();
				director.setDirectorName(rs.getString("DIRECTOR_NAME"));
				
				directors.add(director);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return directors;
		
	}
	
	public List<DirectorVO> getAllDirector() {
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<DirectorVO> directors = new ArrayList<DirectorVO>();
		DirectorVO director = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getAllDirector/text()");
			stmt = conn.prepareStatement(query);			
			rs = stmt.executeQuery();
			
			
			while( rs.next() ) {
				director = new DirectorVO();
				director.setDirectorName(rs.getString("DIRECTOR_NAME"));
				director.setDirectorId(rs.getInt("DIRECTOR_ID"));
				
				directors.add(director);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return directors;
		
	}


	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if( rs!=null ){
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if ( stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if (conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

}
