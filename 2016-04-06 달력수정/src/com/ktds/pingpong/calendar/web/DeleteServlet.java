package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.calendar.biz.CalendarBiz;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CalendarBiz calendarBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
	
	int calendarId = Integer.parseInt(request.getParameter("id"));
	
	boolean deleteNotice = calendarBiz.removeNotice(calendarId);
	
	StringBuffer json = new StringBuffer();
	json.append("{");
	json.append("\"deleteNotice\" : " + deleteNotice);
	json.append("}");
	
	PrintWriter out = response.getWriter();
	out.print(json.toString());
	out.flush();
	out.close();
	}

}
