package com.ktds.pingpong.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;

/**
 * Servlet implementation class doSignUp
 */
public class doSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSignUp() {
        super();
        memberBiz = new MemberBiz();
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
		MemberVO member = new MemberVO();
		member.setEmail(request.getParameter("email"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		
		boolean addResult = memberBiz.join(member);
		
		if ( addResult ) {
			response.sendRedirect("/");
		}
		else {
			response.sendRedirect("/?errorCode=fail");
		}
	}
}
