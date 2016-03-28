package com.ktds.jmj.article.favo.vo;

import com.ktds.jmj.article.vo.ArticleVO;

public class FavoVO extends ArticleVO{
	private int fovoriteId;
	private String createdDate;
	public int getFovoriteId() {
		return fovoriteId;
	}
	public void setFovoriteId(int fovoriteId) {
		this.fovoriteId = fovoriteId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
