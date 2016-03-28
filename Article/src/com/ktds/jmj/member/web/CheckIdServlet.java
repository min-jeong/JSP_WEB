package com.ktds.jmj.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.member.biz.MemberBiz;

/**
 * Servlet implementation class CheckIdServlet
 */
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz memberBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        memberBiz = new MemberBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		System.out.println(memberId);
		boolean isExistIdData = memberBiz.isExistIdData(memberId);
		System.out.println(isExistIdData);
		
		StringBuffer json = new StringBuffer(); //숫자를 하나씩 더해 갈 수 있는 기능
		json.append("{");
		json.append("\"isCheck\" : " + isExistIdData);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString()); //스트링 버퍼가 스트링으로 바뀌어서 전달 된다.
		out.flush();
		out.close();
	}

}
