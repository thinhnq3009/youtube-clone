<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="AppHeader">
	<div class="left-wrapper d-flex align-items-center">
		<i id="btn-show-guide" class="menu-icon bi bi-list"></i>
		<a href="${pageContext.request.contextPath}/Home">
			<div class="logo-wrapper" nation="VN">
				<img
					src="${pageContext.request.contextPath}/assets/image/yt-logo.svg"
					alt="Logo" />
			</div>
		</a>
	</div>
	<form action="${pageContext.request.contextPath}/Result" method="get">
		<div class="center-wrapper">
			<div class="search-container">
				<div class="input-container">
					<i class="input-icon bi bi-search"></i>
					<input type="text" name="search_query" placeholder="Tìm kiếm" value="${keyword}" />
					<i class="keyboard-icon bi bi-keyboard-fill"></i>
				</div>
				<button class="btn-search">
					<i class="bi bi-search"></i>
				</button>
			</div>
		</div>
	</form>
	<c:if test="${not empty sessionScope.userLogin }">
		<div class="right-wrapper d-flex">
			<div class="item avatar" id="account-action"
				data-bs-toggle="dropdown" aria-expanded="false">
				<img
					src="${pageContext.request.contextPath}${sessionScope.userLogin.avatar}"
					alt="avatar" />
			</div>
			<ul class="dropdown-menu" aria-labelledby="account-action">
				<li>
					<a class="dropdown-item icon-wrapper"
						href="${pageContext.request.contextPath}/Channel/@${sessionScope.userLogin.channelId}">
						<i class="bi bi-play-btn me-3"></i> Kênh của bạn
					</a>
				</li>
				<li>
					<a class="dropdown-item icon-wrapper"
						href="${pageContext.request.contextPath}/MyProfile">
						<i class="bi bi-person-bounding-box me-3"></i> Thông tin tài khoản
					</a>
				</li>
				<li>
					<a class="dropdown-item icon-wrapper"
						href="${pageContext.request.contextPath}/ChangePassword">
						<i class="bi bi-key me-3"></i> Đổi mật khẩu
					</a>
				</li>
				<li>
					<hr class="dropdown-divider" />
				</li>
				<c:if test="${sessionScope.userLogin.isSystemAdmin}">
					<li>
						<a class="dropdown-item icon-wrapper"
							href="${pageContext.request.contextPath}/Admin/Home">
							<i class="bi bi-shield-check me-3"></i></i> Admin Dashboard
						</a>
					</li>
					<li>
						<hr class="dropdown-divider" />
					</li>
				</c:if>
				<li>
					<a class="dropdown-item icon-wrapper"
						href="${pageContext.request.contextPath}/Logout">
						<i class="bi-box-arrow-in-right me-3"></i>Đăng xuất
					</a>
				</li>
			</ul>
			<div class="item" id="notice-container" data-bs-toggle="dropdown"
				aria-expanded="false">
				<i class="bi bi-bell"></i>
				<span class="badeg">9+</span>
			</div>
			<ul class="dropdown-menu notice-container"
				aria-labelledby="notice-container">
				<li>
					<a class="dropdown-item p-0">
						<div class="notice-item d-flex">
							<span class="new">
								<i class="bi bi-dot"></i>
							</span>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath}/assets/image/chanel.jpg"
									alt="">
							</div>
							<div class="notice-wrapper flex-grow-1">
								<h3 class="notice-content w-100 overflow-hidden">
									POPS-Anime đã tải lên: Doraemon - Nobita và những chuyến phiêu
									lưu kỳ diệu</h3>
								<div class="notice-time">1 giờ trước</div>
							</div>
							<div class="poster">
								<img
									src="${pageContext.request.contextPath}/assets/image/video.png"
									alt="">
							</div>
						</div>
					</a>
				</li>
				<li>
					<a class="dropdown-item p-0">
						<div class="notice-item d-flex">
							<span class="new">
								<i class="bi bi-dot"></i>
							</span>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath}/assets/image/chanel.jpg"
									alt="">
							</div>
							<div class="notice-wrapper flex-grow-1">
								<h3 class="notice-content w-100 overflow-hidden">
									POPS-Anime đã tải lên: Doraemon - Nobita và những chuyến phiêu
									lưu kỳ diệu</h3>
								<div class="notice-time">1 giờ trước</div>
							</div>
							<div class="poster">
								<img
									src="${pageContext.request.contextPath}/assets/image/video.png"
									alt="">
							</div>
						</div>
					</a>
				</li>
				<li>
					<a class="dropdown-item p-0">
						<div class="notice-item d-flex">
							<span class="new">
								<i class="bi bi-dot"></i>
							</span>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath}/assets/image/chanel.jpg"
									alt="">
							</div>
							<div class="notice-wrapper flex-grow-1">
								<h3 class="notice-content w-100 overflow-hidden">
									POPS-Anime đã tải lên: Doraemon - Nobita và những chuyến phiêu
									lưu kỳ diệu</h3>
								<div class="notice-time">1 giờ trước</div>
							</div>
							<div class="poster">
								<img
									src="${pageContext.request.contextPath}/assets/image/video.png"
									alt="">
							</div>
						</div>
					</a>
				</li>
			</ul>
			<a href="${pageContext.request.contextPath}/Upload">
				<div class="item">
					<i class="bi bi-cloud-arrow-up-fill"></i>
				</div>
			</a>
		</div>
	</c:if>
	<c:if test="${empty sessionScope.userLogin }">
		<div class="right-wrapper not-login">
			<a href="${pageContext.request.contextPath}/SignIn">
				<i class="bi bi-person-circle"></i>
				<span>Đăng nhập</span>
			</a>
		</div>
	</c:if>
</div>
