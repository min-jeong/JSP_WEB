package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.biz.ArticleBiz;
import com.ktds.jmj.member.vo.ArticleVO;

/**
 * Servlet implementation class ModifyActionServlet
 */
public class ModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleBiz articleBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyActionServlet() {
        super();
        
        articleBiz = new ArticleBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		try {
			articleBiz.modifyArticle(request);
			response.sendRedirect("/list");
		}
		catch(RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect("/detail?articleId=" + articleId);
		}
	}

}
