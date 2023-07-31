<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- mini-guide -->
<div class="AppGuide mini d-none d-md-flex Admin">
	<div class="logo-container">
		<i class="menu-icon bi bi-list"></i> <a
			href="${pageContext.request.contextPath}/Admin/Home">
			<div class="logo-wrapper" nation="VN">
				<img
					src="${pageContext.request.contextPath}/assets/image/AdminLogo.png"
					alt="Logo" />
			</div>
		</a>
	</div>
	<div class="item-container">
		<!-- Item -->
		<a href="${pageContext.request.contextPath}/Admin/Home">
			<div class="item-wrapper">
				<span class="left-icon"> <i class="bi bi-house-door-fill"></i>
				</span> <span class="content">Trang chủ</span> <span class="right-icon">
				</span>
			</div>
		</a>

		<!-- Item -->
		<a href="${pageContext.request.contextPath}/UsersManagement">
			<div class="item-wrapper">
				<span class="left-icon"> <i class="bi bi-fire"></i>
				</span> <span class="content">Người dùng</span> <span class="right-icon">
				</span>
			</div>
		</a>
		<!-- Item -->
		<a href="${pageContext.request.contextPath}/VideosManagement">
			<div class="item-wrapper">
				<span class="left-icon"> <i class="bi bi-collection-play"></i>
				</span> <span class="content">Video</span> <span class="right-icon">
				</span>
			</div>
		</a>
		<!-- Item -->
		<!--  <a href="Report">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-collection-play"></i>
                </span>
                <span class="content">Báo cáo</span>
                <span class="right-icon"> </span>
            </div>
        </a> -->
	</div>

	<div class="item-container avatar-container align-items-center">
		<img class="img-fluid"
			src="${pageContext.request.contextPath}${sessionScope.userLogin.avatar}"
			alt="" />
		<h6>${sessionScope.userLogin.channelName}</h6>

		<!-- Item -->
		<a href="${pageContext.request.contextPath}/Logout">
			<div class="item-wrapper">
				<span class="left-icon me-2"> <i class="bi bi-door-closed"></i>
				</span> <span class="content">Đăng xuất</span> <span class="right-icon">
				</span>
			</div>
		</a>
	</div>
</div>
