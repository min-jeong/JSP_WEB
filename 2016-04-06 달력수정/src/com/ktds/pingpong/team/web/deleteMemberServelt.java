package com.ktds.pingpong.team.web;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class deleteMemberServelt
 */
public class deleteMemberServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeamBiz teamBiz;   
    private OperationHistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMemberServelt() {
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
		String email = request.getParameter("thisEmail");
		System.out.println(email);
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		historyVO.setIp(request.getRemoteHost());
		historyVO.setEmail("");
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.LOGIN);
		historyVO.setDescription(BuildDescription
				.get(Description.MEMBER_LEAVE, request.getRemoteHost(), email)
				);
		historyBiz.addHistory(historyVO);
		
		int teamId = loginTeam.getTeamId();
		boolean deleteMem = teamBiz.deleteMember(email, teamId); 
		System.out.println(deleteMem);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/goManageTeam");
		rd.forward(request, response);
		
	}

}
