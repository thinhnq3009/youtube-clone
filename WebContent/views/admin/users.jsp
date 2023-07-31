<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header-container">
    <jsp:include page="/components/admin/app-header.jsp"></jsp:include>
</div>
<div class="d-flex">
    <div class="guide-container  d-none d-md-block">
        <jsp:include page="/components/admin/app-guide.jsp"></jsp:include>
    </div>
    <div class="content-container flex-grow-1">
       <jsp:include page="/components/admin/table-user.jsp"></jsp:include>
    </div>
</div>
