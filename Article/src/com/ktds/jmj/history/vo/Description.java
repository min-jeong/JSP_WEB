package com.ktds.jmj.history.vo;

public interface Description {
	public static final String VISIT_LOGIN_PAGE = "[%s] 가 로그인 페이지에 접근했습니다.";
	public static final String LOGIN ="[%s] 님이 로그인 했습니다."; //%d정수, %f실수, %s문자
	public static final String ALREADY_LOGIN = "[%s] 님이 이미 로그인 되어, List페이지로 이동합니다.";
	public static final String LOGIN_FAIL ="[%s] 가 [%s]로 로그인을 시도했지만, 실패했습니다."; 
	
	public static final String LIST = "[%s]님이 목록보기 페이지에 접근했습니다.";
	public static final String DETAIL = "[%s]님이 [%s]번째 글을 읽었습니다.";
	public static final String LIST_PAGING = "[%s]님이 [%s]번째 페이지로 이동했습니다.";
	public static final String LIST_SEARCH = "[%s]님이 목록보기 페이지에서 [%s]로 [%s]를 검색했습니다.";
	
	public static final String DETAIL_DESCRIPTION ="제목 : [%s] <br/>글쓴이 : [%s]<br/>내용 : [%s]<br/>";
}
