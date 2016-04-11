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
import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.team.vo.TeamListVO;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class goManageTeam
 */
public class goManageTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	private TeamBiz teamBiz;
	private ChatBiz chatBiz;   
	private CalendarBiz calendarBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goManageTeam() {
        super();
        memberBiz = new MemberBiz();
        teamBiz = new TeamBiz(); 
        chatBiz = new ChatBiz();
        calendarBiz = new CalendarBiz();
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
			
			List<CalendarVO> calNotice = calendarBiz.getCalNoticebyTeamId(teamId);
			request.setAttribute("calNotice", calNotice);
			List<String> keywords = chatBiz.getKeywordByTeamId(teamId);
			request.setAttribute("keywords", keywords);
		
		}
		List<MemberVO> members = memberBiz.getAllMember();  // 필요
		List<TeamVO> teams = teamBiz.getListTeamById(loginMember.getEmail()); 
		List<TeamListVO> memberList = teamBiz.getMemberEmailByTeamId(loginTeam.getTeamId());
		List<TeamListVO> waitingList = teamBiz.getOnlyWaitList(loginTeam.getTeamId());
		List<MemberVO> remainMem = memberBiz.getRemainMember(loginTeam.getTeamId());

		request.setAttribute("allTeams", teams);	// jsp에서 사용안됨??
		request.setAttribute("allMember", members); // jsp에서 사용안됨??
		request.setAttribute("memberList", memberList);	// 멤버 리스트
		request.setAttribute("remainMem", remainMem);	// 리스트를 제외한 나머지 멤버 
		request.setAttribute("waitList", waitingList);
		
		System.out.println(waitingList + "waiting 리스트");
		System.out.println(memberList + "멤버 리스트");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/tab/manageTeam.jsp");
		rd.forward(request, response);
	}

}
