<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />
<c:set var="Userpicpath" value="${ sessionScope._MEMBER_.pic_path }" />
<c:set var="nowTeamId" value="${ sessionScope._TEAM_.teamId }" />
<script>
$(document).ready(function(){
	$("#myProgress").hide();
	$("#myBar").hide();
	  
	 $("#upload").click( function move() {
	    $("#myProgress").show();
		$("#myBar").show();
		var elem = document.getElementById("myBar"); 
	    var width = 0;
	    var id = setInterval(frame, 180);
	    function frame() {
	        if (width >= 100) {
	            clearInterval(id);
	        } else {
	            width++; 
	            elem.style.width = width + '%'; 
	        }
	    }
	});
}); 
</script>
<style>
.fg-line:not([class*=has-]):after {
    background: #ff4f3e;
}
</style>
<c:if test="${ nowTeamId ne null }">
<div class="card" style="background-color : #354052; overflow: hidden;">
	<div class="card-header" style="background-color: #496f7a;">
	    <h2 style="color :#323e4a; font-weight:bold; font-size: 20px;">Upload File
	    <button type="button" class="md md-help" data-trigger="hover" data-toggle="popover" data-placement="bottom" data-content="Upload Only TextFile ex.kakao, line"  style="border-radius :50%; margin-top:3px; background-color: #496f7a; border: 0; size: 50%;"></button>
	    </h2>
	</div>
	<div class="card-body card-padding">
	<div class="row">
	    <div class="col-sm-4">
	        <p class="f-500 c-black m-b-20" style="color: #959aa2;"></p>
	        <form id="textFileUpload" method="post" action="/insertChat" enctype="multipart/form-data">
	        <div class="fileinput fileinput-new" data-provides="fileinput">
	            <span class="btn btn-file m-r-10" style="background-color: #7f4a82; color:white; width: 100%;">
	                <span class="fileinput-new">Upload file</span>
	                <span class="fileinput-exists">Change</span>
	                <input type="file" name="chatText" value="file">
	            </span>
	            <span class="fileinput-filename" style="color: black;"></span>
	            <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="color: black;">&times;</a>
	        </div>
	        <br/>
	        <button class="btn" style="background-color: #ff4f3e; color:white; width: 112.266px;"type="submit" id="upload">save</button>
	        <br/>
	        <div id="myProgress">
				  <div id="myBar">
				  </div>
			</div>
			<br/>
	        </form>
	    </div>
	</div>
</div>
</div>
</c:if>