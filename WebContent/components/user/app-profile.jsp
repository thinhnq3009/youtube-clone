<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="AppProfile">
	<div class="container pt-5 px-5">
		<header class="d-flex justify-content-between align-items-center">
			<div class="info-container">
				<div class="avatar-container">
					<img src="${pageContext.request.contextPath}${channel.avatar}"
						alt="Avatar" />
				</div>
				<div class="info-wrapper">
					<h1 class="channel-name">
						${channel.channelName}
						<c:if test="${channel.isVerified}">
							<span>
								<i class="bi bi-check-circle-fill"></i>
							</span>
						</c:if>
					</h1>
					<h6 class="channel-id">@${channel.channelId}</h6>
					<h6 class="subscriber-counter">${channel.listSubcriber.size() }
						người đăng kí</h6>
				</div>
			</div>
			<c:if test="${sessionScope.userLogin.checkSub(channel)}">
				<button class="btn-subscriber" btn-sub="${channel.channelId}"
					subscribed>Đăng ký</button>
			</c:if>
			<c:if test="${!sessionScope.userLogin.checkSub(channel)}">
				<button class="btn-subscriber" btn-sub="${channel.channelId}">Đăng
					ký</button>
			</c:if>
		</header>
		<div class="video-container">
			<%-- <div class="video-group">
				<div
					class="title-container d-flex align-items-center justify-content-between">
					<h4 class="title">
						<i class="bi bi-trophy"></i> Top video
					</h4>
				</div>
				<div class="video-container row">
					<!-- 1 Cái video -->
					<div class="video-item col-4">
						<div class="video-cover-image">
							<img
								src="${pageContext.request.contextPath}/assets/image/video.png"
								alt="banner" />
							<div class="time">12:12</div>
						</div>
						<div class="detail-container">
							<div class="detail">
								<h6 class="title">Thám Tử Lừng Danh Conan - Siêu Clip 23 -
									Detective Conan Tổng Hợp</h6>
								<div class="channel-name">
									POPS-Anime
									<span>
										<i class="bi bi-check-circle-fill"></i>
									</span>
								</div>
								<div class="data">
									<span class="view">1,2 Triệu lượt xem</span>
									<i class="bi bi-dot"></i>
									<span class="time">5 tháng trước</span>
								</div>
								<div class="menu">
									<i class="bi bi-three-dots-vertical" id="menu_id"
										data-bs-toggle="dropdown" aria-expanded="false"></i>
									<ul class="dropdown-menu" aria-labelledby="notice-container">
										<li class="dropdown-item">Lưu xem sau</li>
										<a class="dropdown-item" type="button" class="btn btn-primary"
											data-bs-toggle="modal" data-bs-target="#staticBackdrop">
											<li>Chia sẻ</li>
										</a>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> --%>
			<div class="video-group">
				<div class="title-container d-flex align-items-center">
					<h4 class="title me-3">
						<i class="bi bi-clock"></i> Video đã đăng
					</h4>
					<a class="d-none">Tải lên gần đây</a>
				</div>
				<div class="video-container row">
					<c:forEach items="${channel.videos}" var="video">
						<!-- 1 Cái video -->
						<div class="video-item col-3">
							<a
								href="${pageContext.request.contextPath}/Watch?v=${video.code}">
								<div class="video-cover-image">
									<img src="${pageContext.request.contextPath}${video.poster}"
										alt="banner" />
									<div class="time">${video.getDuration()}</div>
								</div>
							</a>
							<div class="detail-container">
								<div class="detail">
									<h6 class="title">${video.title}</h6>
									<div class="channel-name">
										${video.user.channelName}
										<span>
											<c:if test="${video.user.isVerified}">
												<i class="me-3 bi bi-check-circle-fill"></i>
											</c:if>
										</span>
									</div>
									<div class="data">
										<span class="view">${video.views.size()} lượt xem</span>
										<i class="bi bi-dot"></i>
										<span class="time">${ video.getTimeAgo()}</span>
									</div>
									<div class="menu">
										<i class="bi bi-three-dots-vertical" id="menu_id"
											data-bs-toggle="dropdown" aria-expanded="false"></i>
										<ul class="dropdown-menu" aria-labelledby="notice-container">
											<li class="dropdown-item">Lưu xem sau</li>
											<li>
												<a class="dropdown-item" type="button"
													class="btn btn-primary" data-bs-toggle="modal"
													data-bs-target="#staticBackdrop"> Chia sẻ </a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/assets/script/ajax/subscribe.js"></script>