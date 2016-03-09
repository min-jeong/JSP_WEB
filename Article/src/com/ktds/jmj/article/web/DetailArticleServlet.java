package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.vo.ArticleVO;

/**
 * Servlet implementation class DetailArticleServlet
 */
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticleServlet() {
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
		
		ArticleVO article = articleBiz.getDetailArticle(articleId);
		
		if ( article != null ) {
			request.setAttribute("selectedArticle", article);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("/list?errorCode=fail");
		}
		
	}

}