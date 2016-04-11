package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.calendar.biz.CalendarBiz;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.chat.vo.ChatVO;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class CalendarServlet
 */

public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CalendarBiz calendarBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarServlet() {
        super();
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
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		//MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		int teamId  = 0 ;
		if( loginTeam != null ){
			teamId = loginTeam.getTeamId(); 
		}else{ // teamId 가 없을 시 처리 
			System.out.println("안됨");
			response.sendRedirect("/?errorCode=2");
		}
		
		String title = request.getParameter("title");
		String className = request.getParameter("className");
		String description = request.getParameter("description");
		String startDate = request.getParameter("getStart");
		String endDate = request.getParameter("getEnd");
//		int teamId = Integer.parseInt(request.getParameter("teamId"));
		
	//	String description = request.getParameter("description");	
	//	System.out.println(title);
	//	System.out.println(description);
	//	System.out.println(className);
	//	System.out.println(startDate);
	//	System.out.println(endDate);
	//	System.out.println(eventId);
		
		CalendarVO calendarVO = new CalendarVO();
		calendarVO.setTitle(title);
		calendarVO.setDescription(description);
		calendarVO.setClassName(className);
		calendarVO.setStartDate(startDate);
		calendarVO.setEndDate(endDate);
		calendarVO.setTeamId(teamId);
		boolean updateNotice = calendarBiz.insertCalendarData(calendarVO);
		//int calendarId = calendarBiz.getCalendarId(calendarVO);
		
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"updateNotice\" : " + updateNotice);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
	}

}
