<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">

<title>http://www.blueb.co.kr</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link href="./resource/css/style.css" rel="stylesheet" type="text/css" />
<script src="./resource/js/jquery.domenu-0.0.1.js"></script>


<script>
	$(document)
			.ready(
					function() {

						var updateOutput = function(e) {
							var list = e.length ? e : $(e.target), output = list
									.data('output');
							if (window.JSON) {
								output.val(window.JSON.stringify(list
										.nestable('serialize')));//, null, 2));
							} else {
								output
										.val('JSON browser support required for this demo.');
							}
						};

						$('#domenu')
								.domenu(
										{
											data : '[{"id":11,"title":"Item 11","http":""},{"id":10,"title":"Item 10","http":""},{"id":9,"title":"Item 9","http":""},{"id":6,"title":"Home","http":"","children":[{"id":5,"title":"Item 5","http":""},{"id":4,"title":"Item 4","http":"","children":[{"id":3,"title":"Item 3","http":""},{"id":2,"title":"Item 2","http":"","children":[{"id":7,"title":"Example","http":"http://google.com"},{"id":8,"title":"Item 8","http":""}]}]}]},{"id":1,"title":"Item 1","http":""}]'
										}).parseJson();

						$("#doWrite").click(
								function() {

									var form = $("#domenuForm");
									form.attr("method", "post");
									form.attr("action",
											"<c:url value="/IndexServlet" />");
									form.submit();

								});
					});
</script>
</head>
<body>
	<form id="domenuForm">

		<div class="dd" id="domenu">

			<button class="dd-new-item">+</button>
			<li class="dd-item-blueprint">
				<div class="dd-handle dd3-handle">Drag</div>
				<div class="dd3-content">
					<span>[item_name]</span>
					<button class="item-remove">&times;</button>
					<div class="dd-edit-box" style="display: none;">
						<input type="text" name="title" class="title" placeholder="name">
						<i>&#x270e;</i>
					</div>
				</div>
			</li>
			<ol class="dd-list">
			</ol>
		</div>
		<div>
			<button id="doWrite" class="btn btn-default">
				<i class="md md-done-all"></i> Done
			</button>
		</div>
	</form>



</body>
</html>
