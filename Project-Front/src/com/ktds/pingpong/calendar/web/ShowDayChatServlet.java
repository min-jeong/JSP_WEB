package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.calendar.biz.CalendarBiz;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class ShowDayChatServlet
 */
public class ShowDayChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatBiz chatBiz;
    private TeamBiz teamBiz;
    private CalendarBiz calendarBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDayChatServlet() {
    	   super();
           teamBiz = new TeamBiz();
           chatBiz = new ChatBiz();
           calendarBiz = new CalendarBiz();
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
		System.out.println(selectDay+"selectDay");
		
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		if( loginTeam != null ){
			int teamId = loginTeam.getTeamId(); 
			List<CalendarVO> calNotice = calendarBiz.getCalNoticebyTeamId(teamId);
			System.out.println("calNotice사이즈"+calNotice.size());
			request.setAttribute("calNotice", calNotice);
			
			List<String> memberList = chatBiz.getMemberByTeamId(teamId);
			request.setAttribute("allChatMember", memberList);
		
			List<ChatVO> chatList = chatBiz.getAllChatByDay(selectDay, teamId);
			System.out.println("Listsize"+chatList.size());
			
			request.setAttribute("chatList", chatList);
			
			List<TeamVO> teams = teamBiz.getListTeamById(loginMember.getEmail());
			request.setAttribute("allTeams", teams);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/calendar/cal_daychat_view.jsp");
		rd.forward(request, response);
	}

}
