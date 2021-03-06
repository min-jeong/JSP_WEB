<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/logout.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/article/leftMemberMenu.jsp"></jsp:include>
<br/>
<br/>
<table border="1" width="800px" align="center">
	<tr>
		<th>아이디</th>
		<th>닉네임</th>
		<th>이메일</th>
		<th>게시물 수</th>
	</tr>
	<c:forEach items="${ memberList.memberList }"  var="members">
	<tr>
		<td align="center">
			<a href="<c:url value="/detailMember?memberId=${ members.memberId }" /> ">
		 	${ members.memberId } 
		 	</a>
		</td>
		<td align="center">
		${ members.nickName }
		</td>
		<td align="center">
		${ members.email }
		</td>
		<td align="center">
		${ members.articleCount }
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" align="center">
			<form id="searchForm">
					${ memberList.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm") }
			</form>
		</td>
	</tr>
</table>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>