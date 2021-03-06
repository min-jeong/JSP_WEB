package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.util.xml.XML;
import com.ktds.jmj.vo.GradeVO;

public class GradeDAO {
	public List<GradeVO> getAllGrade(){
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		List<GradeVO> grades = new ArrayList<GradeVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/movie/getAllGrade/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			GradeVO grade = null;
			while( rs.next() ) {
				grade = new GradeVO();
				grade.setGradeTitle(rs.getString("GRADE_TITLE"));
				grade.setGradeId(rs.getInt("GRADE_ID"));
				
				grades.add(grade);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		finally {
			closeDB(conn, stmt, rs);
		}
		return grades;
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
