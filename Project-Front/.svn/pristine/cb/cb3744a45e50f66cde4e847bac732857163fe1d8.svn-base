package com.ktds.pingpong.calendar.biz;

import java.util.List;

import com.ktds.pingpong.calendar.dao.CalendarDAO;
import com.ktds.pingpong.calendar.vo.CalendarVO;

public class CalendarBiz {

	private CalendarDAO calendarDAO;
	
	public CalendarBiz() {
		calendarDAO = new CalendarDAO();
		
	}
	public boolean insertCalendarData(CalendarVO calendarVO) {
		
		return calendarDAO.insertNotice(calendarVO) > 0;
	}
	
	public List<CalendarVO> getCalNoticebyTeamId(int teamId) {
		
		List<CalendarVO> calendars = calendarDAO.getCalNoticebyTeamId(teamId);
		
		return calendars;
	}
	
	public int getCalendarId(CalendarVO calendar) {
		
		return calendarDAO.getLatestCalendarId(calendar);
	}
	
}
