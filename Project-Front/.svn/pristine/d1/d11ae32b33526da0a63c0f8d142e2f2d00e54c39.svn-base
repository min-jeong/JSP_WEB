package com.ktds.pingpong.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.history.biz.OperationHistoryBiz;
import com.ktds.pingpong.history.vo.ActionCode;
import com.ktds.pingpong.history.vo.BuildDescription;
import com.ktds.pingpong.history.vo.Description;
import com.ktds.pingpong.history.vo.OperationHistoryVO;
import com.ktds.pingpong.member.vo.MemberVO;

/**
 * Servlet implementation class doLogout
 */
public class doLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OperationHistoryBiz historyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogout() {
        super();
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
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO)session.getAttribute("_MEMBER_");
		// history 저장 후 session 소거
		OperationHistoryVO historyVO = new OperationHistoryVO();
		historyVO.setIp(request.getRemoteHost());
		historyVO.setEmail(member.getEmail());
		historyVO.setUrl(request.getRequestURI());
		historyVO.setActionCode(ActionCode.LOGIN);
		historyVO.setDescription(BuildDescription
				.get(Description.LOGOUT, member.getName())
				);
		historyBiz.addHistory(historyVO);
		
		session.removeAttribute("_MEMBER_");
		session.removeAttribute("_TEAM_");
		
		session.invalidate();
	    
		response.sendRedirect("/");
	}

}
