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
		
		$("#recommends").click( function() {
			
	        	$.get("/recommends?articleId=${selectedArticle.articleId}", function(){
	            alert("추천 완료");
	            
	        }); 

		});

 		$("#delete").click( function() {
 			
 			location.href="/delete?articleId=${ selectedArticle.articleId }";
 			
		}); 

 		$("#modify").click( function() {
 			
 			location.href="/modify?articleId=${ selectedArticle.articleId }";
 			
		}); 
		
	}) ;
</script>

<table border="1" width="700px" align="center">
	<tr>
		<th>글 번호</th>
		<th>글 제목</th>
		<th>글쓴이 Nick</th>
		<th>글쓴이 ID</th>
		<th>글 내용</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<tr>
		<td class="c">${ selectedArticle.articleId }</td>
		<td class="c">${ selectedArticle.title }</td>
		<td class="c">${ selectedArticle.nickName }</td>
		<td class="c">${ selectedArticle.memberId }</td>
		<td class="c">${ selectedArticle.descript }</td>
		<td class="c">${ selectedArticle.hits }</td>
		<td class="c">${ selectedArticle.recommends }</td>
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
		<td colspan="2">메뉴</td>
	</tr>
	<tr>
		<td align="center"><input type="button" id="recommends" value="추천" /></td>
		<c:if test="${ loginId eq selectedArticle.memberId }">
			<td>
				<input type="button" id="delete" value="삭제" />
				<input type="button" id="modify" value="수정" />
			</td>
		</c:if>
	</tr>
</table>
