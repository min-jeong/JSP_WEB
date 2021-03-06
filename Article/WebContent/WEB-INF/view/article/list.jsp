<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
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

	<div style="color:red;" align="center">총 ${ articles.paging.totalArticleCount } 건의 게시물이 있습니다.</div>
<table border="1" width="800px" align="center">
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
			<a href="/detail?articleId=${articles.articleId}"> 
				${ articles.title } 
			</a>
			<c:if test="${ articles.fileCount gt 0 }">
				<img src="/resource/img/file.png" />
				<%-- [${articles.fileCount} 개의 첨부파일 있음] --%>
			</c:if>
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

<table border="1" align="center" width="80px">
	<tr align="center">
		<td align="center">글 작성</td>
	</tr>
	<tr>
			<td align="center">
				<!-- <a href="/write">작성</a> -->
				<input type="button" id="write" value="작성" />
			</td>
	</tr>
</table>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>