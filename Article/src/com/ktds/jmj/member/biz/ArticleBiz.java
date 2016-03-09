package com.ktds.jmj.member.biz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.jmj.member.dao.ArticleDAO;
import com.ktds.jmj.member.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;

public class ArticleBiz {
	
	private ArticleDAO articleDAO;
	
	public ArticleBiz() {
		articleDAO = new ArticleDAO();
		
	}
	
	public List<ArticleVO> getArticleList() {
		List<ArticleVO> articlelist = new ArrayList<ArticleVO>();
		articlelist = articleDAO.getArticleInfo();
		
		
		return articlelist;
	}
	public ArticleVO getOneArticleInfoByArticleId( int articleId ) {
		ArticleVO article = new ArticleVO();
		article = articleDAO.getOneArticleInfoByArticleId(articleId);
		
		return article;
	}
	
	public void deleteArticle ( int articleId, MemberVO loginMember, ArticleVO targetArticleInfo ) {
		//TODO 로그인한 사용자와 삭제하려는 글을 작성한 사용자가 같은지 비교한 후
		if( loginMember.getMemberId().equals(targetArticleInfo.getMemberId()) ){
			//TODO 같다면, 글을 삭제한다.
			articleDAO.deleteArticleByArticleId(articleId);
		}
		else{
			return;
		}
	}
	
	public void writeArticle( ArticleVO article, MemberVO loginMember ) {
		
		articleDAO.writeArticle(article, loginMember);
	}
	
	public boolean modifyArticle ( HttpServletRequest request ) {
			
			int articleId = Integer.parseInt(request.getParameter("articleId"));
			
			// 원본 내용
			ArticleVO originArticle = getOneArticleInfoByArticleId(articleId);
			
			int changeCount = 0;
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			ArticleVO changedArticle = new ArticleVO();
			
			if ( !originArticle.getTitle().equals(title) ) {
				changeCount++;				
				changedArticle.setTitle(title);
			}
			if ( !originArticle.getDescript().equals(description) ) {
				changeCount++;
				title = title.replaceAll("\n", "<br/>");
				changedArticle.setDescript(description);
			}
			
			if ( changeCount == 0 ) {
				throw new RuntimeException("변경된 사항이 없습니다");
			}
			else {
				return articleDAO.updateArticle(changedArticle) > 0;
			}
		}
		
	
}