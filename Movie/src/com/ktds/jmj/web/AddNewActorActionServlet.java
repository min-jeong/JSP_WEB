package com.ktds.jmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.dao.ActorDAO;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AddNewActorActionServlet
 */
public class AddNewActorActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActorDAO actorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewActorActionServlet() {
        super();
        actorDAO = new ActorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form을 통해서 데이터를 받아오면, doGet은 받으면 안된다.
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 이제 한글 안깨져
		
		String actorName = request.getParameter("actorName");
		// 서버도 체크해야한다.
		if ( actorName == null || actorName.length() == 0)  { // (2번) actorName이 존재하지 않으면
			response.sendRedirect("/Movie/addNewActor?errorCode=1"); // 에러코드라는 키로 숫자 1을 보냄 > AddNewActorServlet로 		
			return; // 만나면 끝낸다.
		}
		
		boolean insertResult = actorDAO.addNewActor(actorName);
		if ( insertResult ) { // (잘 입력했다면) insertCount가 1 이상이라면 movie로 가고
			response.sendRedirect("/Movie/movie");
		}
		else { // 그렇지 않으면 addNewActor로 errorCode 2를 들고 가라
			response.sendRedirect("/Movie/addNewActor?errorCode=2");
		}
		
	}

}
