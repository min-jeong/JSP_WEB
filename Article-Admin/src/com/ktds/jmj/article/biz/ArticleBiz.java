package com.ktds.jmj.article.biz;

import java.util.List;

import com.ktds.jmj.article.dao.ArticleDAO;
import com.ktds.jmj.article.vo.ArticleListVO;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.file.biz.FileBiz;
import com.ktds.jmj.file.dao.FileDAO;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.reply.dao.ReplyDAO;
import com.ktds.jmj.util.web.MultipartHttpServletRequest;
import com.ktds.jmj.util.web.Paging;

public class ArticleBiz {
	
	private ArticleDAO articleDAO;
	private FileDAO fileDAO;
	private ReplyDAO replyDAO;
	private FileBiz fileBiz;
	
	
	public ArticleBiz() {
		articleDAO = new ArticleDAO();
		fileDAO = new FileDAO();
		replyDAO = new ReplyDAO();
		fileBiz = new FileBiz();
	} //생성자
	
	
	/**
	 * Get Article List Task
	 */
	public ArticleListVO getAllArticleList( ArticleSearchVO searchVO ) {
		//1. 전체게시물의 수를 셋팅, 보고싶은 번호를 셋팅
		int allArticleCount = articleDAO.getAllArticleCount(searchVO);
		Paging paging = new Paging();
		paging.setTotalArticleCount(allArticleCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); //1페이지는 0번으로 시작한다.
		
		searchVO.setStartIndex(paging.getStartArticleNumber()); // 시작페이지
		searchVO.setEndIndex(paging.getEndArticleNumber()); // 끝 페이지 를 가져와서 searchVO에 셋팅 시킨다.
		
		//2. 셀렉트하는 DAO에 전달한다. 받아온 결과를 articleListVO에 넣어준다.
		List<ArticleVO> articles = articleDAO.getArticleList(searchVO);
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		return articleList;
		
	} //getAllArticleList end
	
	public ArticleListVO getArticleListByMemberID( ArticleSearchVO searchVO ) {
		//1. 전체게시물의 수를 셋팅, 보고싶은 번호를 셋팅
		int allArticleCount = articleDAO.getArticleCountByMemberID(searchVO);
		Paging paging = new Paging();
		paging.setTotalArticleCount(allArticleCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); //1페이지는 0번으로 시작한다.
		
		searchVO.setStartIndex(paging.getStartArticleNumber()); // 시작페이지
		searchVO.setEndIndex(paging.getEndArticleNumber()); // 끝 페이지 를 가져와서 searchVO에 셋팅 시킨다.
		
		//2. 셀렉트하는 DAO에 전달한다. 받아온 결과를 articleListVO에 넣어준다.
		List<ArticleVO> articles = articleDAO.getArticleListByMemberID(searchVO);
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		return articleList;
		
	} //getAllArticleList end
	
	public ArticleListVO getArticleListByNickName( ArticleSearchVO searchVO ) {
		//1. 전체게시물의 수를 셋팅, 보고싶은 번호를 셋팅
		int allArticleCount = articleDAO.getArticleCountByNickName(searchVO);
		Paging paging = new Paging();
		paging.setTotalArticleCount(allArticleCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); //1페이지는 0번으로 시작한다.
		
		searchVO.setStartIndex(paging.getStartArticleNumber()); // 시작페이지
		searchVO.setEndIndex(paging.getEndArticleNumber()); // 끝 페이지 를 가져와서 searchVO에 셋팅 시킨다.
		
		//2. 셀렉트하는 DAO에 전달한다. 받아온 결과를 articleListVO에 넣어준다.
		List<ArticleVO> articles = articleDAO.getArticleListByNickName(searchVO);
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		
		return articleList;
		
	} //getAllArticleList end
	
	/**
	 * Article Detail Task
	 */
	public ArticleVO getDetailArticle ( int articleId ) {
		
		ArticleVO article = articleDAO.getDetailArticle(articleId);
		article.setFileList(fileDAO.getFileInfo(articleId));
		article.setReplyList(replyDAO.getReplyListByArticleId(articleId));
		
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
/*	public boolean checkMemberId ( String loginMember ) {
		
		if ( loginMember.equals() ) {
			return true;
		}
		else {
			return false;
		}
		
	} //checkMemberId end
	*/
	
	/**
	 * Article Delete Task 
	 */
	public boolean deleteArticle ( MemberVO loginMember, ArticleVO articleInfo ) {
		
		if ( loginMember.isAdmin() ) {
			
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
	public int writeArticle ( ArticleVO article ) {
		
		String description = article.getDescript();
		description = description.replaceAll("\n", "<br/>");
		article.setDescript(description);
		
		int newArticleId = articleDAO.writeArticle(article);
		
		
		return newArticleId;
		
	} //writeArticle end
	
	
	public boolean modifyArticle ( MultipartHttpServletRequest request ) {
		
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


	public void deleteArticles(String[] deleteArticleIds, MemberVO member) {
		if (member.isAdmin() ){
			for( String articleId : deleteArticleIds) {
				ArticleVO targetArticleInfo = this.getDetailArticle(Integer.parseInt(articleId));
				if ( targetArticleInfo.getFileList() != null ){ // file이 존재한다면
					if ( fileBiz.deleteFile(Integer.parseInt(articleId))) { // file을 먼저 삭제하고
						articleDAO.deleteArticle(Integer.parseInt(articleId)); // 게시물을 삭제한다.	
						articleDAO.deleteArticle(Integer.parseInt(articleId));
					}
				}
				else {
					articleDAO.deleteArticle(Integer.parseInt(articleId));
				}
			}
		}
		
	}
	
}
