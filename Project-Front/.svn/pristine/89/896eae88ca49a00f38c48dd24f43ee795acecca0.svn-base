package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class getDayChatServlet
 */
public class GetDayChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatBiz chatBiz;
    private TeamBiz teamBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDayChatServlet() {
        super();
        teamBiz = new TeamBiz();
        chatBiz = new ChatBiz();
    }	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String selectDay = request.getParameter("selectDay");
		
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		
		if( loginTeam != null ){
			int teamId = loginTeam.getTeamId(); 
		
			List<String> memberList = chatBiz.getMemberByTeamId(teamId);
			request.setAttribute("allChatMember", memberList);
	
			List<ChatVO> chatList = chatBiz.getAllChatByDay(selectDay, teamId );

			boolean success = false;
			if(chatList.size()!=0){
				success = true;
			}
				
			StringBuffer json = new StringBuffer();
			json.append("{");
			json.append("\"success\" : " + success);
			json.append("}");
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
			out.close();
		
		}
		
	}

}
