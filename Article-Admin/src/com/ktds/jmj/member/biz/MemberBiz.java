package com.ktds.jmj.member.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.member.dao.MemberDAO;
import com.ktds.jmj.member.vo.MemberVO;

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
	
}
