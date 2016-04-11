package com.ktds.pingpong.team.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamListVO;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class ListTeamServlet
 */
public class CreateTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTeamServlet() {
        super();
        teamBiz = new TeamBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		TeamVO team = new TeamVO();
		TeamListVO teamList = new TeamListVO();
		
		team.setTeamName(request.getParameter("teamName"));
		
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		String leaderEmail = member.getEmail();
		team.setLeaderEmail(leaderEmail);
		
/*		List<TeamListVO> emails = new ArrayList<TeamListVO>();
		
		emails.addAll(teamList.setEmail(leaderEmail));*/
		
		String[] emailList = request.getParameterValues("email");
		
		List<String> emails = new ArrayList<String>();
		Collections.addAll(emails, emailList);
		emails.add(leaderEmail);
		
		
		if( emails == null || emails.size() == 0 ){
			response.sendRedirect("/goMain?errorCode=1");
			return;
		}
		int newTeamId = teamBiz.insertNewTeam(team);
		
		for ( String selectedEmail : emails ){
			teamList.setTeamId(newTeamId);
			teamList.setEmail(selectedEmail);
			if ( selectedEmail.equals(leaderEmail) ){
			teamList.setIsLeader("Y");
			}
			else {
				teamList.setIsLeader("N");
			}
			if ( newTeamId > 0 ) {
				teamBiz.insertNewTeamList(teamList);
			}
		}
		
		response.sendRedirect("/goMain");
	}

}
