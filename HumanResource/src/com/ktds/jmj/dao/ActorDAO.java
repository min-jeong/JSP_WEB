package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.util.xml.XML;
import com.ktds.jmj.vo.ActorVO;

public class ActorDAO {	
	
	public List<ActorVO> getActorsByMovieId( int movieId ) {
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ActorVO> actors = new ArrayList<ActorVO>();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getActorsByMovieId/text()");
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, movieId);
			
			rs = stmt.executeQuery();
			
			ActorVO actor = null;
			while( rs.next() ) {
				
				actor = new ActorVO();
				actor.setActorName(rs.getString("ACTOR_NAME"));
				actors.add(actor);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		
		return actors;
		
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