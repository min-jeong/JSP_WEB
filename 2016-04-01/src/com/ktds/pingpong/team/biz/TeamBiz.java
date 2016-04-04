package com.ktds.pingpong.team.biz;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.team.dao.TeamDAO;
import com.ktds.pingpong.team.vo.TeamListVO;
import com.ktds.pingpong.team.vo.TeamVO;

public class TeamBiz {
	
	private TeamDAO teamDAO;
	
	public TeamBiz(){
		teamDAO = new TeamDAO();
	}

	public int insertNewTeam(TeamVO team) {
		
		int newTeamId = teamDAO.insertNewTeam( team );
	
		return newTeamId;
		// 파라미터를 통해 VO로 team 새로운 가입 정보를 파라미터로 가졌왔다.
		// 그 파라미터 받은 정보 개체들을 memberDAO의 addNewMember로 파라미터를 통해 또 보냈다. 
	}
	
	public void insertNewTeamList(TeamListVO teamList){

		teamDAO.insertNewTeamList(teamList);
	}
	
	public List<TeamVO> getAllListTeam(){

		return teamDAO.getAllListTeam();
	}
	
	public List<TeamVO> getListTeamById(String email){

		return teamDAO.getListTeamById(email);
	}

	public TeamVO showDetail(int teamId) {
		TeamVO team = new TeamVO();
		team = teamDAO.showDetail(teamId);
		return team;
	}

	public void removeTeam(int teamId) {
		teamDAO.removeTeam(teamId);
		
	}

	public boolean teamLogin(int teamId, HttpServletRequest request) {
		TeamVO loginTeam = teamDAO.getTeamInfoById(teamId);
		
		if( loginTeam != null ){
			HttpSession session = request.getSession();
			session.setAttribute("_TEAM_", loginTeam);
		}
		
		return loginTeam != null;
		
	}
	
/*	public TeamVO showDetail(int teamId){
		TeamVO team = teamDAO.getOneTeamByTeamId(teamId);
	}*/
	
}
