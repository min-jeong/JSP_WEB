package com.ktds.jmj.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewActorServlet
 */
public class AddNewActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 배우명 등록시 발생된 에러가 있다면, 적절한 조치를 취한다.
		String errorCode = request.getParameter("errorCode");
		// 배우이름을 안썼다면
		if( errorCode != null && errorCode.equals("1")) { // (3번) 에로코드가 있다면! 있을수도 있고, 없을 수도 있다. AddNewActor 페이지를 처음 열었을때는 에러코드가 없을 것이야. 그래서 null 체크를 한것이야.
			request.setAttribute("ErrorMessage", "배우명을 등록하세요.");
		}
		else if ( errorCode != null && errorCode.equals("2")) { 
			request.setAttribute("ErrorMessage", "등록에 실패했습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addNewActor.jsp");
		rd.forward(request, response);
	}

}
