package com.ktds.jmj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.dao.JobHistoryDAO;
import com.ktds.jmj.vo.JobHistoryVO;

/**
 * Servlet implementation class JobHistoryServlet
 */
public class JobHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private JobHistoryDAO jobhistoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobHistoryServlet() {
        super();
        jobhistoryDAO = new JobHistoryDAO();
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

		List<JobHistoryVO> jobhistorys = jobhistoryDAO.getAllJobHistory();
		
		request.setAttribute("allJobHistory", jobhistorys);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/jobh.jsp");
		rd.forward(request, response);
	}

}
