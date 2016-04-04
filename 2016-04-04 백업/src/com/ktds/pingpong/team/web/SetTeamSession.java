package com.ktds.pingpong.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.team.biz.TeamBiz;

/**
 * Servlet implementation class SetTeamSession
 */
public class SetTeamSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeamBiz teamBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTeamSession() {
        super();
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
		/*HttpSession session = request.getSession();
	    session.invalidate();*/
		
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		System.out.println("teamId = "+teamId);
		/*boolean isTeamLogin = */
		teamBiz.teamLogin(teamId, request);
		
		response.sendRedirect("/goMain");
		// 어디로 보낼것인가?
	}

}
