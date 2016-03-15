package com.ktds.jmj.member.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.vo.ArticleListVO;
import com.ktds.jmj.article.vo.ArticleSearchVO;
import com.ktds.jmj.article.vo.ArticleVO;
import com.ktds.jmj.member.dao.MemberDAO;
import com.ktds.jmj.member.vo.MemberListVO;
import com.ktds.jmj.member.vo.MemberSearchVO;
import com.ktds.jmj.member.vo.MemberVO;
import com.ktds.jmj.util.web.Paging;

public class MemberBiz {
	
	private MemberDAO memberDAO;
	
	public MemberBiz() {
		memberDAO = new MemberDAO();
	} // 생성자
	
	
	/**
	 * Login Task
	 */
	public boolean login (MemberVO member, HttpServletRequest request) {
		
		// 1 회원 정보 가져오기
		MemberVO loginMember = memberDAO.getMemberByIdAndPassword(member);
		
		// 2 일치하는 회원 정보 세션에 넣기
		if ( loginMember != null ) {
			 HttpSession session = request.getSession();
			 session.setAttribute("_MEMBER_", loginMember);
		}
		
		// 3 결과 보고
		return loginMember != null;
	} // login end
	
	public MemberListVO getAllMemberList( MemberSearchVO searchVO ) {
		//1. 전체게시물의 수를 셋팅, 보고싶은 번호를 셋팅
		int allMemberCount = memberDAO.getAllMemberCount();
		Paging paging = new Paging();
		paging.setTotalArticleCount(allMemberCount);
		paging.setPageNumber(searchVO.getPageNo() + ""); //1페이지는 0번으로 시작한다.
		
		searchVO.setStartIndex(paging.getStartArticleNumber()); // 시작페이지
		searchVO.setEndIndex(paging.getEndArticleNumber()); // 끝 페이지 를 가져와서 searchVO에 셋팅 시킨다.
		
		//2. 셀렉트하는 DAO에 전달한다. 받아온 결과를 articleListVO에 넣어준다.
		List<MemberVO> members = memberDAO.getMemberList();
		
		ArticleListVO articleList = new ArticleListVO();
		articleList.setArticleList(articles);
		articleList.setPaging(paging);
		
		return articleList;
		
	} //getAllArticleList end
	/**
	 * Join Task
	 */
	public boolean join (MemberVO member) {
		
		int addResult = memberDAO.addNewMember(member);
		
		if ( addResult > 0 ) {
			return true;
		}
		else {
			return false;
		}
	} //join end
	
	
	public void deleteMembers(String[] deleteMemberIds, MemberVO member) {
		if ( member.isAdmin() ){
			for( String memberId : deleteMemberIds) {
				memberDAO.deleteMember(memberId);
			}
		}
	}
	
}
