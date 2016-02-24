package com.ktds.jmj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.dao.EmployeesDAO;
import com.ktds.jmj.vo.EmployeesVO;

/**
 * Servlet implementation class EmployeesServlet
 */
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//여기다한다.
	private EmployeesDAO employeesDAO; // 결국 맴버변수다. new 할필요없어.
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesServlet() {
        super();
        employeesDAO = new EmployeesDAO();
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
		//DAO의 getAllEmployees()의 데이터를 그대로 jsp에 보내준다.
		List<EmployeesVO> employees = employeesDAO.getAllEmployees();
		
		request.setAttribute("allEmployees", employees);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/emp.jsp"); //
		rd.forward(request, response);
	}

}
