<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="AppContent">
	<div class="suggest-wrapper">
		<div class="suggest-container">
			<span class="item">Avatar: The Last Airbender</span>
			<span class="item">Gravity Falls</span>
			<span class="item">Rick and Morty</span>
			<span class="item">Adventure Time</span>
			<span class="item">My Neighbor Totoro</span>
		</div>
	</div>
	<div class="video-wrapper pt-3 px-3">
		<div class="list-video-container row px-5">
			<c:forEach items="${videos}" var="video">
				<!-- 1 Video -->
				<div class="col-md-4 mb-3 item">
					<a href="Watch?v=${video.code}">
						<div class="video-cover-image">
							<img src="${pageContext.request.contextPath}${video.poster}"
								alt="banner" />
							<div class="time">${video.getDuration() }</div>
						</div>
					</a>
					<div class="detail-container d-flex px-3">
						<img class="avatar mt-0"
							src="${pageContext.request.contextPath}${video.user.avatar}"
							alt="chanel" />
						<div class="detail">
							<a
								href="${pageContext.request.contextPath}/Watch?v=${video.code}">
								<h6 class="title">${video.title }</h6>
							</a>
							<a
								href="${pageContext.request.contextPath}/Channel/@${video.user.channelId }">
								<div class="channel-name">
									${video.user.channelName }
									<c:if test="${video.user.isVerified}">
										<span>
											<i class="bi bi-check-circle-fill"></i>
										</span>
									</c:if>
								</div>
							</a>
							<div class="data">
								<span class="view">${video.getViewCount()} lượt xem</span>
								<i class="bi bi-dot"></i>
								<span class="time">${video.getTimeAgo()}</span>
							</div>
							<!-- <div class="menu">
								<i class="bi bi-three-dots-vertical" id="menu_id"
									data-bs-toggle="dropdown" aria-expanded="false"></i>
								<ul class="dropdown-menu" aria-labelledby="notice-container">
									<li class="dropdown-item">Lưu xem sau</li>
									<li>
										<a class="dropdown-item" type="button" class="btn btn-primary"
											data-bs-toggle="modal" data-bs-target="#staticBackdrop">
											Chia sẻ </a>
									</li>
								</ul>
							</div> -->
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>