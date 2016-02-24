package com.ktds.jmj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.dao.CountriesDAO;
import com.ktds.jmj.vo.CountriesVO;

/**
 * Servlet implementation class CountriesServlet
 */
public class CountriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountriesDAO countriesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountriesServlet() {
        super();
        countriesDAO = new CountriesDAO();
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
		
		List<CountriesVO> countries = countriesDAO.getAllCountries();
		
		request.setAttribute("allCountries", countries);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cot.jsp");
		rd.forward(request, response);
						
	}

}
