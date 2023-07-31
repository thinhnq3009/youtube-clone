<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container AppLibrary">
	<div class="row justify-content-center">
		<div class="col-12 col-md-10">
			<c:forEach items="${channels}" var="channel" varStatus="loop">
				<c:if test="${loop.index < 10}">
					<div class="video-group">
						<div
							class="title-container d-flex align-items-center justify-content-between">
							<h4 class="title">
								<img src="${pageContext.request.contextPath}${channel.avatar}"
									class="avatar mt-0" width="20px" />
								${channel.channelName}
								<c:if test="${channel.isVerified}">
									<i class="bi bi-check-circle-fill ms-2 me-0"
										style="font-size: 14px;"></i>
								</c:if>
							</h4>
							<a
								href="${pageContext.request.contextPath}/Channel/@${channel.channelId}">Xem
								tất cả</a>
						</div>
						<div class="video-container row">
							<c:forEach items="${channel.videos}" var="video" varStatus="loop">
								<c:if test="${loop.index < 8 }">							
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
											<h6 class="title">${video.title }</h6>
											<div class="channel-name">
												${video.user.channelName}
												<span>
													<i class="bi bi-check-circle-fill"></i>
												</span>
											</div>
											<div class="data">
												<span class="view">${video.views.size()} lượt xem</span>
												<i class="bi bi-dot"></i>
												<span class="time">${video.getTimeAgo() }</span>
											</div>
										</div>
									</div>
								</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
