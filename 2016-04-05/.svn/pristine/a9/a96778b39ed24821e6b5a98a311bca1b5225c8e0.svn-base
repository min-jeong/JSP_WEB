package com.ktds.pingpong.member.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.dao.MemberDAO;
import com.ktds.pingpong.member.vo.MemberVO;

public class MemberBiz {

	private MemberDAO memberDAO;

	public MemberBiz() {
		memberDAO = new MemberDAO();
	} // ������

	/**
	 * Join Task
	 */
	public boolean join(MemberVO member) {

		int addResult = memberDAO.addNewMember(member);

		if (addResult > 0) {
			return true;
		} else {
			return false;
		}
	} // join end

	/**
	 * Login Task
	 */
	public boolean login(MemberVO member, HttpServletRequest request) {

		// 1 ȸ�� ���� ��������
		MemberVO loginMember = memberDAO.getMemberByIdAndPassword(member);

		// 2 ��ġ�ϴ� ȸ�� ���� ���ǿ� �ֱ�
		if (loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", loginMember);
		}

		// 3 ��� ����
		return loginMember != null; // �α��� ���������� true ���и� false ����
	} // login end

	/**
	 * Check Id �ߺ�üũ
	 */
	public boolean isExistIdData(String email) {
		return memberDAO.selectIdCount(email) > 0; // ���̵� �����ϸ� true
	}
	
	/**
	 * check before Password
	 * @param member
	 * @param beforePw
	 * @return
	 */
	public boolean CheckPassword(MemberVO member, String beforePw) {
		System.out.println(beforePw + "으응으응");
		System.out.println(member.getPassword());
		if (member.getPassword().equals(beforePw)) {
			return true;
		} else {
			return false;
		}

	}
	
	public MemberVO getPasswordById(String email) {
		MemberVO member = memberDAO.checkPassword(email);	
		
		return member;

	}
	
	public boolean UpdateInformation(String name, String afterPw, String email) {

		MemberVO changedMember = new MemberVO();

		changedMember.setEmail(email);
		changedMember.setName(name);
		changedMember.setPassword(afterPw);

		return memberDAO.updateMember(changedMember) > 0;

	}

	public boolean updateMemberPhoto(MemberVO loginMember) {
		int insertCount = memberDAO.updateMemberPhoto(loginMember);

		if (insertCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<MemberVO> getAllMember() {
		List<MemberVO> members = memberDAO.getAllMember();
		return members;
	}

	public List<MemberVO> getRemainMember(int teamId) {
		List<MemberVO> remainMem = memberDAO.getRemainMember(teamId);
		return remainMem;
	}

}
