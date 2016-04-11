package com.ktds.pingpong.team.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;
import com.ktds.pingpong.util.Root;

/**
 * Servlet implementation class DeleteTeamServlet
 */
public class DeleteTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private TeamBiz teamBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeamServlet() {
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
		/*String leaderId = request.getParameter("leaderEmail");
		System.out.println(leaderId);
	      
	      HttpSession session = request.getSession();
	      MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
	      System.out.println(loginMember.getEmail());*/
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");  
		
		
	    boolean deleteTeamAction = teamBiz.removeTeam(loginTeam.getTeamId());
	    
		session.removeAttribute("_TEAM_");
	    
	    /*StringBuffer json = new StringBuffer(); 
		json.append("{");
		json.append("\"deleteTeamAction\" : " + deleteTeamAction);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		*/
		System.out.println("성공"+deleteTeamAction);
		response.sendRedirect("/goMain");
	
	}

}
