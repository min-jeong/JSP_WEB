
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IndexDAO indexDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		indexDAO = new IndexDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titleList[] = request.getParameterValues("title");
	
		System.out.println(titleList.length);
		
				
		for (int i = 0; i < titleList.length; i ++){
			String title = titleList[i];
			title.trim();
			if ( title != ""){
				System.out.println(title);
				indexDAO.insertIndex(title);
			}
		}
		
		List<IndexVO> indexs = new ArrayList<IndexVO>();
		indexs = indexDAO.getAllIndex();
		System.out.println(indexs.size());
		
		request.setAttribute("indexs", indexs);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/indexView.jsp");
		rd.forward(request, response);
	}

}
