package com.ktds.pingpong.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.history.biz.OperationHistoryBiz;
import com.ktds.pingpong.history.vo.ActionCode;
import com.ktds.pingpong.history.vo.BuildDescription;
import com.ktds.pingpong.history.vo.Description;
import com.ktds.pingpong.history.vo.OperationHistoryVO;
import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;

/**
 * Servlet implementation class doSignUp
 */
public class doSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
	 private OperationHistoryBiz historyBiz;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSignUp() {
        super();
        memberBiz = new MemberBiz();
        historyBiz = new OperationHistoryBiz();
        // TODO Auto-generated constructor stub
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
		MemberVO member = new MemberVO();
		member.setEmail(request.getParameter("email"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		
		boolean addResult = memberBiz.join(member);
		
		if ( addResult ) {
			
			OperationHistoryVO historyVO = new OperationHistoryVO();
			historyVO.setIp(request.getRemoteHost());
			historyVO.setEmail("");
			historyVO.setUrl(request.getRequestURI());
			historyVO.setActionCode(ActionCode.LOGIN);
			historyVO.setDescription(BuildDescription
					.get(Description.MEMBERSHIP, request.getRemoteHost(), member.getEmail())
					);
			historyBiz.addHistory(historyVO);
			
			response.sendRedirect("/");
		}
		else {
			OperationHistoryVO historyVO = new OperationHistoryVO();
			historyVO.setIp(request.getRemoteHost());
			historyVO.setEmail("");
			historyVO.setUrl(request.getRequestURI());
			historyVO.setActionCode(ActionCode.LOGIN);
			historyVO.setDescription(BuildDescription
					.get(Description.MEMBERSHIP_FAIL, request.getRemoteHost())
					);
			historyBiz.addHistory(historyVO);
			
			response.sendRedirect("/?errorCode=fail");
		}
	}
}
