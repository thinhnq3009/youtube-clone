<%@page import="handler.MessagePrinter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container AppWatch">
	<div class="row pt-3">
		<div class="col-md-8 watch-wrapper px-3 pb-0">
			<!-- Phần video đang phát -->
			<div class="video-container">
				<video class="video w-100"
					src="${pageContext.request.contextPath}${watching.videoUrl}"
					autoplay controls autoplay="autoplay"></video>
			</div>

			<!-- Thông tin và action -->
			<div class="video-info-container mt-2">
				<h1 class="title">${watching.title }</h1>
				<div class="d-flex flex-wrap">
					<div
						class="owner-container d-flex flex-grow-1 align-items-center mb-3">
						<div class="owner-avt-wrapper">
							<img class="avatar"
								src="${pageContext.request.contextPath}${watching.user.avatar}"
								alt="${video.user.channelName }" />
						</div>
						<div class="owner-info">
							<h5 class="channel-name">${watching.user.channelName }</h5>
							<p class="subscriber-count">${watching.user.listSubcriber.size() }
								người đăng ký</p>
						</div>


						<c:if test="${sessionScope.userLogin.checkSub(watching.user)}">
							<button class="btn-subcribe" btn-sub="${watching.user.channelId}"
								subscribed>Đăng ký</button>
						</c:if>
						<c:if test="${!sessionScope.userLogin.checkSub(watching.user)}">
							<button class="btn-subcribe" btn-sub="${watching.user.channelId}">Đăng
								ký</button>
						</c:if>

					</div>
					<div
						class="action-container flex-grow-1 d-flex justify-content-end">
						<div class="like-wrapper">
							<button class="like" id="btn-like" video-code="${watching.code}">
								<c:if test="${sessionScope.userLogin.checkLike(watching)}">
									<i class="bi bi-hand-thumbs-up-fill"></i> 
								</c:if>
								<c:if test="${!sessionScope.userLogin.checkLike(watching)}">
									<i class="bi bi-hand-thumbs-up"></i> 
								</c:if>
								
								<span>Thích</span>
							</button>
							<button class="dislike" id="btn-dislike" video-code="${watching.code}">
								<c:if test="${sessionScope.userLogin.checkDislike(watching)}">
									<i class="bi bi-hand-thumbs-down-fill"></i>
								</c:if>
								<c:if test="${!sessionScope.userLogin.checkDislike(watching)}">
									<i class="bi bi-hand-thumbs-down"></i>
								</c:if>
							</button>
						</div>
						<button class="share">
							<i class="bi bi-reply"></i> Chia sẻ
						</button>
						<button class="save">
							<i class="bi bi-journal-plus"></i> Lưu
						</button>
					</div>
				</div>
			</div>

			<!-- Mô tả và thời gian lượt view -->
			<div class="description-container">
				<div class="info-container flex-wrap">
					<span class="info">1.213.121 lượt xem</span> <span class="info">Đã
						đăng ngày 12 tháng 1, 2023</span> <span class="hashtag">#trending</span>
					<span class="hashtag">#viral</span>
				</div>
				<div class="description">${watching.description }</div>
			</div>

			<!-- Phần comment -->
			<div class="comment-container d-none d-md-block">
				<!-- Phần viết bình luận -->
				<div class="comment-wrapper">
					<div class="comment-count">1.234 bình luận</div>
					<div class="write-comment-box d-flex">
						<img class="avatar"
							src="${pageContext.request.contextPath}${sessionScope.userLogin.avatar}"
							alt="Avatar" />
						<div class="input-wrapper flex-grow-1 d-flex flex-column">
							<span class="comment-box flex-grow-1 mb-2"> <input
								class="comment-input w-100" type="text"
								placeholder="Viết bình luận" id="input-cmt" /> <input
								type="hidden" value="${watching.code}" id="videoId" />
							</span>
							<div class="action flex-grow-1 d-flex justify-content-end">
								<button class="btn-cancel" id="btn-cmt-cancel">Huỷ</button>
								<button class="btn-submit" id="btn-cmt-submit">Bình
									luận</button>
							</div>
						</div>
					</div>
				</div>

				<!-- Phần hiển thị các bình luận trước-->
				<div class="commented" id="comment-block">
					<c:forEach items="${commentInVideo}" var="comment">
						<div class="comment-item">
							<img
								src="${pageContext.request.contextPath}${comment.user.avatar}"
								alt="" class="avatar" />
							<div class="comment-info">
								<h6 class="owner">
									${comment.user.channelName} <span class="timer ms-2">${comment.getTimeAgo()}</span>
								</h6>
								<div class="content">${comment.content }</div>
								<div class="action-container">
									<button class="action-btn">
										<i class="bi bi-hand-thumbs-up"></i>
									</button>
									<span class="like-count">5</span>
									<button class="action-btn">
										<i class="bi bi-hand-thumbs-down"></i>
									</button>
								</div>
							</div>
						</div>
					</c:forEach>


				</div>
			</div>
		</div>

		<!-- List gợi ý -->
		<div class="col-md-4 list-video-wrapper">
			<div class="row px-4 px-md-0">

				<c:forEach items="${videos}" var="video">
					<!-- 1 Video -->
					<div class="col-md-12 mb-3 item">
						<a href="Watch?v=${video.code}">
							<div class="row">
								<div class="video-cover-image col-5 p-0">
									<img src="${pageContext.request.contextPath}${video.poster }"
										alt="banner" />
									<div class="time">${video.getDuration()}</div>
								</div>
								<div class="detail-container d-flex col-7 p-0">
									<div class="detail">
										<h6 class="title">${video.title}</h6>
										<div class="channel-name">
											${video.user.channelName }
											<c:if test="${ video.user.isVerified}">
												<span><i class="bi bi-check-circle-fill"></i></span>
											</c:if>
										</div>
										<div class="data">
											<span class="view">${video.getViewCount()} lượt xem</span> <i
												class="bi bi-dot"></i> <span class="time">5 tháng
												trước</span>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>

				<!-- 1 Video -->
				<div class="col-md-12 mb-3 item">
					<a href="Watch">
						<div class="row">
							<div class="video-cover-image col-5 p-0">
								<img
									src="${pageContext.request.contextPath}/assets/image/video.png"
									alt="banner" />
								<div class="time">12:12</div>
							</div>
							<div class="detail-container d-flex col-7 p-0">
								<div class="detail">
									<h6 class="title">Thám Tử Lừng Danh Conan - Siêu Clip 23 -
										Detective Conan Tổng Hợp</h6>
									<div class="channel-name">
										POPS-Anime <span><i class="bi bi-check-circle-fill"></i></span>
									</div>
									<div class="data">
										<span class="view">1,2 Triệu lượt xem</span> <i
											class="bi bi-dot"></i> <span class="time">5 tháng
											trước</span>
									</div>
								</div>
							</div>
						</div>
					</a>
				</div>

			</div>
		</div>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/assets/script/ajax/subscribe.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/script/ajax/comment.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/script/ajax/like.js"></script>
