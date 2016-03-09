package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class WriteActionServlet
 */
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleBiz articleBiz;
       
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
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		String title = request.getParameter("title");
		String description =  request.getParameter("description"); 
		
		ArticleVO article = new ArticleVO();
		
		article.setMemberId(loginMember.getMemberId());
		article.setDescript(description);
		article.setTitle(title);
		
		boolean checkWrite = articleBiz.writeArticle( article );
		
		if ( checkWrite ) {
			response.sendRedirect("/list");
		}
		else {
			response.sendRedirect("/list?errorCode=fail");
		}
		
	}

}