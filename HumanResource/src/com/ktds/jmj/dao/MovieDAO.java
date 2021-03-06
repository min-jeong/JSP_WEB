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
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<MovieVO> movies = new ArrayList<MovieVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			//String query = " SELECT M.*, G.GRADE_TITLE, AC.ACTOR_COUNT FROM   MOVIE M, GRADE G , ( SELECT MOVIE_ID, COUNT(ACTOR_LIST_ID) ACTOR_COUNT FROM ACTOR_LIST GROUP BY MOVIE_ID) AC WHERE  M.GRADE_ID = G.GRADE_ID AND AC.MOVIE_ID(+) = M.MOVIE_ID ";
			String query = XML.getNodeString("//query/movie/getAllMovie/text()");
			// "//"는 루트를 의미
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			MovieVO movie = null;
			while( rs.next() ){ //데이터가 없을때까지 반복
				
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
			closeDB(conn, stmt, rs);
		}
		return movies;
	}
	
	public MovieVO getOneMovieInfoByMovieId( int movieId ) {
		
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		MovieVO movie = new MovieVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getOneMovieInfoByMovieId/text()");
			stmt = conn.prepareStatement(query);
			
			//SQL Parameter Mapping
			//?에 데이터 넣기
			stmt.setInt(1, movieId); // 파라미터 맵핑?
			//parameterIndex : 하나의 쿼리에서 몇번째 물음표인지 물어보는것
			
			rs = stmt.executeQuery();
			
			if (rs.next()){ //데이터가 있다면
				
				movie.setMovieId(rs.getInt("MOVIE_ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setRate(rs.getDouble("RATE"));
				movie.setRunningTime(rs.getString("RUNNING_TIME"));
				movie.setOpenDate(rs.getString("OPEN_DATE"));
				movie.setGradeId(rs.getInt("GRADE_ID"));
				movie.setGradeTitle(rs.getString("GRADE_TITLE"));
				
			}
				
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return movie;
	}
	
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	

	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
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
	

}
