<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="AppHeader">
	<div class="left-wrapper d-flex align-items-center">
		<i class="menu-icon bi bi-list"></i>
		<a href="#!/">
			<div class="logo-wrapper" nation="VN">
				<img
					src="${pageContext.request.contextPath}/assets/image/AdminLogo.png"
					alt="Logo" />
			</div>
		</a>
	</div>
	<div class="center-wrapper">
		<div class="search-container">
			<form>
				<div class="input-container">
					<i class="input-icon bi bi-search"></i>
					<input type="text" placeholder="Tìm kiếm tài khoản người dùng" />
				</div>
			</form>
			<button class="btn-search">
				<i class="bi bi-search"></i>
			</button>
		</div>
	</div>
	<div class="right-wrapper">
		<div class="right-wrapper not-login">
			<a href="${pageContext.request.contextPath}/Home">
				<i class="bi bi-youtube"></i>
				<span>Trang chủ</span>
			</a>
		</div>
	</div>
</div>
