package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.member.biz.MemberBiz;
import com.ktds.jmj.member.vo.MemberListVO;
import com.ktds.jmj.member.vo.MemberSearchVO;

/**
 * Servlet implementation class MemberManageServlet
 */
public class MemberManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManageServlet() {
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
		
		int pageNo = 0;
		
		try{
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		catch(NumberFormatException nfe){ }
		MemberSearchVO searchVO = new MemberSearchVO();
		searchVO.setPageNo(pageNo);
		
		MemberListVO members = memberBiz.getAllMemberList(searchVO);
		
		request.setAttribute("memberList", members);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/manage.jsp");
		rd.forward(request, response);
	}

}
