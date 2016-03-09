package com.ktds.jmj.article.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class ArticleListServlet
 */
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBiz articleBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
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
		
		List<ArticleVO> articles = articleBiz.getAllArticleList();
		
		if ( articles != null ) {
			request.setAttribute("articles", articles);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("/list?errorCode=fail");
		}
		
	}
}
