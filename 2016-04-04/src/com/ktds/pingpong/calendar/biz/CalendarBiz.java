package com.ktds.pingpong.calendar.biz;

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
}
