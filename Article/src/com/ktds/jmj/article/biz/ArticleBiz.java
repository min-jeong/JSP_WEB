package com.ktds.jmj.article.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.jmj.article.dao.ArticleDAO;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.member.vo.MemberVO;

public class ArticleBiz {
	
	private ArticleDAO articleDAO;
	
	
	public ArticleBiz() {
		articleDAO = new ArticleDAO();
	} //생성자
	
	
	/**
	 * Get Article List Task
	 */
	public List<ArticleVO> getAllArticleList() {
		
		List<ArticleVO> articles = articleDAO.getArticleList();
		
		return articles;
		
	} //getAllArticleList end
	
	
	/**
	 * Article Detail Task
	 */
	public ArticleVO getDetailArticle ( int articleId ) {
		
		ArticleVO article = articleDAO.getDetailArticle(articleId);
		
		return article;
	} //getDetailArticle end
	
	
	/**
	 * Seleted Article Recommends Increase
	 */
	public void addRecommends ( int articleId ) {
		
		articleDAO.addRecommends(articleId);
		
	} //addRecommends end
	
	
	/**
	 * Member ID Check Task
	 */
	public boolean checkMemberId ( String loginMember, String articleInfo ) {
		
		if ( loginMember.equals(articleInfo) ) {
			return true;
		}
		else {
			return false;
		}
		
	} //checkMemberId end
	
	
	/**
	 * Article Delete Task 
	 */
	public boolean deleteArticle ( MemberVO loginMember, ArticleVO articleInfo ) {
		
		if ( checkMemberId(loginMember.getMemberId(), articleInfo.getMemberId()) ) {
			
			// 작성자 ID와 로그인 세션 ID가 같은 경우
			int checkDeleteAction = articleDAO.deleteArticle(articleInfo.getArticleId());
			if ( checkDeleteAction > 0) {
				// 삭제 성공
				return true;
			}
			else {
				// 삭제 실패
				return false;
			}
			
		}
		else {
			
			// 작성자 ID와 로그인 세션 ID가 다른 경우
			return false;
		}
		
	} // deleteAction end

	
	/**
	 * Article Write Task
	 */
	public boolean writeArticle ( ArticleVO article ) {
		
		String description = article.getDescript();
		description = description.replaceAll("\n", "<br/>");
		article.setDescript(description);
		
		int checkWrite = articleDAO.writeArticle(article);
		
		if ( checkWrite > 0 ) {
			return true;
		}
		else {
			return false;
		}
		
	} //writeArticle end
	
	
	public boolean modifyArticle ( HttpServletRequest request ) {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		// 원본 내용
		ArticleVO originArticle = getDetailArticle(articleId);
		
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
			description = description.replaceAll("\n", "<br/>");
			changedArticle.setDescript(description);
		}
		
		if ( changeCount == 0 ) {
			throw new RuntimeException("변경된 사항이 없습니다");
		}
		else {
			changedArticle.setArticleId(articleId);
			return articleDAO.updateArticle(changedArticle) > 0;
		}
	}
	
}
