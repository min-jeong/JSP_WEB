<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Material Admin</title>

<!-- Vendor CSS -->
<link href="${root}/resource/vendors/animate-css/animate.min.css"
	rel="stylesheet">
<link href="${root}/resource/vendors/fullcalendar/fullcalendar.css"
	rel="stylesheet">
<link href="${root}/resource/vendors/sweet-alert/sweet-alert.min.css"
	rel="stylesheet">
<link
	href="${root}/resource/vendors/material-icons/material-design-iconic-font.min.css"
	rel="stylesheet">
<link href="${root}/resource/vendors/socicon/socicon.min.css"
	rel="stylesheet">

<!-- CSS -->
<link href="${root}/resource/css/app.min.1.css" rel="stylesheet">
<link href="${root}/resource/css/app.min.2.css" rel="stylesheet">
<link href="${root}/resource/css/bottom.css" rel="stylesheet">

</head>

<body>
	<section id="main">

		<section id="content">
			<div class="container">
				<div id="calendar"></div>
				<div id="bottom">
					<div id="contain">
						<button type="button" class="btn btn-success"
							data-toggle="collapse" data-target="#demo">
							<span class="glyphicon glyphicon-collapse-down"></span> Open
						</button>
						<div id="demo" class="collapse">
							<br />
							<div id="eventbox">
								<div id="event">
									<input readonly type="text" id="noticename"
										style="width: 100%;" /><br>
								</div>
								<div id="contents">
									<input readonly type="text" id="noticecontent"
										style="width: 100%; height: 123px;" />
								</div>
							</div>
						</div>
					</div>
					<!-- Add event -->
					<div class="modal fade" id="addNew-event" data-backdrop="static"
						data-keyboard="false">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Add an Event</h4>
								</div>
								<div class="modal-body">
									<form class="addEvent" role="form">
										<div class="form-group">
											<label for="eventName">Event Name</label>
											<div class="fg-line">
												<input type="text" class="input-sm form-control"
													id="eventName" placeholder="새로운 공지를 입력하세요.">
											</div>
										</div>

										<div class="form-group">
											<label for="eventName">Tag Color</label>
											<div class="event-tag">
												<span data-tag="bgm-teal" class="bgm-teal selected"></span>
												<span data-tag="bgm-red" class="bgm-red"></span> <span
													data-tag="bgm-pink" class="bgm-pink"></span> <span
													data-tag="bgm-blue" class="bgm-blue"></span> <span
													data-tag="bgm-lime" class="bgm-lime"></span> <span
													data-tag="bgm-green" class="bgm-green"></span> <span
													data-tag="bgm-cyan" class="bgm-cyan"></span> <span
													data-tag="bgm-orange" class="bgm-orange"></span> <span
													data-tag="bgm-purple" class="bgm-purple"></span> <span
													data-tag="bgm-gray" class="bgm-gray"></span> <span
													data-tag="bgm-black" class="bgm-black"></span>
											</div>
										</div>

										<input type="hidden" id="getStart" /> <input type="hidden"
											id="getEnd" />
									</form>
								</div>

								<div class="modal-footer">
									<button type="submit" class="btn btn-link" id="addEvent">Add
										Event</button>
									<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>

					<!-- Modify event -->
					<div class="modal fade" id="modify-event" data-backdrop="static"
						data-keyboard="false">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">Modify an Event</h4>
								</div>
								<div class="modal-body">
									<form class="addEvent" role="form">
										<div class="form-group">
											<label for="eventName">New Notice</label>
											<div id="new">
												<input type="text" class="input-sm form-control"
													id="modifyEventName" placeholder="새로운 공지를 입력하세요.">
											</div>
										</div>
										<div class="form-group">
											<label for="eventName">Current Notice</label>
											<div id="current">
												<input type="text" class="input-sm form-control"
													id="currentEventName">
											</div>
										</div>

										<div class="form-group">
											<label for="eventName">Tag Color</label>
											<div class="event-tag">
												<span data-tag="bgm-teal" class="bgm-teal selected"></span>
												<span data-tag="bgm-red" class="bgm-red"></span> <span
													data-tag="bgm-pink" class="bgm-pink"></span> <span
													data-tag="bgm-blue" class="bgm-blue"></span> <span
													data-tag="bgm-lime" class="bgm-lime"></span> <span
													data-tag="bgm-green" class="bgm-green"></span> <span
													data-tag="bgm-cyan" class="bgm-cyan"></span> <span
													data-tag="bgm-orange" class="bgm-orange"></span> <span
													data-tag="bgm-purple" class="bgm-purple"></span> <span
													data-tag="bgm-gray" class="bgm-gray"></span> <span
													data-tag="bgm-black" class="bgm-black"></span>
											</div>
										</div>

										<input type="hidden" id="modifyGetStart" /> <input
											type="hidden" id="modifyGetEnd" />
									</form>
								</div>

								<div class="modal-footer">
									<button type="submit" class="btn btn-link" id="modifyEvent">Modify
										Notice</button>
									<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</section>

	<!-- Javascript Libraries -->
