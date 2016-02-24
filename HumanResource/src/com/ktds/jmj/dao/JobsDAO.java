package com.ktds.jmj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jmj.vo.JobsVO;

public class JobsDAO {
	
	public List<JobsVO> getAllJobs(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<JobsVO> jobs = new ArrayList<JobsVO>();
		
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			
			String query = " SELECT * FROM JOBS ";
			stmt = conn.prepareStatement(query);
			
			//데이터 담기
			rs = stmt.executeQuery();
			
			JobsVO job = null;
			while ( rs.next() ){
				job = new JobsVO();
				
				job.setJobId(rs.getString("JOB_ID"));
				job.setJobTitle(rs.getString("JOB_TITLE"));
				job.setMaxSalary(rs.getInt("MAX_SALARY"));
				job.setMinSalary(rs.getInt("MIN_SALARY"));
				
				jobs.add(job);
				
			}
							
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if (rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if( conn != null ){
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return jobs;
	}

}
