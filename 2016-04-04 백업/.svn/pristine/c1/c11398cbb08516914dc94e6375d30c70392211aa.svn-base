package com.ktds.pingpong.chat.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.chat.vo.ChatRate;

/**
 * Servlet implementation class PropertyByMember
 */
public class PropertyByMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChatBiz chatbiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyByMember() {
        super();
        chatbiz = new ChatBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// team 아이디 받아와야한다.
		int teamId = 4; 
		List<ChatRate> memChatRates = chatbiz.getChatRateByTeamId(teamId);
	
		/*System.out.println("ChatRateSize"+memChatRates.size());		*/
		if(memChatRates != null){
		//	System.out.println("ChatRateSize");
			request.setAttribute("memChatRates", memChatRates);
		}
	      
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/tab/property_mem.jsp");
		rd.forward(request, response);
	}

}
