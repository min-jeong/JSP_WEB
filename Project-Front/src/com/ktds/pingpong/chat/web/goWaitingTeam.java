package com.ktds.pingpong.chat.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamListVO;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class goWaitingTeam
 */
public class goWaitingTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	private TeamBiz teamBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goWaitingTeam() {
        super();
        memberBiz = new MemberBiz();
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
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		List<MemberVO> members = memberBiz.getAllMember();
		List<TeamListVO> waitList = teamBiz.getOnlyWaitList(loginTeam.getTeamId());
		
		System.out.println("대기열 리스트 =" + waitList);
		
		request.setAttribute("waitList", waitList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/tab/manageTeam.jsp");
		rd.forward(request, response);
	}

}
