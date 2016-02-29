<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src = "/HumanResource/resource/js/jquery-1.12.1.js"></script>
<script type = "text/javascript">

   $(document).ready( function() {
      
      $("#addNewActor").click(function() {
         
         // 유효성 검사 혹은 Validation Check(id에 actionName 준것두 이걸 하기 위해서였음)
         
/*          if ( $("#actorName").val() == "" ) {
            alert("배우의 이름을 입력하세요!");
            return;
            
         } */
         
         var form = $("#addNewActorForm");
         //jQueryObject.attr("속성명", "속성값");
         //attr = attribute
         //메소드나 액션을 적을 때는 attr을 적어줌
         form.attr("method", "POST");
         form.attr("action", "/HumanResource/addNewActorAction");
         form.submit();
         // 데이터를 넘겨준다.(1번) > AddNewActorActionServlet. 으로 
         
      } );
      
   });

</script>
</head>
<body>
	<form id="addNewActorForm"> 
	
		${ ErrorMessage }
		<input type="text" id="actorName" name="actorName" />
		<input type="button" id="addNewActor" value="등록하기" />
	</form>
</body>
</html>