package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.vo.ArticleListVO;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.util.Root;

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
		
		int pageNo = 0;
		
		try{
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		catch(NumberFormatException nfe){ }
		ArticleSearchVO searchVO = new ArticleSearchVO();
		searchVO.setPageNo(pageNo);
		
		ArticleListVO articles = articleBiz.getAllArticleList(searchVO);
		
		if ( articles != null ) {
			request.setAttribute("articles", articles);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(Root.get(this) + "/list?errorCode=fail");
		}
		
	}
}