<%-- 	<script src="${root}/resource/js/jquery-2.1.1.min.js"></script>
	<script src="${root}/resource/js/bootstrap.min.js"></script> --%>
	<script
		src="${root}/resource/vendors/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="${root}/resource/vendors/fullcalendar/lib/moment.min.js"></script>
	<script src="${root}/resource/vendors/fullcalendar/fullcalendar.min.js"></script>
	<script src="${root}/resource/vendors/waves/waves.min.js"></script>
	<script
		src="${root}/resource/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
	<script src="${root}/resource/vendors/sweet-alert/sweet-alert.min.js"></script>

	<%-- <script src="${root}/resource/js/functions.js"></script>
	<script src="${root}/resource/js/demo.js"></script> --%>
	<script src="${root}/resource/js/json2.js"></script>

	<script type="text/javascript">
            $(document).ready(function() {
            	var today = new Date();
                var date = new Date();
                var start = new Date();
                var end = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();

                var cId = $('#calendar'); //Change the name if you want. I'm also using thsi add button for more actions

                //Generate the Calendar
                cId.fullCalendar({
                    header: {
                        right: '',
                        center: 'prev, title, next',
                        left: ''
                    },
                    
                     defaultView: 'month',

                    dayRender: function (date, cell) {
                        
                        end.setDate(today.getDate()+7);
                        var cellDate = $(cell).data('date');
                        var todayDate;
                        if(m+1 < 10 ){
                        	todayDate = y+'-'+'0'+(m+1)+'-'+d;
						}else {
							todayDate = y+'-'+(m+1)+'-'+d;
						}
                        if ( cellDate == todayDate) {
                            cell.css("background-color", "#a5cefc");
                        }
                        
                       /*  var start = new Date();
                        start.setDate(today.getDate()+1);
                        
                        
                        while(start <= end){
                            
                          //alert(start + "\n" + tomorrow);
                            if(start.getDate() == date.getDate()){
                                cell.css("background-color", "yellow");
                            }
                    
                            
                           var newDate = start.setDate(start.getDate() + 1);
                           start = new Date(newDate);
                        }         */
                    },   

                    fixedWeekCount: false,
                    contentHeight: 600,
                    eventLimit: true,
                    theme: true, //Do not remove this as it ruin the design
                    selectable: true,
                    selectHelper: true,
                    select: true,
                    editable: true,

                   
                    //Add Events
                    events: [
                        {
                        	/* <span id="title" style="cursor: pointer;">'Hangout with friends'</span> */
                        	title: 'Hangout with friends',
                            start: new Date(y, m, 1),
                            end: new Date(y, m, 2),
                            className: 'bgm-cyan',
                            description: 'This is a cool event',
                            id: "2"
                        },
                        {
                            title: 'Meeting with client',
                            start: new Date(y, m, 10),
                            allDay: true,
                            className: 'bgm-red'
                        },
                        {
                            title: 'Repeat Event',
                            start: new Date(y, m, 18),
                            allDay: true,
                            className: 'bgm-blue'
                        },
                        {
                            title: 'Semester Exam',
                            start: new Date(y, m, 20),
                            end: new Date(y, m, 23),
                            className: 'bgm-green'
                        },
                        {
                            title: 'Soccor match',
                            start: new Date(y, m, 5),
                            end: new Date(y, m, 6),
                            className: 'bgm-purple'
                        },
                        {
                            title: 'Coffee time',
                            start: new Date(y, m, 21),
                            className: 'bgm-orange'
                        },
                        {
                            title: 'Job Interview',
                            start: new Date(y, m, 5),
                            className: 'bgm-dark'
                        },
                        {
                            title: 'IT Meeting',
                            start: new Date(y, m, 5),
                            className: 'bgm-cyan'
                        },
                        {
                            title: 'Brunch at Beach',
                            start: new Date(y, m, 1),
                            className: 'bgm-purple'
                        },
                        {
                            title: 'Live TV Show',
                            start: new Date(y, m, 15),
                            end: new Date(y, m, 17),
                            className: 'bgm-orange'
                        },
                        {
                            title: 'Software Conference',
                            start: new Date(y, m, 25),
                            end: new Date(y, m, 28),
                            className: 'bgm-blue'
                        },
                        {
                            title: 'Coffee time',
                            start: new Date(y, m, 30),
                            className: 'bgm-orange'
                        },
                        {
                            title: 'Job Interview',
                            start: new Date(y, m, 30),
                            className: 'bgm-dark'
                        },
                        {
                            title: '영어',
                            start: new Date(y, m, 23),
                            className: 'bgm-orange'
                        },
                    ],
                 //Cancel Event
                 eventRender: function(event, element) {
                        console.log(element);
                          var e = element
                                         .prepend("<span class='closeon'>&#10005;</span>");
                          //element.find('.fc-title').append("<br/>" + event.description);
                          
                          e.children('.closeon')
                             .attr('data-event-id', event._id) 
                             .click( function() {
                                var id = $(this).attr('data-event-id');
                                $('#calendar').fullCalendar('removeEvents',id);
                             });
                         /*  element.qtip({
                              content: event.description,
                              style: {
	                                  background: 'black',
	                                  color: '#FFFFFF'
                             		 },
                              position: {
                                 	 corner: {
			                                      target: 'center',
			                                      tooltip: 'bottomMiddle'
                                  			 }
                             			 }
                          }); */
                        },
                        
                   //event contents
                    /*  eventRender: function(event, element) {
					        element.qtip({
					            content: event.description
					        });
					    }, */
                     //Highlight Event
                         /*  eventRender: function(event, element, view) {
                            // event._id gets auto-populated, either event.id or auto-generated value
                            element.attr('data-id', event._id);
                            toggleClass(event._id);
                          }, 
                          eventClick: function(event, jsEvent, view) {
                            toggleClass(event._id);
                          }, */

                    //day click
                   /*  dayClick: function(date, jsEvent, view) {
				        alert('Clicked on: ' + date.format());
   					}, */
                          
                    //On Day Select
                  select: function(start, end, allDay) {
                        //$('#addNew-event').modal('show');
                        $('#addNew-event input:text').val('');
                        $('#current input:text').val('');
                        $('#getStart').val(start);
                        $('#getEnd').val(end);
                        var moment = $('.callender_area').fullCalendar('stickySource.title');
                    },
                    eventClick: function(calEvent, jsEvent, view) {
						
                    	// $('#modify-event').modal('show');
                    	$('#new input:text').val('');
                        $('#current input:text').val(calEvent.title);
                        $('#event input:text').val('◎ 카톡 공지:   ' + calEvent.title);
                        $('#contents input:text').val('◎ 카톡 내용:   ' + calEvent.description);
                        $('#modifyGetStart').val(calEvent.start);
                        $('#modifyGetEnd').val(calEvent.end);
                        //alert(calEvent.id);
                        //alert(calEvent.title);
                        //alert(calEvent.description);

                        // change the border color just for fun
                        $(this).css('border-color', 'red');

                    }
                });

                //Create and ddd Action button with dropdown in Calendar header. 
                var actionMenu = '<ul class="actions actions-alt" id="fc-actions">' +
                                    '<li class="dropdown">' +
                                        '<a href="" data-toggle="dropdown"><i class="md md-more-vert"></i></a>' +
                                        '<ul class="dropdown-menu dropdown-menu-right">' +
                                            '<li class="active">' +
                                                '<a data-view="month" href="">Month View</a>' +
                                            '</li>' +
                                            '<li>' +
                                                '<a data-view="basicWeek" href="">Week View</a>' +
                                            '</li>' +
                                            '<li>' +
                                                '<a data-view="agendaWeek" href="">Agenda Week View</a>' +
                                            '</li>' +
                                            '<li>' +
                                                '<a data-view="basicDay" href="">Day View</a>' +
                                            '</li>' +
                                            '<li>' +
                                                '<a data-view="agendaDay" href="">Agenda Day View</a>' +
                                            '</li>' +
                                        '</ul>' +
                                    '</div>' +
                                '</li>';
                 
                /*  var today ='<ul class="actions actions-alt" id="todays">' +
                 			'</ul>'; */
	                              
                cId.find('.fc-toolbar').append(actionMenu);
              	/* cId.find('.fc-toolbar').append(today); */
                
              //Hightlight Event
               function toggleClass(id) {
                          /* Find all segments for the specific event and toggle a class */
                          var $event = $('a.fc-event[data-id="' + id + '"]');
                          $('a.my-highlight').each(function() {
                            $(this).toggleClass('my-highlight');
                          });
                          $.each($event, function() {
                            $(this).toggleClass('my-highlight');
                          });
                        }
              
                //Event Tag Selector
               (function(){
                    $('body').on('click', '.event-tag > span', function(){
                        $('.event-tag > span').removeClass('selected');
                        $(this).addClass('selected');
                    });
                })();
            
                //calendar collapse
               (function(){
            	   $("#demo").on("hide.bs.collapse", function(){
            	     $(".btn").html('<span class="glyphicon glyphicon-collapse-down"></span> Open');
            	   });
            	   $("#demo").on("show.bs.collapse", function(){
            	     $(".btn").html('<span class="glyphicon glyphicon-collapse-up"></span> Close');
            	   });
            	 });
	
                var jsonData3 = {};
                //Add new Event
                $('body').on('click', '#addEvent', function(){
                    var eventName = $('#eventName').val();
                    var tagColor = $('.event-tag > span.selected').attr('data-tag');
                  
                    if (eventName != '') {
                    	  $.post("/calendar"
                                  , { 
                    		  			"eventId" : eventId,
                                  		"title" : title,
                                  		"description" : description,
                                  		"className" : className 
                                  	}
                                  , function(data) {
	                                  	try{
	              							jsonData3 = JSON.parse(data);
	              							alert("정보가 입력되었습니다.");
		              						location.href="/return";
	              						}
	              						catch(e) {
	              							alert("예상치 못한 에러가 발생했습니다. 관리자에게 문의하세요.");
	              						}
                                  });
                        //Render Event
                        $('#calendar').fullCalendar('renderEvent',{
                            title: eventName,
                            start: $('#getStart').val(),
                            end:  $('#getEnd').val(),
                            allDay: true,
                            className: tagColor
                            
                        },true ); //Stick the event
                        
                        $('#addNew-event form')[0].reset();
                        $('#addNew-event').modal('hide');
                        
                    }
                    else {
                        $('#eventName').closest('.form-group').addClass('has-error');
                    }
                });
                
                //today click
                    $('#my-today-button').click(function() {
                    $('#calendar').fullCalendar('today');
                });
                
                // Modify an Event
                $('body').on('click', '#modifyEvent', function(){
                	
                	$.post("/calendar", "")
                    var eventName = $('#modifyEventName').val();
                    var tagColor = $('.event-tag > span.selected').attr('data-tag');
                    
                    if (eventName != '') {
                    	<%//TODO 이벤트 정보를 AJAX로 보내서 DB에 저장해야함%>
                        //Render Event
                        $('#calendar').fullCalendar('renderEvent',{
                            title: eventName,
                            start: $('#modifyGetStart').val(),
                            end:  $('#modifyGetEnd').val(),
                            allDay: true,
                            className: tagColor
                        }, true ); //Stick the event
                        
                        $('#modify-event form')[0].reset();
                        $('#modify-event').modal('hide');
                        
                    }
                    else {
                        $('#modifyEventName').closest('.form-group').addClass('has-error');
                    }
                });
				
                //confirm cencel
                /*  $('body').on('click', '#modifyEvent', function(){
                    var eventName = $('#modifyEventName').val();
                    var tagColor = $('.event-tag > span.selected').attr('data-tag');
                        
                    $('#modifyEventName').closest('.form-group').addClass('has-error');
                }); */
                //Calendar views
                $('body').on('click', '#fc-actions [data-view]', function(e){
                    e.preventDefault();
                    var dataView = $(this).attr('data-view');
                    
                    $('#fc-actions li').removeClass('active');
                    $(this).parent().addClass('active');
                    cId.fullCalendar('changeView', dataView);
                });
                
                /* $('body').on('click', '#todays', function(e){
                    e.preventDefault();
                   
                }); */
                
                /* $("body").on("click", ".fc-title", function() {
        			alert($(this).html());
        		}); */
        		
        		$('body').on('click', '#editButton', function(e){

        			var currentNotice = $("#currentEventName").val();
        			
        			var button = $("#editButton");
        			//console.log(currentNotice);
        			if (currentNotice != ""  ) { 
        				button.attr("data-target","#modify-event");
        			}
        			else {
    	            	button.attr("data-target","#addNew-event");
        			} 
        				
                });
            });
        </script>
</body>
</html>