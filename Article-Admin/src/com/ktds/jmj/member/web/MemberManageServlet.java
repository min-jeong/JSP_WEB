package com.ktds.jmj.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.dao.MemberDAO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class MemberManageServlet
 */
public class MemberManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManageServlet() {
        super();
        memberDAO = new MemberDAO();
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
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		members = memberDAO.getMemberList();
		request.setAttribute("memberList", members);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/manage.jsp");
		rd.forward(request, response);
	}

}
