package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.calendar.biz.CalendarBiz;
import com.ktds.pingpong.calendar.vo.CalendarVO;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/calendar")
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
		
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		String className = request.getParameter("className");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		CalendarVO calendarVO = new CalendarVO();
		calendarVO.setEventId(eventId);
		calendarVO.setClassName(className);
		calendarVO.setTitle(title);
		calendarVO.setDescription(description);
		calendarBiz.insertCalendarData(calendarVO);
		
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\"insertCalendarData\" : ");
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}

}
