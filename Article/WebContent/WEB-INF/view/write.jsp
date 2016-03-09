<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		<c:if test="${ empty article }">
	    $("#doWrite").click(function() {
	       
	       var title = $("#title").val();
	       title = $.trim( title );
           if ( title == "" ) {
	           alert("title을 입력하세요!");
	           $("#title").focus();
	           return;
           }
           
           var description = $("#description").val();
           description = $.trim( description );
           if ( description == "" ) {
	           alert("description을 입력하세요!");
	           $("#description").focus();
	           return;
           }
	   
	       var form = $("#writeForm");
	       form.attr("method", "POST");
	       form.attr("action", "/writeAction");
	       form.submit();
	       
	    } );
	    </c:if>
	    
	    <c:if test="${ not empty article }">
		$("#doModify").click( function() {
			
			var form = $("#writeForm");
			form.attr("method", "POST");
			form.attr("action", "/modifyAction");
			form.submit();
			
		} );
		$("#reset").click( function() {		
			location.reload();
			
		} );
		</c:if>
		
		$("#cancle").click( function() {
			
			location.href="/list";
			
		} );
		
	    
	 });
</script>
</head>
<body>

<form id = "writeForm" >
	<table>
		<tr>
			<td>TITLE</td>
			<td>
				<input type="text" id="title" name="title" style="width:250px;" 
				value ="${ article.title }"/>
			</td>
		</tr>
		<tr>
			<td>DESCRIPTION</td>
			<td>
				<textarea id="description" name="description" style="width:250px; height:150px;">
				${ article.descript }</textarea>
				
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	<c:if test="${ empty article }">
		<input type="button" id="doWrite" value="등록!" />
		<input type="reset" value="다시 쓰기" />
	</c:if>
	<c:if test="${ not empty article }">
		<input type="hidden" name="articleId" value="${ article.articleId }" />
		<input type="button" id="doModify" value="수정!" />
		<input type="button" id="reset" value="다시 쓰기" />
	</c:if>
	<input type="button" id="cancle" value="취소" />
	
</form>

</body>
</html>