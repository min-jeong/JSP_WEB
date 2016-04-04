package com.ktds.pingpong.view;

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
 * Servlet implementation class goMain
 */
public class goMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;   
	private MemberBiz memberBiz;
	private ChatBiz chatBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goMain() {
        super();
        teamBiz = new TeamBiz();
        memberBiz = new MemberBiz();
        chatBiz = new ChatBiz();
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
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		
		if( loginTeam != null ){
			int teamId = loginTeam.getTeamId(); 
		
			List<String> memberList = chatBiz.getMemberByTeamId(teamId);
			request.setAttribute("allChatMember", memberList);
		}
		else{
			
		}
		List<MemberVO> members = memberBiz.getAllMember();  
		List<TeamVO> teams = teamBiz.getListTeamById(loginMember.getEmail());
		//System.out.println("팀사이즈"+teams.size());
		
		request.setAttribute("allTeams", teams);	
		request.setAttribute("allMember", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/view/main.jsp");
		rd.forward(request, response);
	}

}
