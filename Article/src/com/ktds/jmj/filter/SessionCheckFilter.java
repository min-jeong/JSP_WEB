package com.ktds.jmj.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jmj.member.vo.MemberVO;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
public class SessionCheckFilter implements Filter {
		private List<String> whiteList;
		
		private List<String> staticResourceList;
    /**
     * Default constructor. 
     */
    public SessionCheckFilter() {
    	whiteList = new ArrayList<String>();
    	whiteList.add("/");
    	whiteList.add("/doLogin");
    	whiteList.add("/addMember");
    	whiteList.add("/addNewMember");
    	whiteList.add("/favicon.ico");
    	//회원이 아니어도 접속 가능한 페이지
    	staticResourceList = new ArrayList<String>();
    	staticResourceList.add("/resource/");
    	// 그냥 /resource로 적는다면 /resourceImage도 지나간다. 하지만 /resource/ 로 닫아주면 정확히 확인할 수 있다.
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 인스턴스와 클래스 관계는 부모와 자식 관계에서 상속관계이다.(?)
		// 기존에 썼던 HttpServletRequest는 ServletRequest의 한 종류이다.
		// 그러므로 ServletRequest를 HttpServletRequest로 캐스팅 시켜줘야한다.
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		if( !whiteList.contains(uri) ){ //whiteList에 uri가 없다면 session을 check 해라.
			
			boolean isURIResourceFile = false;
			
			for ( String staticResource : staticResourceList) {
				if ( uri.startsWith(staticResource) ) { // 사용자가 요청한 uri가 staticResource로 시작한다면
					isURIResourceFile = true; // 지나간다.
					break;
				}
			}
			
			if ( !isURIResourceFile ){ // whiteList에 포함되어있지 않고 resource 파일이 아니라면 session을 체크해라
				HttpSession session = req.getSession();
				
				MemberVO member = (MemberVO) session.getAttribute("_MEMBER_"); // 넣은 데이터를 가져온다. MemberBiz에서 setAttribute로 넣어주었으므로 _MEMBER_를 가져온다.
				// 가져오는 타입은 Object이다. 그러므로 MemberVO로 캐스팅 해준다.
				
				if ( member == null ) { // 로그인 했는지 안했는지 확인하기 위하여 null인지 체크한다.
					HttpServletResponse res = (HttpServletResponse) response;
					res.sendRedirect("/");
					return;
				}
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
