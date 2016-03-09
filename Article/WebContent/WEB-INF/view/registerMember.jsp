<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
	    
	    $("#addNewMember").click(function() {
	    	
			var id = $("#id").val();
			   id = $.trim( id );
			      if ( id == "" ) {
			       alert("id을 입력하세요!");
			       $("#id").focus();
			       return;
			      }
	       
	       var nickName = $("#nickName").val();
	       nickName = $.trim( nickName );
           if ( nickName == "" ) {
	           alert("NICKNAME을 입력하세요!");
	           $("#nickName").focus();
	           return;
           }
           
           var password = $("#password").val();
           password = $.trim( password );
           if ( password == "" ) {
	           alert("비밀번호를 입력하세요!");
	           $("#password").focus();
	           return;
           }
           
           var email = $("#email").val();
           email = $.trim( email );
           if ( email == "" ) {
	           alert("이메일을 입력하세요!");
	           $("#email").focus();
	           return;
           }
	   
	       var form = $("#addNewMemberForm");
	       form.attr("method", "POST");
	       form.attr("action", "/addNewMember");
	       form.submit();
	       
	    } );
	    
	 });
</script>
</head>
<body>
	<h1> 회원가입 </h1>
	<hr/>
	<form id="addNewMemberForm">
		ID : <input type="text" id="id" name="id" /><br/>
		NICK NAME : <input type="text" id="nickName" name="nickName" /><br/>
		PASSWORD : <input type="text" id="password" name="password" /><br/>
		EMAIL : <input type="text" id="email" name="email" /><br/>
		
		<input type="button" id="addNewMember" value="회원가입" />
	</form>
</body>
</html>