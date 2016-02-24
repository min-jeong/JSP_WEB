package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.vo.DepartmentsVO;

public class DepartmentsDAO {
	
	public List<DepartmentsVO> getAllDepartments(){
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<DepartmentsVO> departments = new ArrayList<DepartmentsVO>();
		
		// 담아주는 코드
		
		// DB에 연결함
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT * FROM DEPARTMENTS "; 
			stmt = conn.prepareStatement(query);
			
			//쿼리 실행 결과 가져오기
			rs = stmt.executeQuery();
			
			DepartmentsVO department = null;
			while ( rs.next() ) { // 하로우씩 검색하고 다음 로우로 간다.
				department = new DepartmentsVO();
				
				department.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				department.setManagerId(rs.getInt("MANAGER_ID"));
				department.setLocationId(rs.getInt("LOCATION_ID"));
				
				departments.add(department);			
			}
				
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if ( rs != null ){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if ( stmt != null ) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return departments;
	}

}
