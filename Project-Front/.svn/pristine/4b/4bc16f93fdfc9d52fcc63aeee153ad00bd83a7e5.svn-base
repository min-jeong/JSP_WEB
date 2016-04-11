<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />
<c:set var="nowTeamId" value="${ sessionScope._TEAM_.teamId }" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#input").hide();
		
		$("#addEmail").click(function(){
			$("#input").show();
			$("#addFloor").append("<div class=\"input-group m-b-20\"><span class=\"input-group-addon\"><i class=\"md md-mail\"></i></span><div class=\"fg-line\"><input type=\"text\" class=\"form-control\" placeholder=\"Email Address\" id=\"email\" name=\"email\"></div></div>");
			
		});
		
	 	$("#input").click(function() {
			
			if( $("#teamName").val() ==""  ){
				swal("Team name is empty");
				return;
			}
			
			if ( $("#email").val() == "" ){
				alert("첫번째 이메일의 입력란은 반드시 입력해주세요");	
				return;
			}
			
			var form = $("#create");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/create"/>");
			form.submit();
		});  
	});
</script>		
<style>
.lv-avatar1 {
  width: 12px;
  height: 12px;
  border-radius: 50%;
  color: #FFF;
  text-align: center;
  line-height: 34px;
  font-size: 15px;
  margin-right: 15px;
  margin-top: 4px;
  padding: 0 !important;
  text-transform: uppercase;
}
</style>
<div id="team" class="card" style="background-color : #354052;">
   	<div class="card-header" style="background-color: #496f7a;">
	    <h2 style="color :#323e4a; font-weight:bold; font-size: 20px;">My Team
	    <button type="button" class="md md-help" data-trigger="hover" data-toggle="popover" data-placement="bottom" data-content="가입된 Team List"  style="border-radius :50%; background-color: #496f7a; border: 0; size: 50%;"></button>
	    </h2>
	    <a href="#step1" class="btn btn-float waves-effect" style="background-color: #71d1b2;" data-toggle="modal"  id="createTeam" >
		<i class="md md-add"></i>
		</a>
	</div>

		<div class="card-body" style="margin-left: 10px;">
			<c:forEach items="${ allTeams }" var="list">
			<c:if test="${ list.teamId eq nowTeamId }">
			<a href="/SetTeamSession?teamId=${ list.teamId }">
				<div class="listview lv-user m-t-20" style="background-color: #22252E; margin-left:-10px;">
				<div class="lv-item media" >
				    <div class="lv-avatar1 pull-left" style="background-color: #71d1b2; margin-left:10px;"></div>
				    <div class="media-body"> <!-- Optional container for demo porpose only -->
	           			<div class="lv-title" style="color : #ffffff; font-weight:bold; font-size: 15px;" >${ list.teamName } 
	           			<c:if test="${ list.leaderEmail eq Useremail }">
	           			   <img src="resource/img/king.png" width="23px" height="23px" style="margin-bottom: 5px; margin-left: 3px;">
	           			 </c:if>	<!-- 리더 이메일 빼고 리더 여부 추가/리더면 왕관모양? -->
	           			 </div>
	            	</div>
	            </div>
	            </div>	
			</a>
			</c:if>
			<c:if test="${ list.teamId ne nowTeamId }">
			<a href="/SetTeamSession?teamId=${ list.teamId }">
				<div class="listview lv-user m-t-20">
				<div class="lv-item media" >
				    <div class="lv-avatar1 pull-left" style="background-color: #71d1b2;"></div>
				    <div class="media-body"> <!-- Optional container for demo porpose only -->
	           			<div class="lv-title" style="color : #959aa2;  font-size: 15px;">${ list.teamName } 
	           			<c:if test="${ list.leaderEmail eq Useremail }">
	           			    <img src="resource/img/king.png" width="23px" height="23px" style="margin-bottom: 5px; margin-left: 3px;">
	           			 </c:if>	<!-- 리더 이메일 빼고 리더 여부 추가/리더면 왕관모양? -->
	           			 </div>
	            	</div>
	            </div>
	            </div>	
			</a>
			</c:if>
			</c:forEach>
	    </div>
</div>

		<div class="modal" id="step1" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
                <div class="modal-content">
                     <div class="modal-header">
                         <h4 class="modal-title" align="center">CREATE TEAM</h4>
                     </div>
						<div class="modal-body">
                        <form id="create">
                        <div class="form-wizard-basic fw-container">
                               <ul class="tab-nav text-center">
                                   <li class="active"><a href="#tab1" data-toggle="tab" >Step 1</a></li>
                                   <li><a href="#tab2" data-toggle="tab">Step 2</a></li>
                               </ul>
                        
                        		<div class="tab-content">
                                    <div class="tab-pane active" id="tab1">
	                                    <p class="f-500 c-black m-b-15">Input team name</p>
	                                    <div class="input-group">
		                                    <span class="input-group-addon"><i class="md md-person"></i></span>
	                                        <div class="fg-line">
	                                                <input type="text" class="form-control" placeholder="Team name" name="teamName" id="teamName">
	                                        </div>
                                        </div>
					        		</div>
					        		<div class="tab-pane fade" id="tab2">
						        		<div style="float: left; padding: 0px 50px 0px 0px;"><p class="f-500 c-black m-b-15">Send Invitation by e-mail</p></div>
						        							
						        			<div>
										<button type="button" class="btn" style="background-color: #ff4f3e; color: white;"id="addEmail"><i class="md md-arrow-forward"> ADD</i></button>
										</div>
										<br />
						        		<div id="addFloor">
						        		
						        		<!-- append로 생성된 email list가 들어가는 자리 -->
						        		
						        		</div>
										<div id="tab3"></div>	
										<div style="width: 30%; margin:auto;">							
								       <button class="btn" style="background-color: #ff4f3e; color: white;" id="input"><i class="md md-check">SEND</i></button>
								       </div>
									</div>
									<ul class="fw-footer pagination wizard">
                                        <li class="previous first"><a class="a-prevent" href="#tab1"><i class="md md-more-horiz"></i></a></li>
                                        <li class="previous"><a class="a-prevent" href="#tab1"><i class="md md-chevron-left"></i></a></li>
                                        <li class="next"><a class="a-prevent" href="#tab2"><i class="md md-chevron-right"></i></a></li>
                                        <li class="next last"><a class="a-prevent" href="#tab2"><i class="md md-more-horiz"></i></a></li>
                                    </ul>
									
								</div>
							</div>
						</form>
                    </div>
                 </div>
             </div>
		</div>
			
