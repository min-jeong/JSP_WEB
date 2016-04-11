package com.ktds.pingpong.calendar.biz;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.calendar.dao.CalendarDAO;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.team.vo.TeamVO;
import com.ktds.pingpong.util.DateFormatter;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest;

public class CalendarBiz {

	private CalendarDAO calendarDAO;
	
	public CalendarBiz() {
		calendarDAO = new CalendarDAO();
		
	}
	public boolean insertCalendarData(CalendarVO calendarVO) throws ParseException {
		
		String startDate = DateFormatter.strToCalDateTime(calendarVO.getStartDate());
		String endDate = DateFormatter.strToCalDateTime(calendarVO.getEndDate());
		
		calendarVO.setStartDate(startDate);
		calendarVO.setEndDate(endDate);
		
		//int result = Integer.parseInt(calendarVO.getStartDate());
		return calendarDAO.insertNotice(calendarVO) > 0;
	}
	
	public List<CalendarVO> getCalNoticebyTeamId(int teamId) {
		
		List<CalendarVO> calendars = calendarDAO.getCalNoticebyTeamId(teamId);
		
		return calendars;
	}
	
	public boolean removeNotice(int calendarId) {
		
		return calendarDAO.removeByCalendarId(calendarId) > 0;
	}
	
	public boolean modifyNotice(HttpServletRequest request, CalendarVO calendar ) {

		/*HttpSession session = request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		int teamId = loginTeam.getTeamId();*/
		
		int calendarId = Integer.parseInt(request.getParameter("calendarId"));
		CalendarVO originNotice = calendarDAO.getCalNoticebyCalendarId(calendarId);
		
		int changeCount = 0;
		String title = request.getParameter("modifyTitle");
		String description = request.getParameter("description");
		String className = request.getParameter("className");
		CalendarVO changedNotice = new CalendarVO();
		
		System.out.println("수정값들 비교하기 전");
		
		if ( !originNotice.getTitle().equals(title) ) {
			System.out.println(originNotice.getTitle());
			changeCount++;
			changedNotice.setTitle(title);
		}
		
		//descript = descript.replaceAll("\n", "<br/>");
		if ( !originNotice.getDescription().equals(description) ) {
			changeCount++;
			changedNotice.setDescription(description);
		}
		
		if ( !originNotice.getClassName().equals(className) ) {
			changeCount++;
			changedNotice.setClassName(className);
		}
		System.out.println("변경되기 전");
		
		if ( changeCount == 0 ) {
			throw new RuntimeException("변경된 사항이 없습니다.");
		}
		else {
			System.out.println("변경");
			changedNotice.setCalendarId(calendarId);
			return calendarDAO.updateNotice(changedNotice) > 0;
		}
	}
}
