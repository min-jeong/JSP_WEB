package com.ktds.pingpong.member.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.pingpong.Const;
import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest;
import com.ktds.pingpong.util.web.MultipartHttpServletRequest.MultipartFile;

/**
 * Servlet implementation class UpdatePhotoServlet
 */
public class UpdatePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberBiz memberBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePhotoServlet() {
        super();
        memberBiz = new MemberBiz();
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
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		MultipartFile file = multipartRequest.getFile("upPhoto");
		File upPhoto = file.write("D:\\"+ file.getFileName());
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
	
		loginMember.setPic_name(upPhoto.getName());
		loginMember.setPic_path(upPhoto.getPath());
		
		boolean isBoolean = memberBiz.updateMemberPhoto(loginMember);
		
		RequestDispatcher rd = null;
		if ( isBoolean ) {
			session.setAttribute("_MEMBER_", loginMember);
			rd = request.getRequestDispatcher("/doAboutProfile");
		}
		else {
			rd = request.getRequestDispatcher("/goMain?errorCode=1");
		}
		
		rd.forward(request, response);
	}

}
