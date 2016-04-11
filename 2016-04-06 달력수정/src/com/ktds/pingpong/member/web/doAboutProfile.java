package com.ktds.pingpong.member.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class doAboutProfile
 */
public class doAboutProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	private TeamBiz teamBiz;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAboutProfile() {
        super();
        memberBiz = new MemberBiz();
        teamBiz = new TeamBiz();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		session.removeAttribute("_TEAM_");
		
		teamBiz.getMemberCount(loginMember.getEmail()); // Update MemberCount before getList 
		
		List<TeamVO> teams = teamBiz.getListTeamById(loginMember.getEmail());
		
		List<TeamVO> isLeaderTeams = teamBiz.getLeaderTeamById(loginMember.getEmail()); // for Manage Team Tab
		
		
		
		request.setAttribute("allTeams", teams);
		request.setAttribute("isLeaderTeams", isLeaderTeams); // 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/MemberInformation.jsp");
		rd.forward(request, response);
	}

}
