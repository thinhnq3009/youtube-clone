<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Đổi mật khẩu</title>
<style>
.container {

	width: 90%;
	
	background-color: #f00;
	font-family: Arial, sans-serif;
	color: #fff;
	text-align: center;
	padding: 20px;
	padding-top: 2rem;
	padding-bottom: 5rem;
	border-radius: 15px;
}

a {
	background-color: #fff;
	color: #f00 !important;
	border: none;
	padding: 10px 20px;
	border-radius: 20px;
	cursor: pointer;
	font-size: 16px;
	margin-top: 20px;
	text-decoration: none;
	transition: 0.5s
}

a:hover {
	background-color: #f00;
	color: #fff !important;
	transition: all 0.3s ease;
}

.logo {
	display: block;
	margin: 20px auto 0;
	max-width: 100%;
	height: auto;
}

.message {
	margin-bottom: 2rem;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Xin chào, ${name}</h1>
		<p class="message">Chào ${name}, trang đổi mật khẩu đã sẵn sàng để sử dụng cho tài
			khoản của bạn. Nhớ giữ bí mật và không chia sẻ cho bất kỳ ai nhé</p>
		<a href="${link}">Đổi mật khẩu</a>
	</div>
	<%-- 	<img class="logo" src="${pageContext.request.contextPath}/assets/image/yt-logo-dark.svg"> --%>
</body>
</html>
