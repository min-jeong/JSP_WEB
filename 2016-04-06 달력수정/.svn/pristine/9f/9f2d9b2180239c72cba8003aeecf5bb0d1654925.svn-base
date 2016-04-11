package com.ktds.pingpong.team.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.dao.TeamDAO;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class TeamServlet
 */
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TeamDAO teamDAO;
       private TeamBiz teamBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        teamDAO = new TeamDAO();
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
		
		List<TeamVO> teams = teamBiz.getAllListTeam();
		//System.out.println("팀사이즈"+teams.size());
	
		request.setAttribute("allTeams", teams);		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/team/team_menu.jsp");
		
		rd.forward(request, response);
	}

}
