<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMemberMenu.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready( function() {
		$("#delete").click( function() {
 			
 			location.href='<c:url value="/deleteAction?memberId=${ selectedMember.memberId }" />';
 			
		}); 

 		$("#modify").click( function() {
 			
 			location.href='<c:url value="/modifyMember?memberId=${ selectedMember.memberId }" />';
 			
		}); 
}) ;

</script>

<br/>
<br/>
<table border="1" width="800px" align="center">
	<tr>
		<th>아이디</th>
		<th>닉네임</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>차단</th>
	</tr>
		<tr>
			<td align="center">
			 ${ selectedMember.memberId } 
			</td>
			<td align="center">
			${ selectedMember.nickName }
			</td>
			<td align="center">
			${ selectedMember.password }
			</td>
			<td align="center">
			${ selectedMember.email }
			</td>
			<td align="center">
			${ selectedMember.isBlock }
		</tr>
</table>
	<br/>
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">
		메뉴
		</td>
	</tr>
		<td>
			<input type="button" id="delete" value="삭제" />
		</td>
		<td>
			<input type="button" id="modify" value="수정" />
		</td>
		
</table>
	
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>