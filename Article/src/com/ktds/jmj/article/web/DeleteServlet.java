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
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		ArticleVO targetArticleInfo = articleBiz.getDetailArticle(articleId);
		
		// deleteArticleAction
		if ( articleBiz.deleteArticle(loginMember, targetArticleInfo) ) {
			response.sendRedirect("/list");
		}
		else {
			// Delete 실패
			response.sendRedirect("/list?errorCode=fail");
		}

	}

}