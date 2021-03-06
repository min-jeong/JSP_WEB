package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		ArticleSearchVO searchVO = new ArticleSearchVO();
		HttpSession session = request.getSession();
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		try{
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
			searchVO.setPageNo(pageNo);
			searchVO.setSearchKeyword( searchKeyword );
		}
		catch(NumberFormatException nfe){ 
			searchVO = (ArticleSearchVO) session.getAttribute("_SEARCH_");
			if( searchVO == null ){
				searchVO = new ArticleSearchVO();
				searchVO.setPageNo(0);
				searchVO.setSearchKeyword("");
			}
		}
		String id = "id";
		String nickname = "nickname";
		session.setAttribute("_SEARCH_", searchVO); // 데이터를 셋팅하고 세션에 넣는다.
		ArticleListVO articles = null;
		
		
		if( searchType != null ){
			if (searchType.equals(id)) {
				articles = articleBiz.getArticleListByMemberID(searchVO);
			}
			else if (searchType.equals(nickname)){
				articles = articleBiz.getArticleListByNickName(searchVO);
			}
			else{
				articles = articleBiz.getAllArticleList(searchVO);
			}
			
		}
		else {
			articles = articleBiz.getAllArticleList(searchVO);
		}
		
		System.out.println(articles.getArticleList().size());
		request.setAttribute("articles", articles);
		request.setAttribute("searchVO", searchVO);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/list.jsp");
		rd.forward(request, response);
	}
}
