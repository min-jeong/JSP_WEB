package com.ktds.pingpong.chat.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.team.vo.TeamVO;

/**
 * Servlet implementation class GetKeywordServlet
 */
public class GetKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ChatBiz chatBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetKeywordServlet() {
        super();
        chatBiz = new ChatBiz();
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
		System.out.println("GetKeywordServlet 실행");
		HttpSession session =  request.getSession();
		TeamVO loginTeam = (TeamVO) session.getAttribute("_TEAM_");
		
		int teamId = loginTeam.getTeamId();
		
		List<String> keywords = chatBiz.getKeywordByTeamId(teamId);
		
		for( String key : keywords ) {
			System.out.println("DB에서 가져온 키워드는 " + key) ;
		}
		request.setAttribute("keywords", keywords);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/chat/chat_keyword_view.jsp");
		rd.forward(request, response);
	}

}
