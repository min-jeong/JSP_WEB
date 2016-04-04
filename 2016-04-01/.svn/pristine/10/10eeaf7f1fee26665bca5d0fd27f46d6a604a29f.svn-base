<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
	
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>PingPong Chat</title>
        <!-- Vendor CSS -->
        <link href="${root}/resource/vendors/animate-css/animate.min.css" rel="stylesheet">
        <link href="${root}/resource/vendors/fullcalendar/fullcalendar.css" rel="stylesheet">
        <link href="${root}/resource/vendors/sweet-alert/sweet-alert.min.css" rel="stylesheet">
        <link href="${root}/resource/vendors/light-gallery/lightGallery.min.css" rel="stylesheet">
        <link href="${root}/resource/vendors/material-icons/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="${root}/resource/vendors/socicon/socicon.min.css" rel="stylesheet">
            
        <!-- CSS -->
        <link href="${root}/resource/css/app.min.1.css" rel="stylesheet">
        <link href="${root}/resource/css/app.min.2.css" rel="stylesheet">
        <link href="${root}/resource/css/display.property.css" rel="stylesheet">
        <link href="${root}/resource/css/profile.css" rel="stylesheet">
   	    <link href="${root}/resource/vendors/light-gallery/hovereffect.css" rel="stylesheet">
   	    
   	    <!-- Scrollbar CSS, Script -->
   	    <link rel="stylesheet" href="resource/css/jquery.mCustomScrollbar.css" />
   	    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="/resource/js/jquery.mCustomScrollbar.concat.min.js"></script>
		
        <!-- Javascript Libraries -->
        <script src="resource/js/jquery-2.1.1.min.js"></script>
        <script src="resource/js/bootstrap.min.js"></script>
        
        <script src="resource/vendors/nicescroll/jquery.nicescroll.min.js"></script>
        <script src="resource/vendors/auto-size/jquery.autosize.min.js"></script>
        <script src="resource/vendors/bootgrid/jquery.bootgrid.min.js"></script>
        <script src="resource/vendors/waves/waves.min.js"></script>
        <script src="resource/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
        <script src="resource/vendors/sweet-alert/sweet-alert.min.js"></script>
        
        <script src="resource/js/functions.js"></script>
        <script src="resource/js/demo.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){
                //Basic Example
                $("#data-table-basic").bootgrid({
                    css: {
                        icon: 'md icon',
                        iconColumns: 'md-view-module',
                        iconDown: 'md-expand-more',
                        iconRefresh: 'md-refresh',
                        iconUp: 'md-expand-less'
                    },
                });
                
                $("#upload").click( function move() {
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
::-webkit-scrollbar {width: 8px; height: 8px; border: 3px solid #fff; }
::-webkit-scrollbar-button:start:decrement, ::-webkit-scrollbar-button:end:increment {display: block; height: 10px; background: url('./images/bg.png') #efefef}
::-webkit-scrollbar-track {background: #efefef; -webkit-border-radius: 10px; border-radius:10px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.2)}
::-webkit-scrollbar-thumb {height: 50px; width: 50px; background: rgba(0,0,0,.2); -webkit-border-radius: 8px; border-radius: 8px; -webkit-box-shadow: inset 0 0 4px rgba(0,0,0,.1)}
html{scrollbar-3dLight-Color: #efefef; scrollbar-arrow-color: #dfdfdf; scrollbar-base-color: #efefef; scrollbar-Face-Color: #dfdfdf; scrollbar-Track-Color: #efefef; scrollbar-DarkShadow-Color: #efefef; scrollbar-Highlight-Color: #efefef; scrollbar-Shadow-Color: #efefef;}
#myProgress {
    position: relative;
    width: 100%;
    height: 30px;
    background-color: white;
}
#myBar {
    position: absolute;
    width: 1%;
    height: 100%;
    background-color: green;
}
</style>

</head>
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />
<c:set var="root" value="${pageContext.request.contextPath}" /> 
<body id="content">
       <header id="header">
            <ul class="header-inner">
                <li>
                    <div class="line-wrap">
                        <div class="line top"></div>
                        <div class="line center"></div>
                        <div class="line bottom"></div>
                    </div>
                </li>
            
                <li class="logo hidden-xs">
                    <a class="orgin" href="/goMain">PingPong Chat</a>
                </li>
               		 
              <li class="pull-right">
                <ul class="top-menu">
                	<li class="logo" style="position: relative; top: 1px;">
                    	<a class="my" href="/goMain">
                    	<i class="md-timer-auto" style="width: 200%; height: 200%;"> Welcome ${ Username }  ( ${ Useremail } ) </i></a>
                	</li> 
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="tm-settings" href=""></a>
                        <ul class="dropdown-menu dm-icon pull-right">
                       		<li>
                            	<a href="/doLogout"><i class="md md-history"></i> Logout</a>
                            </li>
                            <li>
                                <a data-action="fullscreen" href=""><i class="md md-fullscreen"></i> Toggle Fullscreen</a>
                            </li>
                            <li>
                                <a href="/doAboutProfile"><i class="md md-person"></i> Privacy Settings</a>
                            </li>
                            
                        </ul>
                    </li>
                    </ul>
                </li>
            </ul>
        </header>
        
        <section id="main">
	        <div id="left_menu">
				<div id="profile">
					<jsp:include page="/WEB-INF/view/view/profile.jsp"></jsp:include>
				</div>
				<div id="team_menu">
					<jsp:include page="/WEB-INF/view/team/team_menu.jsp"></jsp:include>
				</div>
				<div id="mine">
					<jsp:include page="/WEB-INF/view/member/mine.jsp"></jsp:include>
				</div>
			</div>
			<div id="main_menu">
				<div id="defaultPage">
					<%-- <div class="btn-group btn-group-justified" role="group" aria-label="close">
					         <div class="btn-group" role="group">
					             <a class="btn btn-default" href="/teamInfo">Team Information</a>
					         </div>
					          <div class="btn-group" role="group">
					             <a class="btn btn-default" href="${root}/controlMain?page=${PageUtil.chatCalendar}">Chat By Calendar</a>
					         </div>
					         <div class="btn-group" role="group">
					             <a class="btn btn-default" href="${root}/controlMain?page=${PageUtil.chatMember}">Chat By Member</a>
					         </div>
					         <div class="btn-group" role="group">
					             <a class="btn btn-default" href="${root}/controlMain?page=${PageUtil.propertyMember}">Property By Member</a>
					    </div>
					</div> --%>
					<ul class="tab-nav tn-justified">
					    <li class="waves-effect"><a href="/teamInfo">Team Information</a></li>
					    <li class="active waves-effect"><a href="/chatCalendar">Chat By Calendar</a></li>
					    <li class="waves-effect"><a href="/chatMember">Chat By Member</a></li>
					    <li class="waves-effect"><a href="/propertyMember">Property By Member</a></li>
					</ul>
					<div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="home11">
					          <div class="block-header">
					              <h2>Buttons</h2>
					          
					              <ul class="actions">
					                  <li>
					                      <a href="">
					                          <i class="md md-trending-up"></i>
					                      </a>
					                  </li>
					                  <li>
					                      <a href="">
					                          <i class="md md-done-all"></i>
					                      </a>
					                  </li>
					                  <li class="dropdown">
					                      <a href="" data-toggle="dropdown">
					                          <i class="md md-more-vert"></i>
					                      </a>
					          
					                      <ul class="dropdown-menu dropdown-menu-right">
					                          <li>
					                              <a href="">Refresh</a>
					                          </li>
					                          <li>
					                              <a href="">Manage Widgets</a>
					                          </li>
					                          <li>
					                              <a href="">Widgets Settings</a>
					                          </li>
					                      </ul>
					                  </li>
					              </ul>
					          
					          </div>
					      
					          <div class="card">
					              <div class="card-header">
					                  <h2>Basic Examples <small>Use any of the available button classes to quickly create a styled button.</small></h2>
					          
					                  <ul class="actions">
					                      <li class="dropdown action-show">
					                          <a href="" data-toggle="dropdown">
					                              <i class="md md-more-vert"></i>
					                          </a>
					          
					                          <div class="dropdown-menu pull-right">
					                              <p class="p-20">
					                                  You can put anything here
					                              </p>
					                          </div>
					                      </li>
					                  </ul>
					              </div>
					          
					              <div class="card-body card-padding">
					                  <p class="f-500 c-black m-b-20">Bootstrap Color Schemes</p>
					                  
					                  <div class="btn-demo">
					                      <button class="btn btn-default">Default</button>
					                      <button class="btn btn-info">Info</button>
					                      <button class="btn btn-primary">Primary</button>
					                      <button class="btn btn-success">Success</button>
					                      <button class="btn btn-warning">Warning</button>
					                      <button class="btn btn-danger">Danger</button>
					                  </div>
					                  
					                  <br/>
					                  <br/>
					                  
					                  <p class="f-500 c-black m-b-20">Optional Material Design Colors</p>
					                  
					                  <div class="btn-colors btn-demo"> Optional container for demo porpose only
					                          <button class="btn bgm-cyan">Cyan</button>
					                          <button class="btn bgm-teal">Teal</button>
					                          <button class="btn bgm-amber">Amber</button>
					                          <button class="btn bgm-orange">Orange</button>
					                          <button class="btn bgm-deeporange">Deep Orange</button>
					                          <button class="btn bgm-red">Red</button>
					                          <button class="btn bgm-pink">Pink</button>
					                          <button class="btn bgm-lightblue">Light Blue</button>
					                          <button class="btn bgm-blue">Blue</button>
					                          <button class="btn bgm-indigo">Indigo</button>
					                          <button class="btn bgm-lime">Lime</button>
					                          <button class="btn bgm-lightgreen">Light Green</button>
					                          <button class="btn bgm-green">Green</button>
					                          <button class="btn bgm-purple">Purple</button>
					                          <button class="btn bgm-deeppurple">Deep Purple</button>
					                          <button class="btn bgm-gray">Gray</button>
					                          <button class="btn bgm-bluegray">Blue Gray</button>
					                          <button class="btn bgm-black">Black</button>
					                      </div>
					                      
					                      <br/>
					                      <br/>
					                      
					                      <p class="f-500 c-black m-b-5">Button Sizes</p>
					                      <small>Fancy larger or smaller buttons? Add the button sizing classes.</small>
					                      
					                      <br/>
					                      <br/>
					                      
					                      <div class="btn-demo">
					                          <button class="btn btn-primary btn-lg">Large</button>
					                          <button class="btn btn-primary">Default</button>
					                          <button class="btn btn-primary btn-sm">Small</button>
					                          <button class="btn btn-primary btn-xs">Extra Small</button>
					                      </div>
					
					                      <br/>
					                      <br/>
					                      
					                      <p class="f-500 c-black m-b-20">Disable Stat</p>
					                      
					                      <div class="btn-demo">
					                          <button class="btn btn-default" disabled="disabled">Default</button>
					                          <button class="btn btn-info" disabled="disabled">Info</button>
					                          <button class="btn btn-primary" disabled="disabled">Primary</button>
					                          <button class="btn btn-success" disabled="disabled">Success</button>
					                          <button class="btn btn-warning" disabled="disabled">Warning</button>
					                          <button class="btn btn-danger" disabled="disabled">Danger</button>
					                      </div>
					                  </div>
					              </div>
				      		</div>
				      <div role="tabpanel" class="tab-pane" id="profile11">
				      2번
				      </div>
				      <div role="tabpanel" class="tab-pane" id="messages11">
				      3번
				      </div>
				      <div role="tabpanel" class="tab-pane" id="settings11">
				      4번
				      </div>
				    </div>
				</div>
			</div>
			<div id="right_menu">
				<div id="calendar">
					<jsp:include page="/WEB-INF/view/calendar/calendar.jsp"></jsp:include>
				</div>
				<div id="chatbyMem">
					<jsp:include page="/WEB-INF/view/chat/chat_mem.jsp"></jsp:include>
				</div>
				<div id="chatbyKeyword">
					<jsp:include page="/WEB-INF/view/chat/chat_keyword.jsp"></jsp:include>
				</div>
			</div>
	    <div class="clear"></div>
		</section>
	</body>
</html>