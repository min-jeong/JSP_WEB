<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />
<c:set var="picName" value="${ sessionScope._MEMBER_.pic_name }" />
<!-- app.min.1css에서 Profile View 수정 -->
<div class="card profile-view" style="background-color: #354052; color : #ffffff;">
    <div class="pv-header" style="background-color: #354052; color : #ffffff;">
    <c:if test="${ picName  ne null }">
		<img src="/callImageServlet" class="pv-main" alt="">
	</c:if>
    <c:if test="${ picName  eq null }">
    	<img src="resource/img/notifications.png" class="pv-main" >
    </c:if>
    </div>
    
    <div class="pv-body" style="background-color: #354052; font-color : #ffffff;"> <!-- 폰트칼라안먹음 -->
        <h2 style="color : #ffffff;">${ Username }</h2>
        <small style="color : #ffffff;">${ Useremail } </small>
    </div>
</div>
                        

