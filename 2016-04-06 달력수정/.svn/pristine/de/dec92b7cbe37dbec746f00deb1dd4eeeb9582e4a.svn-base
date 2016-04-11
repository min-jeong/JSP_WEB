<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#input").click(function() {
			if( $("#teamName").val() ==""  ){
				swal("Team name is empty");
				return;
			}
			
			if ( $("#email").val() == "" ){
				alert("Member ID is empty");	
				return;
			}
			
			var form = $("#create");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/create"/>");
			form.submit();
		});
	});
</script>		

<div id="team" class="card">
   	<div class="card-header bgm-blue">
	    <h2>Team List</h2>
	    <a href="#step1" class="btn bgm-red btn-float waves-effect" data-toggle="modal"  id="createTeam" >
		<i class="md md-add"></i>
		</a>
	</div>

		<div class="card-body">
			<c:forEach items="${ allTeams }" var="list">
			<a href="/SetTeamSession?teamId=${ list.teamId }">
				<div class="listview lv-user m-t-20">
				<div class="lv-item media">
				    <div class="lv-avatar bgm-red pull-left">t</div>
				    <div class="media-body"> <!-- Optional container for demo porpose only -->
	           			<div class="lv-title">${ list.teamName } 
	           			<c:if test="${ list.leaderEmail eq Useremail }">
	           			   Y
	           			 </c:if>	<!-- 리더 이메일 빼고 리더 여부 추가/리더면 왕관모양? -->
	           			 </div>
	            	</div>
	            </div>
	            </div>	
			</a>
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
                                   <li class="active"><a href="#tab1" data-toggle="tab" >first</a></li>
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
						        		<p class="f-500 c-black m-b-15">Select team member</p>
						        		<select class="tag-select" multiple data-placeholder="member email" name="email">
						        			<c:forEach items="${ allMember }" var="mem">
						        				<c:if test="${ mem.email eq Useremail }">
						        					<option value="${ mem.email }" disabled="disabled"> ${ mem.email }</option>
						        				</c:if>
		                                        <c:if test="${ mem.email ne Useremail }">
						        					<option value="${ mem.email }" > ${ mem.email }</option>
						        				</c:if>
	                                         </c:forEach>
                                    	</select>
						        		
										<!-- <i class="md md-person"></i><p>초대원 1</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 2</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 3</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 4</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 5</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 6</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 7</p><input type="text" name="email" />
										<i class="md md-person"></i><p>초대원 8</p><input type="text" name="email" /> -->
								        <input type="button" id="input" value="완료!" />
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
			
