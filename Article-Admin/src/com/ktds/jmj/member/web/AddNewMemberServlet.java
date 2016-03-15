package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.biz.MemberBiz;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.Root;

/**
 * Servlet implementation class AddNewMemberServlet
 */
public class AddNewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMemberServlet() {
        super();
        
        memberBiz = new MemberBiz();

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
		member.setMemberId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setNickName(request.getParameter("nickname"));
		member.setEmail(request.getParameter("email"));
		
		boolean addResult = memberBiz.join(member);
		
		if ( addResult ) {
			response.sendRedirect(Root.get(this) + "/list");
		}
		else {
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}
	}

}
