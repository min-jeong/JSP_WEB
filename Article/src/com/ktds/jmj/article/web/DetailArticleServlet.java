package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.favo.biz.FavoriteBiz;
import com.ktds.jmj.article.favo.vo.FavoVO;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.file.dao.FileDAO;
import com.ktds.jmj.history.vo.ActionCode;
import com.ktds.jmj.history.vo.BuildDescription;
import com.ktds.jmj.history.vo.Description;
import com.ktds.jmj.history.vo.OperationHistoryVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class DetailArticleServlet
 */
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
	private FileDAO fileDAO;
	private FavoriteBiz favoriteBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailArticleServlet() {
        super();
        articleBiz = new ArticleBiz();
        fileDAO = new FileDAO();
        favoriteBiz = new FavoriteBiz();
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
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		FavoVO favoriteVO = new FavoVO();
		favoriteVO.setArticleId(articleId);
		favoriteVO.setMemberId(member.getMemberId());
		
		ArticleVO article = articleBiz.getDetailArticle(articleId);
		
		boolean isExistsFavoriteData = favoriteBiz.isExistFavoriteData(favoriteVO);
		
		OperationHistoryVO historyVO = (OperationHistoryVO) request.getAttribute("OpeartionHistoryVO");
		historyVO.setActionCode(ActionCode.ARTICLE);
		historyVO.setDescription( BuildDescription
				.get( Description.DETAIL, historyVO.getMemberId(), articleId+"" ) );
		historyVO.setEtc(BuildDescription
				.get( Description.DETAIL_DESCRIPTION, article.getTitle(), article.getMemberId(), article.getDescript()));
		
		request.setAttribute("selectedArticle", article);
		request.setAttribute("isExistsFavoriteData", isExistsFavoriteData);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
		rd.forward(request, response);
		
	}

}
