<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="Username" value="${ sessionScope._MEMBER_.name }" />
<c:set var="Useremail" value="${ sessionScope._MEMBER_.email }" />
<c:set var="picName" value="${ sessionScope._MEMBER_.pic_name }" />
<!-- app.min.1css에서 Profile View 수정 -->
<div class="card profile-view">
    <div class="pv-header">
        <img src="resource/img/update/${ picName }" class="pv-main" alt="">
    </div>
    
    <div class="pv-body">
        <h2>${ Username }</h2>
        <small>${ Useremail } </small>
    </div>
</div>
                        

