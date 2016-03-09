package com.ktds.jmj.member.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.member.dao.MemberDAO;
import com.ktds.jmj.member.vo.MemberVO;

public class MemberBiz {
	
	private MemberDAO memberDAO;
	
	public MemberBiz() {
		memberDAO = new MemberDAO();
	}
	
	public boolean login(MemberVO member, HttpServletRequest request){
		// 1. 회원 정보를 가져온다.
		MemberVO loginMember = memberDAO.getMemberByIdAndPassword(member);
		
		// 2. 회원 정보가 존재한다면, 세션에 집어 넣는다.
		if( loginMember != null ){
			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", loginMember);  // session 변수명 앞뒤에 언더바가 붙는다. 언더바가 있으면 세션이라는 것.
		}
		// 3. 결과를 보고한다.
		return loginMember != null;

	}
	
	public void registerMember(MemberVO member) {
		memberDAO.registerMember(member);
		
	}

}