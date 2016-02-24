package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.vo.JobHistoryVO;

public class JobHistoryDAO {
	
	public List<JobHistoryVO> getAllJobHistory(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<JobHistoryVO> jobhistorys = new ArrayList<JobHistoryVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT * FROM JOB_HISTORY ";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			JobHistoryVO jobhistory = null;
			while( rs.next() ){
				jobhistory = new JobHistoryVO();
				
				jobhistory.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				jobhistory.setStartDate(rs.getString("START_DATE"));
				jobhistory.setEndDate(rs.getString("END_DATE"));
				jobhistory.setJobId(rs.getString("JOB_ID"));
				jobhistory.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				jobhistorys.add(jobhistory);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if ( rs != null){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (stmt != null){
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
		
		
		return jobhistorys;
	}

}
