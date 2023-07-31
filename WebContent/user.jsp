<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vn">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/assets/image/favicon.ico"
	type="image/x-icon" />

<!-- lib css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/libs/bootstrap-icons/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/libs/bootstrap/dist/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/libs/wowjs/css/libs/animate.css" />
<!-- lib css -->

<!-- Customize CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/global-style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/default-layout.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/loading.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/404-page.css" />

<link rel="stylesheet" href="" />
<!-- Customize CSS -->

<!-- libs -->
<script
	src="${pageContext.request.contextPath}/assets/libs/jquery/dist/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/libs/@popperjs/core/dist/umd/popper.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/libs/bootstrap/dist/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/libs/jquery-validation/dist/jquery.validate.js"></script>
<!-- libs -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-header/app-header.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-guide/app-guide.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/guide-item/guide-item.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-content/app-content.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-watch/app-watch.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-history/app-history.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-library/app-library.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-login/app-login.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-signup/app-signup.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/reset-password/reset-password.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/new-password/new-password.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-profile/app-profile.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-upload/app-upload.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/my-profile/my-profile.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/update-password/update-password.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/share-dialog/share-dialog.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/update-video/update-video.css" />

<title>${pageInfo.titlePage}</title>
</head>

<body>
	<c:choose>
		<c:when test='${pageInfo.view eq "history"}'>
			<jsp:include page="/views/user/history.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "trending"}'>
			<jsp:include page="/views/user/trending.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "liked"}'>
			<jsp:include page="/views/user/liked.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "query"}'>
			<jsp:include page="/views/user/query.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "home"}'>
			<jsp:include page="/views/user/home.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "library"}'>
			<jsp:include page="/views/user/library.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "subscribed"}'>
			<jsp:include page="/views/user/subscribed.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "my-profile"}'>
			<jsp:include page="/views/user/my-profile.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "new-password"}'>
			<jsp:include page="/views/user/new-password.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "profile"}'>
			<jsp:include page="/views/user/profile.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "reset-password"}'>
			<jsp:include page="/views/user/reset-password.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "signin"}'>
			<jsp:include page="/views/user/signin.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "signup"}'>
			<jsp:include page="/views/user/signup.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "update-password"}'>
			<jsp:include page="/views/user/update-password.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "update-video"}'>
			<jsp:include page="/views/user/update-video.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "upload"}'>
			<jsp:include page="/views/user/upload.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "update-video"}'>
			<jsp:include page="/views/user/update-video.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "watch"}'>
			<jsp:include page="/views/user/watch.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/views/user/404-page.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>




	<div id='popup-guide' style="display: none;">
		<div class='guide-container'>
			<%@include file="/components/user/app-guide.jsp"%>
		</div>
	</div>

	<!-- Loading container -->
	<div id="loading-wrapper" class="loading-container"
		style="display: none;">
		<img src="${pageContext.request.contextPath}/assets/image/loading.svg"
			alt="" />
	</div>

	<div class="d-none" id="notify-content">${notify-content}</div>

	<script src="${pageContext.request.contextPath}/assets/script/init.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/script/toggleMenu.js"></script>

</body>
</html>
