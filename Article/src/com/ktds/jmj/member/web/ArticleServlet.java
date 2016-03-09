package com.ktds.jmj.member.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.biz.ArticleBiz;
import com.ktds.jmj.member.dao.ArticleDAO;
import com.ktds.jmj.member.vo.ArticleVO;

/**
 * Servlet implementation class ShowList
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ArticleDAO articleDAO;
	private ArticleBiz	articleBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
//        articleDAO = new ArticleDAO();
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
//		List<ArticleVO> articles = articleDAO.getArticleInfo();
		List<ArticleVO> articles = articleBiz.getArticleList();
		request.setAttribute("articlelist", articles);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article.jsp");
		rd.forward(request, response);
	}

}