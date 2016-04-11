package com.ktds.pingpong.chat.web;

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
import com.ktds.pingpong.history.biz.OperationHistoryBiz;
import com.ktds.pingpong.history.vo.ActionCode;
import com.ktds.pingpong.history.vo.BuildDescription;
import com.ktds.pingpong.history.vo.Description;
import com.ktds.pingpong.history.vo.OperationHistoryVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class GetChatServlet
 */
public class GetChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatBiz chatBiz;
    private TeamBiz teamBiz;
    private CalendarBiz calendarBiz;
    private OperationHistoryBiz historyBiz;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChatServlet() {
    	chatBiz = new ChatBiz();
    	teamBiz = new TeamBiz();
    	calendarBiz = new CalendarBiz();
    	historyBiz = new OperationHistoryBiz();
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
		
		OperationHistoryVO historyVO = new OperationHistoryVO();
		String nickName = request.getParameter("nickName");
		HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		if( loginTeam != null ){
			int teamId = loginTeam.getTeamId(); 
		
			List<String> memberList = chatBiz.getMemberByTeamId(teamId);
			request.setAttribute("allChatMember", memberList);
			
			List<ChatVO> chatList = chatBiz.getAllChatByNickName(nickName, teamId);
			request.setAttribute("chatList", chatList);
			
			List<CalendarVO> calNotice = calendarBiz.getCalNoticebyTeamId(teamId);
			request.setAttribute("calNotice", calNotice);
			
			
		}
		List<TeamVO> teams = teamBiz.getListTeamById(loginMember.getEmail());
		List<String> keywords = chatBiz.getKeywordByTeamId(loginTeam.getTeamId());
		
		request.setAttribute("allTeams", teams);
		request.setAttribute("keywords", keywords);
		
		historyVO.setIp(request.getRemoteHost());
		historyVO.setEmail(loginMember.getEmail());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.CHAT);
		historyVO.setDescription(BuildDescription
				.get(Description.CREATE_CHAT , loginTeam.getTeamName() , loginMember.getEmail() )
				);
		historyBiz.addHistory(historyVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/chat/chat_mem_view.jsp");
		rd.forward(request, response);
		
	}

}
