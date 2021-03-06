package com.ktds.jmj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jmj.dao.ActorDAO;
import com.ktds.jmj.dao.DirectorDAO;
import com.ktds.jmj.dao.GenreDAO;
import com.ktds.jmj.dao.MovieDAO;
import com.ktds.jmj.vo.ActorVO;
import com.ktds.jmj.vo.DirectorVO;
import com.ktds.jmj.vo.GenreVO;
import com.ktds.jmj.vo.MovieVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MovieDAO movieDAO;
    private DirectorDAO directorDAO;
    private ActorDAO actorDAO;
    private GenreDAO genreDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        movieDAO = new MovieDAO();
        directorDAO = new DirectorDAO();
        actorDAO = new ActorDAO();
        genreDAO = new GenreDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		//영화정보 가져옴.
		MovieVO movie = movieDAO.getOneMovieInfoByMovieId(movieId);
		//감독정보 가져옴.
		List<DirectorVO> directors = directorDAO.getDirectorsByMovieId(movieId);
		//출현진 정보 가져옴.
		List<ActorVO> actors = actorDAO.getActorsByMovieId(movieId);
		//장르 정보 가져옴.
		List<GenreVO> genres = genreDAO.getGenresByMovieId(movieId);
		
		request.setAttribute("movie", movie);
        request.setAttribute("directors", directors);
        request.setAttribute("actors", actors);
        request.setAttribute("genres", genres);
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/detail.jsp");
        rd.forward(request, response);
	}

}
