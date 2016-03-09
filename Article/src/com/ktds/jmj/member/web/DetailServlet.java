package com.ktds.jmj.member.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.dao.ArticleDAO;
import com.ktds.jmj.member.dao.MemberDAO;
import com.ktds.jmj.member.vo.ArticleVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleDAO articleDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        articleDAO = new ArticleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		ArticleVO article = articleDAO.getOneArticleInfoByArticleId(articleId);
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/detail.jsp");
		rd.forward(request, response);
	}

}
