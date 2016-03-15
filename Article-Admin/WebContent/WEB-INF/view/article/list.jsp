<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>     
<jsp:include page="/WEB-INF/view/article/leftMenu.jsp"></jsp:include>
<style>
.c {
	text-align: center;	
}
</style>

<script type="text/javascript">
	$(document).ready( function() {
		
		$("#write").click( function() {
			
	        location.href="<c:url value="/write" />";
	        
		});
		
		$("#massiveSelectCheckBox").click(function() {
	         var isChecked = $(this).prop("checked");
	         $(".deleteArticleId").prop("checked", isChecked);
	         
	      });
		
		$("#massiveDeleteBtn").click(function () {
	         var isChecked = false;
	         
	         $(".deleteArticleId").each(function(index, data) {
	            if( data.checked ) {
	               isChecked = data.checked;
	            }
	         });
	         
	         if ( !isChecked ) {
	            alert("삭제할 대상을 선택하세요.");
	            return;
	         }
	         
	         if ( confirm ("정말 삭제하시겠습니까?")) {
	            var form =$("#massiveDeleteForm");
	            form.attr("method", "post");
	            form.attr("action", "<c:url value="/massiveDelete" />");
	            form.submit();
	         }
	         
	         
	      });
		
	}) ;
</script>
<div>
	총 ${ articles.paging.totalArticleCount } 건의 게시물이 있습니다.
	<br/>
	<table border="1" width="800px" align="center">
		<tr>
			<th>
				<input type="checkbox" id="massiveSelectCheckBox" />
			</th>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
		<form id="massiveDeleteForm">
		<c:forEach items="${ articles.articleList }" var="articles">
		<tr>
			<td align="center">
				<input type="checkbox" class ="deleteArticleId" name="deleteArticleId" value="${ articles.articleId }" />
			</td>
			<td class="c">${ articles.articleId }</td>
			<td>
				<a href="<c:url value="/detail?articleId=${articles.articleId}" />"> 
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
		</form>
		<tr>
			<td colspan="6">
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
	<br/>
	<table border="1" align="center" width="150px">
		<tr align="center">
			<td align="center">글 작성</td>
			<td align="center">글 삭제</td>
		</tr>
		<tr>
				<td align="center">
					<!-- <a href="/write">작성</a> -->
					<input type="button" id="write" value="작성" />
				</td>
				<td align="center">
					<input type="button" id="massiveDeleteBtn" value="삭제" />
				</td>
		</tr>
	</table>

</div>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
