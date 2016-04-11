package com.ktds.pingpong.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.util.PageUtil;
import com.ktds.pingpong.util.Root;

/**
 * Servlet implementation class ControlMain
 */
public class ControlMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PageUtil pageUtil;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlMain() {
        super();
        pageUtil = new PageUtil();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.sendError(HttpServletResponse.SC_FORBIDDEN, "�옒紐삳맂 �젒洹쇱엯�땲�떎.");
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(page);
		
		if (page == pageUtil.getChatCalendar()) {
			request.setAttribute("pageNum", pageUtil.getChatCalendar());
		} else if (page == pageUtil.getChatMember()) {
			request.setAttribute("pageNum",pageUtil.getChatMember());
		} else if (page == pageUtil.getPropertyMember()) {
			request.setAttribute("pageNum", pageUtil.getPropertyMember());
		} else{
			request.setAttribute("pageNum", pageUtil.getTeamInfo());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB_INF/view/view/main.jsp");
		rd.forward(request, response);
	}

}
