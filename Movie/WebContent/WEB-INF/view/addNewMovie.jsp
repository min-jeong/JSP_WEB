<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js"/>"></script>
<script type="text/javascript">

$(document).ready (function() {
	
	/* 		$("#directors").click( function() {
				var selectedDirectors = "";
				$("#directors option:selected").each(function(index, data) {// data에는 값이 넘어오고 index는 몇번째인지
					selectedDirectors += data.text;
					selectedDirectors += "," 
				});
				$("#directorsName").text(selectedDirectors);
			}); */
			
	/* 		$("#addNewMovie").click( function() {
				var form = $("#addNewMovieForm");
				
				form.attr("method", "POST");
				form.attr("action", "/HumanResource/addNewMovieAction");
				form.submit();
			})
			//http://api.jquery.com/selected-selector/
			//http://api.jquery.com/checked-selector/
			
			$("#addNewMovieForm").hide();
	 		$("#addNewMovieForm").slideDown(5000);
			$("#addNewMovieForm").slideUp(5000); 
			$("#addNewMovieForm").fadeIn();
			$("#addNewMovieForm").fadeOut(); 
			
		
	*/
			$("#addNewMovie").click( function() {
				
				// Validation Check
				var movieTitle = $("#movieTitle").val();
				movieTitle = $.trim( movieTitle ); // side 의 공백을 날려버린다.
				if ( movieTitle == "" ) {
					alert("영화명을 입력하세요.");
					$("#movieTitle").focus();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var rate = $("#rate").val();
				rate = $.trim( rate ); // side 의 공백을 날려버린다.
				if ( rate == "" ) {
					alert("평점을 입력하세요.");
					$("#rate").focus();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				//rate = parseFloat(rate); //parseInt하면 소수점이 날라가기 때문에 parseFloat로 한다.
				if( isNaN(rate) ){
					alert("평점을 올바르게 입력하세요!\n평점은 소수점을 포함한 숫자로 적을 수 있습니다.");
					$("#rate").focus();
					return;
				}
				
				/* var isNumber = isNan(rate); //is not a number
				alert(isNumber);
				return; */
				
				var runningTime = $("#runningTime").val();
				runningTime = $.trim( runningTime ); // side 의 공백을 날려버린다.
				if ( runningTime == "" ) {
					alert("상영시간을 입력하세요.");
					$("#runningTime").focus();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				if( runningTime.length > 5 ) { // 한글영어숫자 모두 한 글자를 1로본다. 
					alert("상영시간을 올바르게 입력하세요.");
					$("#runningTime").focus();
					return;
				}
				
				var regExp = new RegExp("^[0-2][0-9]:[0-5][0-9]$"); //^는 반드시 [0-9]{1,2}의 문자열로 시작한다는 의미 , $는 반드시 [0-9]{1,2}의 문자열로 끝난다는 의미
				var isValidRunningTime = regExp.test( runningTime ); // side 의 공백을 날려버린다.
				if ( isValidRunningTime == false ) {
					alert("상영시간을 올바르게 입력하세요.");
					$("#runningTime").focus();
					return;
				}
				
				
				var openDate = $("#openDate").val();
				openDate = $.trim( openDate ); // side 의 공백을 날려버린다.
				if ( openDate == "" ) {
					alert("개봉일을 입력하세요.");
					$("#openDate").focus();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var grade = $(".grade:checked").val(); //class는 .으로 표현한다.
				grade = $.trim( grade ); // side 의 공백을 날려버린다.
				if ( grade == "" ) {
					alert("등급을 선택하세요.");
					$(".grade").fadeOut().fadeIn().fadeOut().fadeIn();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var directors = $("#directors option:selected").val();
				directors = $.trim( directors ); // side 의 공백을 날려버린다.
				if ( directors == "" ) {
					alert("감독을 선택하세요.");
					$("#directors").fadeOut().fadeIn().fadeOut().fadeIn();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var actors = $("#actors option:selected").val();
				actors = $.trim( actors ); // side 의 공백을 날려버린다.
				if ( actors == "" ) {
					alert("출연진을 선택하세요.");
					$("#actors").fadeOut().fadeIn().fadeOut().fadeIn();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var genres = $(".genres:checked").val(); //class는 .으로 표현한다.
				genres = $.trim( genres ); // side 의 공백을 날려버린다.
				if ( genres == "" ) {
					alert("장르를 선택하세요.");
					$(".genres").fadeOut().fadeIn().fadeOut().fadeIn();
					return; //밑에 꺼는 실행 안되게 막는다.
				}
				
				var form = $("#addNewMovieForm");
				form.attr("method", "POST");
				form.attr("action", "<c:url value="/addNewMovieAction" />");
				form.submit();
			});
			
		}); 

</script>
</head>
<body>

	<h1>영화 등록</h1>
	<hr/>
	<span class="errorCode">${ errorCode }</span>
	<form id="addNewMovieForm">
		영화명 : <input type="text" id="movieTitle" name="movieTitle" /><br/> 
		평점 : <input type="text" id="rate" name="rate" /><br/>
		상영시간 : <input type="text" id="runningTime" name="runningTime" />(ex.01:40 형식)<br/>
		개봉일 : <input type="date" id="openDate" name="openDate" /><br/>
		상영등급 : 
		
		<c:forEach items="${ gradeList }" var="grade">
		<input type="radio" class="grade" name="grade" value="${ grade.gradeId }" /> ${ grade.gradeTitle }
		</c:forEach>
		<br/>
		감독 : 
		<select id ="directors" name="directors" multiple="multiple">
			<c:forEach items="${ directorList }" var="director">
				<option value="${ director.directorId }">${ director.directorName }</option>
			</c:forEach>
		</select>
		<span id="directorsName"></span>
		
		<br/>
		출연진 :
		<select id ="actors" name="actors" multiple="multiple">
			<c:forEach items="${ actorList }" var="actor">
				<option value="${ actor.actorId }">${ actor.actorName }</option>
			</c:forEach>
		</select>
		<br/>
		장르 : 
		<c:forEach items="${ genreList }" var="genre">
			<input type="checkbox" class="genres" name="genres" value="${ genre.genreId }" />${ genre.genreTitle }
		</c:forEach>
		<br/>	
		<input type="button" id="addNewMovie" value="영화 등록" />
	</form>
</body>
</html>