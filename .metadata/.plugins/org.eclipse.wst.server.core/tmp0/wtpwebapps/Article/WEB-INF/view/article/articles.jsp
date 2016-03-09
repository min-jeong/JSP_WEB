<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        

<style>
.c {
	text-align: center;	
}
</style>

<script type="text/javascript">
	$(document).ready( function() {
		
		$("#write").click( function() {
			
	        location.href="/write";
	        
		});
		
	}) ;
</script>

	총 ${ articles.paging.totalArticleCount } 건의 게시물이 있습니다.
<table border="1" width="500px" align="center">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<c:forEach items="${ articles.articleList }" var="articles">
	<tr>
		<td class="c">${ articles.articleId }</td>
		<td>
			<a href="/detail?articleId=${articles.articleId}"> ${ articles.title } </a>
		</td>
		<td class="c">${ articles.nickName }</td>
		<td class="c">${ articles.hits }</td>
		<td class="c">${ articles.recommends }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
			<form id="searchForm">
			${ articles.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
			</form>
		</td>
	</tr>
</table>

<%-- 세션 접근
${ sessionScope._MEMBER_.memberId }
${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password }
${ sessionScope._MEMBER_.email } --%>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />

<table border="1" align="center">
	<tr align="center">
		<td>글 작성</td>
	</tr>
	<tr>
			<td>
				<!-- <a href="/write">작성</a> -->
				<input type="button" id="write" value="작성" />
			</td>
	</tr>
</table>
