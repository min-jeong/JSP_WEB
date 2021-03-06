package com.ktds.jmj.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.biz.ArticleBiz;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.file.biz.FileBiz;
import com.ktds.jmj.file.dao.FileDAO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileBiz fileBiz;
	private ArticleBiz articleBiz;
	private FileDAO fileDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        articleBiz = new ArticleBiz();
        fileBiz = new FileBiz();
        fileDAO = new FileDAO();
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
		if ( targetArticleInfo.getFileList() != null ){ // file이 존재한다면
			if ( fileBiz.deleteFile(articleId)) { // file을 먼저 삭제하고
				articleBiz.deleteArticle(loginMember, targetArticleInfo); // 게시물을 삭제한다.			
				response.sendRedirect("/list");
			}
			else {
				// Delete 실패
				response.sendRedirect("/list?errorCode=fail");
			}
		}
		else { // file이 존재하지 않는다면
			if( articleBiz.deleteArticle(loginMember, targetArticleInfo) ) { // 게시물만 삭제한다.
				response.sendRedirect("/list");
			}
			else {
				response.sendRedirect("/list?errorCode=fail");
			}
			
		}

	}

}
