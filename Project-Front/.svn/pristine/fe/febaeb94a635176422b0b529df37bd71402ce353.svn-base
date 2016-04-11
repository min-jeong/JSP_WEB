package com.ktds.pingpong.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.history.biz.OperationHistoryBiz;
import com.ktds.pingpong.history.vo.ActionCode;
import com.ktds.pingpong.history.vo.BuildDescription;
import com.ktds.pingpong.history.vo.Description;
import com.ktds.pingpong.history.vo.OperationHistoryVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class deleteWaitingMemberServlet
 */
public class deleteWaitingMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;   
	private OperationHistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
     public deleteWaitingMemberServlet() {
        super();
        teamBiz = new TeamBiz();
        historyBiz = new OperationHistoryBiz();
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
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		String email = request.getParameter("waitingEmail");
		System.out.println("삭제를 요청한 이메일은 " + email + "입니다.");
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		historyVO.setIp(request.getRemoteHost());
		historyVO.setEmail("");
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.TEAM);
		historyVO.setDescription(BuildDescription
				.get(Description.WAIT_LIST_LEAVE, member.getEmail(), loginTeam.getTeamName(), email)
				);
		historyBiz.addHistory(historyVO);		
		
		int teamId = loginTeam.getTeamId();
		boolean deleteTeamAction = teamBiz.removeTeamWaitList(email, teamId);
	    
		response.sendRedirect("/goManageTeam");
	}

}
