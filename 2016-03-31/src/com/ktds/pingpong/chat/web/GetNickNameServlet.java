package com.ktds.pingpong.chat.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.chat.biz.ChatBiz;

/**
 * Servlet implementation class GetNickNameServlet
 */
public class GetNickNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatBiz chatBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNickNameServlet() {
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
		List<String> memberList = chatBiz.getAllMemberInChat();
	
		request.setAttribute("memberList", memberList);
		RequestDispatcher rd = request.getRequestDispatcher("/goMain");
		rd.forward(request, response);	
		}

}
