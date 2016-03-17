package com.ktds.jmj.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.member.biz.MemberBiz;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.Root;

/**
 * Servlet implementation class MassiveReleaseBlockMemberServlet
 */
public class MassiveReleaseBlockMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz	memberBiz;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MassiveReleaseBlockMemberServlet() {
        super();
        memberBiz = new MemberBiz();
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
		String[] releaseBlockMemberIds = request.getParameterValues("deleteMemberId");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		memberBiz.releaseBlockMembers(releaseBlockMemberIds, member);
		
		response.sendRedirect(Root.get(this) +"/memberManage");
	}

}
