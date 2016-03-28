package com.ktds.jmj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.history.biz.OperationHistoryBiz;
import com.ktds.jmj.history.vo.ActionCode;
import com.ktds.jmj.history.vo.BuildDescription;
import com.ktds.jmj.history.vo.Description;
import com.ktds.jmj.history.vo.OperationHistoryVO;
import com.ktds.jmj.member.biz.MemberBiz;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class DoLoginServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberBiz memberBiz;
	private OperationHistoryBiz biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        memberBiz = new MemberBiz();
        biz = new OperationHistoryBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인 할 수 없음");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("userId");
		String memberPassword = request.getParameter("userPw");
		String facebookLogin = request.getParameter("facebookLogin");
		
		System.out.println(memberId);
		System.out.println(memberPassword);
		
		if( facebookLogin != null && facebookLogin.equalsIgnoreCase("Y") ) { // 이것이 호출됬다는 것은 facebook으로 정상적으로 로그인 된것이다.
			MemberVO facebookMember = new MemberVO();
			facebookMember.setMemberId(memberId);
			facebookMember.setNickName(memberPassword);
			
			HttpSession session = request.getSession();
			session.setAttribute("_MEMBER_", facebookMember);
			session.setAttribute("_LOGIN_PATH_", "facebook");
			
			response.sendRedirect("/list");
			return;
		}
		
		MemberVO loginMember = new MemberVO();
		loginMember.setMemberId(memberId);
		loginMember.setPassword(memberPassword);
		
		boolean isLoginSuccess = memberBiz.login(loginMember, request);
		
		if ( isLoginSuccess ) {
/*			Cookie autoLogin = new Cookie("autoLogin", "true");
			autoLogin.setMaxAge(999);
			response.addCookie(autoLogin);
			
			Cookie userId = new Cookie("userId", memberId);
			userId.setMaxAge(999);
			response.addCookie(userId);
			
			Cookie userPassword = new Cookie("userPassword" , memberPassword);
			userPassword.setMaxAge(999);
			response.addCookie(userPassword);*/
			
			OperationHistoryVO historyVO = new OperationHistoryVO();
			historyVO.setIp(request.getRemoteHost());
			historyVO.setMemberId(memberId);
			historyVO.setUrl(request.getRequestURI());
			historyVO.setActionCode(ActionCode.LOGIN);
			historyVO.setDescription( BuildDescription
									.get( Description.LOGIN, memberId ) );
			
			
			biz.addHistory(historyVO);
			response.sendRedirect("/list");
			return;
		}
		else {
			OperationHistoryVO historyVO = new OperationHistoryVO();
			historyVO.setIp(request.getRemoteHost());
			historyVO.setMemberId("");
			historyVO.setUrl(request.getRequestURI());
			historyVO.setActionCode(ActionCode.LOGIN);
			historyVO.setDescription( BuildDescription
									.get( Description.LOGIN_FAIL, request.getRemoteHost(), memberId ) );
			
			
			biz.addHistory(historyVO);
			
			response.sendRedirect("/?errorCode=fail");
			return;
		}
	}

}
