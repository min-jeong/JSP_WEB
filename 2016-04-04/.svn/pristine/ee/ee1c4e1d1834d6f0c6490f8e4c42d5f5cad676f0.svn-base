package com.ktds.pingpong.team.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.team.biz.TeamBiz;
import com.ktds.pingpong.util.Root;

/**
 * Servlet implementation class DeleteTeamServlet
 */
public class DeleteTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private TeamBiz teamBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeamServlet() {
        super();
        teamBiz = new TeamBiz();
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
		
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		String leaderId = request.getParameter("leaderEmail");
		System.out.println(leaderId);
	      
	      HttpSession session = request.getSession();
	      MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
	      System.out.println(loginMember.getEmail());
	   /*   TeamVO targetTeamInfo = teamBiz.showDetail(teamId);*/
	      
	      //위 두개가 같은지 비교
	      //TODO 로그인한 사용자와 삭제하려는 글을 작성한 사용자가 같은지 비교한 후
	      if( loginMember.getEmail().equals(leaderId)  ){
	          teamBiz.removeTeam(teamId);
	          response.sendRedirect(Root.get(this) + "/goMain");
	       }
	      else{
	    	  System.out.println("같지않다.");
	    	  response.sendRedirect(Root.get(this) + "/goMain");
	      }
	      
	      //TODO 같다면, 글을 삭제한다.  
	      //TODO 다를 경우 삭제하지 않는다.
	}

}
