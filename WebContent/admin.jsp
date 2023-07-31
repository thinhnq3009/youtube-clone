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
<!-- Customize CSS -->

<!-- libs -->
<script
	src="${pageContext.request.contextPath}/assets/libs/jquery/dist/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/libs/@popperjs/core/dist/umd/popper.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/libs/bootstrap/dist/js/bootstrap.js"></script>
<!-- libs -->


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-profile/app-profile.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/admin/app-guide/app-guide.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/user/app-guide/app-guide.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/admin/app-header/app-header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/admin/app-dashboard/app-dashboard.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/admin/table-user/table-user.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style/admin/table-video/table-video.css">


<title>${pageInfo.titlePage}</title>
</head>

<body>

	<c:choose>
		<c:when test='${pageInfo.view eq "dashboarh"}'>
			<jsp:include page="/views/admin/home.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "user-management"}'>
			<jsp:include page="/views/admin/users.jsp"></jsp:include>
		</c:when>
		<c:when test='${pageInfo.view eq "videos-management"}'>
			<jsp:include page="/views/admin/video.jsp"></jsp:include>
		</c:when>
	</c:choose>

	<script src="${pageContext.request.contextPath}/assets/script/init.js"></script>
</body>
</html>
