package com.ktds.pingpong.calendar.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.calendar.biz.CalendarBiz;
import com.ktds.pingpong.calendar.vo.CalendarVO;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest;

/**
 * Servlet implementation class ModifyServlet
 */
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CalendarBiz calendarBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        calendarBiz = new CalendarBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		//int calendarId = Integer.parseInt(multipartRequest.getParameter("id"));

			CalendarVO calendar = new CalendarVO();
			
			String title = request.getParameter("modifyTitle");
			String description = request.getParameter("description");
			String className = request.getParameter("className");
			
			calendar.setTitle(title);
			//descript = descript.replaceAll("<br/>" , "\n");
			calendar.setDescription(description);
			calendar.setClassName(className);
			
			System.out.println("수정");
			try {
			boolean modifyNotice = calendarBiz.modifyNotice(request, calendar);
			
			StringBuffer json = new StringBuffer();
			json.append("{");
			json.append("\"modifyNotice\" : " + modifyNotice);
			json.append("}");
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
			out.close();
			}
			catch( RuntimeException re ) {
				System.out.println(re.getMessage());
			}
	}

}
