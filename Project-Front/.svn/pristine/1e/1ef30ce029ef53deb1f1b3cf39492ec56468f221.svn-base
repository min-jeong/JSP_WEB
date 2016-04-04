package com.ktds.pingpong.chat.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.chat.biz.ChatBiz;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest.MultipartFile;

/**
 * Servlet implementation class InsertChatServlet
 */
public class InsertChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatBiz chatBiz; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertChatServlet() {
        super();
        chatBiz = new ChatBiz();
        // TODO Auto-generated constructor stub
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
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		MultipartFile file = multipartRequest.getFile("chatText");
		File upFile = file.write("D:\\" + file.getFileName());
		
		System.out.println("InsertChatServlet 실행");
		boolean isSuccess = chatBiz.insertChatText(upFile, request);
		
		RequestDispatcher rd = null;
		if ( isSuccess == true ) {
			rd = request.getRequestDispatcher("/getNickName");
		}
		else {
			rd = request.getRequestDispatcher("/goMain?errorCode=1");
		}
		
		rd.forward(request,response);
	}

}
