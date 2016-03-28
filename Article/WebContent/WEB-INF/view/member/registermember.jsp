<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/login.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
<script type="text/javascript" src="resource/js/json2.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		
		$("#doRegister").click( function() {
			
			// ID Check
			var id = $("#id").val();
			id = $.trim( id );
			if ( id == "" ) {
				alert("ID 입력");
				$("#id").focus();
				return;
			}
			
			// PASSWORD Check
			var password = $("#password").val();
			password = $.trim( password );
			if ( password == "" ) {
				alert("PASSWORD 입력");
				$("#password").focus();
				return;
			}
			
			// NICKNAME Check
			var nickname = $("#nickname").val();
			nickname = $.trim( nickname );
			if ( nickname == "" ) {
				alert("NICKNAME 입력");
				$("#nickname").focus();
				return;
			}
			
			// E-MAIL Check
			var email = $("#email").val();
			email = $.trim( email );
			if ( email == "" ) {
				alert("E-MAIL 입력");
				$("#email").focus();
				return;
			}
			
			// FOAM Submit
			var form = $("#registerForm");
			form.attr("method", "POST");
			form.attr("action", "/addNewMember");
			form.submit();
			
		} );
		
		$("#cancle").click( function() {
			
			location.href="/";
			
		} );
		
		$("#check").click( function() {
			var memberId = document.getElementById('id').value;
			
			console.log(memberId);
/* 			$.ajax({
				type:"POST",
				url:"/checkId",
				data:this.memberId,
				dataType:"memberId",
				success:function(data){
					var jsonData =  JSON.parse(data);
					
					
					console.log(jsonData);
					
					if ( jsonData.isCheck ) {
						$("#id").text("");
						$("#id").reset();
						alert("이미 존재하는 아이디입니다.");
					}
					else if ( jsonData.isCheck ) {
						alert("사용할 수 있는 아이디입니다.");
					}
					
				} 
			}) */
 			$.post(
					"/checkId"
					, { "memberId" : $("#id").val() }
					, function(data){
						var jsonData = {};
						try{
							jsonData = JSON.parse(data);
						}
						catch(e) {
							alert("으아아앙앙");
						}
						
						console.log(jsonData);
						if ( jsonData.isCheck ) {
							var text = $("#id").text();
							$("#id").text("");
							$("#id").reset();
							alert("이미 존재하는 아이디입니다.");
						}
						else {
							alert("사용할 수 있는 아이디입니다.");
						}
						
					} 
				);
		});
		
	} );
</script>   

<br/>

<form id="registerForm">
	<table id="tb" align="center">
		<tr>
			<th>ID :</th>
			<td>
				<input type="text" id="id" name="id" style="width: 250px;" /><input type="button" id="check" name="check" value="중복체크" />
			</td>
		</tr>
		<tr>
			<th>Password :</th>
			<td>
				<input type="password" id="password" name="password" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<th>닉네임 :</th>
			<td>
				<input type="text" id="nickname" name="nickname" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<th>E-mail :</th>
			<td>
				<input type="email" id="email" name="email" style="width: 250px;" />
			</td>
		</tr>
	</table>
	<div align="center">
	<input type="button" id="doRegister" value="등록!" />
	<input type="reset" value="다시 쓰기" />
	<input type="button" id="cancle" value="취소" />
	</div>
</form>


