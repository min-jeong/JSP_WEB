package com.ktds.jmj.member.vo;

public class ArticleVO extends MemberVO{
	
	private int articleId;
	private String descript;
	private int hits;
	private String memberId;
	private int recommends;
	private String title;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getRecommends() {
		return recommends;
	}
	public void setRecommends(int recommends) {
		this.recommends = recommends;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}