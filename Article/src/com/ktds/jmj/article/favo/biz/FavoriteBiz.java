package com.ktds.jmj.article.favo.biz;

import com.ktds.jmj.article.favo.dao.FavoriteDAO;
import com.ktds.jmj.article.favo.vo.FavoVO;

public class FavoriteBiz {
	private FavoriteDAO favoriteDAO;
	
	public FavoriteBiz() {
		favoriteDAO = new FavoriteDAO();
	}
	
	public boolean isExistFavoriteData(FavoVO favoriteVO){
		return favoriteDAO.selectFavoriteCount(favoriteVO) > 0;
	}
	
	public void insertOrDeleteFavoriteData( FavoVO favoriteVO ){
		if( isExistFavoriteData(favoriteVO) ){
			favoriteDAO.deleteFavorite(favoriteVO);
		}
		else{
			favoriteDAO.insertFavorite(favoriteVO);
		}
	}
}
