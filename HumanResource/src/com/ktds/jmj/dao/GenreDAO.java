package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.util.xml.XML;
import com.ktds.jmj.vo.GenreVO;

public class GenreDAO {
	
	public List<GenreVO> getGenresByMovieId( int movieId ){
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		List<GenreVO> genres = new ArrayList<GenreVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getGenresByMovieId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, movieId);
			
			rs = stmt.executeQuery();
			
			GenreVO genre = null;
			while( rs.next() ) {
				genre = new GenreVO();
				genre.setGenreTitle(rs.getString("GENRE_TITLE"));
				
				genres.add(genre);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return genres;
	}
	
	public List<GenreVO> getAllGenre(){
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		List<GenreVO> genres = new ArrayList<GenreVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getAllGenre/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			GenreVO genre = null;
			while( rs.next() ) {
				genre = new GenreVO();
				genre.setGenreTitle(rs.getString("GENRE_TITLE"));
				genre.setGenreId(rs.getInt("GENRE_ID"));
				
				genres.add(genre);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return genres;
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
