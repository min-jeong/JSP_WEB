<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMemberMenu.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready( function() {
		
		$("#massiveSelectCheckBox").click(function() {
	         var isChecked = $(this).prop("checked");
	         $(".deleteArticleId").prop("checked", isChecked);
	         
	      });
		
		$("#massiveDeleteBtn").click(function () {
	         var isChecked = false;
	         
	         $(".deleteMemberId").each(function(index, data) {
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
	            form.attr("action", "<c:url value="/massiveDeleteMember" />");
	            form.submit();
	         }
	         
	         
	      });
		
	}) ;
</script>
<table border="1" width="800px" align="center">
	<tr>
		<th>
			<input type="checkbox" id="massiveSelectCheckBox" />
		</th>
		<th>아이디</th>
		<th>닉네임</th>
		<th>비밀번호</th>
		<th>이메일</th>
	</tr>
	<form id="massiveDeleteForm">
	<c:forEach items="${ memberList }"  var="members">
	<tr>
		<td align="center">
				<input type="checkbox" class ="deleteMemberId" name="deleteMemberId" value="${ members.memberId }" />
			</td>
		<td align="center">
		 ${ members.memberId } 
		</td>
		<td>
		${ members.nickName }
		</td>
		<td>
		${ members.password }
		</td>
		<td>
		${ members.email }
		</td>
	</tr>
	</c:forEach>
	</form>
</table>

	<table border="1" align="center" width="150px">
		<tr align="center">
			<td align="center">회원 삭제</td>
		</tr>
		<tr>
			<td align="center">
				<input type="button" id="massiveDeleteBtn" value="삭제" />
			</td>
		</tr>
	</table>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>