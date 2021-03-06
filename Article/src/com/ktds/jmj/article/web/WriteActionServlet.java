package com.ktds.jmj.article.web;

import java.io.File;
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
import com.ktds.jmj.file.vo.FileVO;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.web.MultipartHttpServletRequest;
import com.ktds.jmj.util.web.MultipartHttpServletRequest.MultipartFile;


/**
 * Servlet implementation class WriteActionServlet
 */
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleBiz articleBiz;
	FileDAO fileDAO;
	FileBiz fileBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteActionServlet() {
        super();
        
        articleBiz = new ArticleBiz();
        fileDAO = new FileDAO();
        fileBiz = new FileBiz();

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

		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		String title = multipartRequest.getParameter("title");
		String description = multipartRequest.getParameter("description");
		MultipartFile file = multipartRequest.getFile("file");
		File upFile = file.write("D:\\" + file.getFileName());
		// file이 null 이라면 안올린것. null이 아니라면 올린것	
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		ArticleVO article = new ArticleVO();
		
		article.setMemberId(loginMember.getMemberId());
		article.setDescript(description);
		article.setTitle(title);
		
		FileVO files = new FileVO();
		
		int newArticleId = articleBiz.writeArticle( article );
		
		if (file.getFileName().length() > 0){ //파일을 올릴경우
			// file dao 수행
			files.setArticleId(newArticleId);
			files.setFileName(file.getFileName());
			files.setFileLocation("D");
			
			fileDAO.writeFile(files);
			
			System.out.println(file.getFileName());
		}	
		
		response.sendRedirect("/list");
	}

}
