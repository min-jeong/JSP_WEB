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
 * Servlet implementation class SetTeamSession
 */
public class SetTeamSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeamBiz teamBiz;   
    private OperationHistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTeamSession() {
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
	    /*session.invalidate();*/
		session.getAttribute("_MEMBER_");
		session.removeAttribute("_TEAM_");
		MemberVO member = (MemberVO)session.getAttribute("_MEMBER_");
		
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		System.out.println("teamId = "+ teamId);
		/*boolean isTeamLogin = */
		teamBiz.teamLogin(teamId, request);
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		historyVO.setIp(request.getRemoteHost());
		historyVO.setEmail(member.getEmail());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.LOGIN);
		historyVO.setDescription(BuildDescription
				.get(Description.TEAM_SELECT, member.getName(),request.getParameter("teamId"))
				);
		historyBiz.addHistory(historyVO);
		
		response.sendRedirect("/goMain");
		// 어디로 보낼것인가?
	}

}
