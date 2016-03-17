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
 * Servlet implementation class DeleteMemberActionServlet
 */
public class DeleteMemberActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberActionServlet() {
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
		String memberId = request.getParameter("memberId");
		
		memberBiz.deleteOneMember(memberId);
		response.sendRedirect(Root.get(this) + "/memberManage");
	}

}
