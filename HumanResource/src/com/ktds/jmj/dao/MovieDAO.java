package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.util.xml.XML;
import com.ktds.jmj.vo.MovieVO;

public class MovieDAO {
	
	
	public List<MovieVO> getAllMovie() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<MovieVO> movies = new ArrayList<MovieVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			//String query = " SELECT M.*, G.GRADE_TITLE, AC.ACTOR_COUNT FROM   MOVIE M, GRADE G , ( SELECT MOVIE_ID, COUNT(ACTOR_LIST_ID) ACTOR_COUNT FROM ACTOR_LIST GROUP BY MOVIE_ID) AC WHERE  M.GRADE_ID = G.GRADE_ID AND AC.MOVIE_ID(+) = M.MOVIE_ID ";
			String query = XML.getNodeString("//query/movie/getAllMovie/text()");
			System.out.println(query);
			// "//"는 루트를 의미
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			MovieVO movie = null;
			while( rs.next() ){
				
				movie = new MovieVO();
				
				movie.setMovieId(rs.getInt("MOVIE_ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setRate(rs.getDouble("RATE"));
				movie.setRunningTime(rs.getString("RUNNING_TIME"));
				movie.setOpenDate(rs.getString("OPEN_DATE"));
				movie.setGradeId(rs.getInt("GRADE_ID"));
				movie.setGradeTitle(rs.getString("GRADE_TITLE"));
				movie.setActorCount(rs.getInt("ACTOR_COUNT"));
				
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		
		
		return movies;
		
	}

}
