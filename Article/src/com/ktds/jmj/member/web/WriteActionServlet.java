package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.member.biz.ArticleBiz;
import com.ktds.jmj.member.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class WriteActionServlet
 */
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteActionServlet() {
        super();
        articleBiz = new ArticleBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title= request.getParameter("title");
		String description = request.getParameter("description");
		description = description.replaceAll("\n", "<br/>");
		
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setDescript(description);
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_"); // session에 있는 회원정보 가져오기.
		
		articleBiz.writeArticle(article, loginMember);
		
		response.sendRedirect("/list");
	}

}