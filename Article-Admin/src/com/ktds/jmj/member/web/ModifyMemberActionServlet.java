package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.biz.MemberBiz;
import com.ktds.jmj.util.Root;
import com.ktds.jmj.util.web.MultipartHttpServletRequest;

/**
 * Servlet implementation class ModifyMemberActionServlet
 */
public class ModifyMemberActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMemberActionServlet() {
        super();
        memberBiz = new MemberBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		String memberId = multipartRequest.getParameter("memberId");
		
		try {
			memberBiz.modifyMember(multipartRequest);
			response.sendRedirect(Root.get(this) + "/memberManage");
		}
		catch(RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect(Root.get(this) + "/detailMember?memberId=" + memberId);
		}
	}

}
