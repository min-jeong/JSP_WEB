<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMemberMenu.jsp"></jsp:include>    

<script type="text/javascript">
	$(document).ready( function() {
		$("#doModify").click( function() {
			
			var form = $("#modifyForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/modifyMemberAction" />");
			form.submit();
			
		} );
		
		$("#reset").click( function() {
			location.reload();
			
		} );
		
		$("#cancle").click( function() {
			location.href="<c:url value="/memberManage" />";
			
		} );
		
	} );
</script>   

<br/>
<br/>
<form id="modifyForm" enctype="multipart/form-data"> 
<table border="1" width="800px" align="center">
	<tr>
		<th>아이디</th>
		<td>
			${ member.memberId }
		</td>
	</tr>
	<tr>	
		<th>닉네임</th>
		<td>
			${ member.nickName }
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="text" id="password" name="password" style="width: 250px;" 
					value="${ member.password }" />
		</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>
			${ member.email }
		</td>
	</tr>
</table>
	<input type="hidden" name="memberId" value="${ member.memberId }" />
	
	<br/>

	<table align="center">
	<tr>
		<td colspan="2" align="center">
		메뉴
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" id="doModify" value="수정" />
		</td>
		<td>
			<input type="button" id="reset" value="reset" />
		</td>
	</table>
</form>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>