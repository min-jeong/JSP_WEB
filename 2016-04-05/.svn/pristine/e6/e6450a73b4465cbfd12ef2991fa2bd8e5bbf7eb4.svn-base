package com.ktds.pingpong.member.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.pingpong.member.biz.MemberBiz;
import com.ktds.pingpong.member.vo.MemberVO;

/**
 * Servlet implementation class callMemberImage
 */
public class callMemberImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz memberBiz;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public callMemberImage() {
        super();
        memberBiz = new MemberBiz();
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
		
		String picName = request.getParameter("picName");
		
		 File file = new File("D:\\" + picName);
	     String i = URLConnection.guessContentTypeFromName(file.getName());
	     
	     response.setContentType(i);
         response.setContentLength((int)file.length());
	       
		   try {
		      FileInputStream in = new FileInputStream(file);
		      OutputStream out = response.getOutputStream();
		      // Copy the contents of the file to the output stream
		      byte[] buf = new byte[1024];
		      int count = 0;
		      while ((count = in.read(buf)) >= 0) {
		         out.write(buf, 0, count);
		      }
		      out.close();
		      in.close();
		   }
		   catch ( FileNotFoundException fnfe ) {
		      //throw new RuntimeException(fnfe.getMessage(), fnfe);
		   }

	}

}
