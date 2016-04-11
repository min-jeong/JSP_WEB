package com.ktds.pingpong.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;

/**
 * Servlet implementation class doLogin
 */
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz memberBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        memberBiz = new MemberBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "�α��� �� �� ����");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		MemberVO loginMember = new MemberVO();
		loginMember.setEmail(userId);
		loginMember.setPassword(password);
		
		
		boolean isLoginSuccess = memberBiz.login(loginMember, request);
		
		StringBuffer json = new StringBuffer(); 
		json.append("{");
		json.append("\"isLoginSuccess\" : " + isLoginSuccess);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	
	}

}
