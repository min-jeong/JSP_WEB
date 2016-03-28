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
import com.ktds.jmj.history.biz.OperationHistoryBiz;
import com.ktds.jmj.history.vo.ActionCode;
import com.ktds.jmj.history.vo.BuildDescription;
import com.ktds.jmj.history.vo.Description;
import com.ktds.jmj.history.vo.OperationHistoryVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class ArticleListServlet
 */
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
    private OperationHistoryBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
        super();
        articleBiz = new ArticleBiz();
        biz = new OperationHistoryBiz();
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
		OperationHistoryVO historyVO = new OperationHistoryVO();
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		historyVO.setIp(request.getRemoteHost());
		historyVO.setMemberId(member.getMemberId());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.ARTICLE);
		
		try{
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			historyVO.setDescription( BuildDescription
									.get( Description.LIST_PAGING, member.getMemberId(), pageNo+"" ) );
			
			
			
		}
		catch(NumberFormatException nfe){
			historyVO.setDescription( BuildDescription
									.get( Description.LIST, member.getMemberId()) );
			
		}
		
		biz.addHistory(historyVO);
		
		ArticleSearchVO searchVO = new ArticleSearchVO();
		searchVO.setPageNo(pageNo);
		
		ArticleListVO articles = articleBiz.getAllArticleList(searchVO);
		
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
