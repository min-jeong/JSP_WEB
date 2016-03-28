package com.ktds.jmj.article.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.article.favo.biz.FavoriteBiz;
import com.ktds.jmj.article.favo.vo.FavoVO;
import com.ktds.jmj.history.biz.OperationHistoryBiz;
import com.ktds.jmj.history.vo.OperationHistoryVO;
import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet implementation class FavoriteServlet
 */
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FavoriteBiz favoriteBiz;
    private OperationHistoryBiz historyBiz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        favoriteBiz = new FavoriteBiz();
        historyBiz = new OperationHistoryBiz();
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
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		FavoVO favoriteVO = new FavoVO();
		favoriteVO.setArticleId(articleId);
		favoriteVO.setMemberId(member.getMemberId());
		favoriteBiz.insertOrDeleteFavoriteData(favoriteVO);
		
		OperationHistoryVO historyVO = (OperationHistoryVO) request.getAttribute("OpeartionHistoryVO");
		historyVO.setActionCode("AR_F");
		String message = "[%s]가 [%s]글을 즐겨찾기에 등록했습니다.";
		
		boolean isExistFavoriteData = favoriteBiz.isExistFavoriteData(favoriteVO);
		if ( isExistFavoriteData ){
			message = "[%s]가 [%s]글을 즐겨찾기에서 삭제했습니다.";
		}
		
		historyVO.setDescription( String.format(message, member.getMemberId(), articleId+""));
		historyBiz.addHistory(historyVO);
		
		//String aaa = "{\"key\" : \"value\"}"; // json 형식 || 문자 내에서 쌍따움표를 표현하는 방법 \로...
		StringBuffer json = new StringBuffer(); //숫자를 하나씩 더해 갈 수 있는 기능
		json.append("{");
		json.append("\"result\" : true");
		json.append(",\"isFavorite\" : " + isExistFavoriteData);
		json.append("}");
		
		PrintWriter out = response.getWriter();
		out.print(json.toString()); //스트링 버퍼가 스트링으로 바뀌어서 전달 된다.
		out.flush();
		out.close();
		 // true라는 데이터를 넘겨준다. detail의 favorite.click 의 function(data) 에서 data로!
	}
}
