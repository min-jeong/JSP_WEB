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
	
	public List<ActorVO> getAllActor() {
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ActorVO> actors = new ArrayList<ActorVO>();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getAllActor/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			ActorVO actor = null;
			while( rs.next() ) {
				
				actor = new ActorVO();
				actor.setActorName(rs.getString("ACTOR_NAME"));
				actor.setActorId(rs.getInt("ACTOR_ID"));
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
	
	public boolean addNewActor(String actorName) { // 배우이름 추가하기!
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null; 는 필요없다. select가 아니라서
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/actor/insertNewActor/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, actorName);
			
			int insertCount = stmt.executeUpdate();
			
			return insertCount > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
	}
	
	public void insertNewActorOfNewMovieId( ActorVO actor ){
		// 1. DriverLoading
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
//		ResultSet rs = null; insert 할것이므로 필요없다.
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/insertNewActorList/text()");
			stmt = conn.prepareStatement(query);
			
			//SQL Parameter Mapping
			//?에 데이터 넣기
			stmt.setInt( 1, actor.getMovieId() );// 파라미터 맵핑?
			stmt.setInt( 2, actor.getActorId() );			
			//parameterIndex : 하나의 쿼리에서 몇번째 물음표인지 물어보는것		
			stmt.executeUpdate();

					
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
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
