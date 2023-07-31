<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	
<div class="AppHistory">
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-8 offset-md-2">
				<h4 class="title">Nhật ký đã xem</h4>

				<div class="video-container">
					<h5 class="sub-title">Hôm nay</h5>
					
					<c:forEach items="${videos}" var="video">
					
					<!-- 1 Video -->
					<div class="mb-4 item">
						<a href="${pageContext.request.contextPath}/Watch?v=${video.code}">
							<div class="row">
								<div class="video-cover-image col-5 p-0 overflow-hidden">
									<img class="w-100"
										src="${pageContext.request.contextPath}${video.poster}"
										alt="banner" />
									<div class="time">${video.getDuration()}</div>
								</div>
								<div class="detail-container d-flex col-7 p-0">
									<div class="detail">
										<h6 class="title">${video.title }</h6>
										<div class="channel-name">
											${video.user.channelName} <span><i class="bi bi-check-circle-fill"></i></span>
											<i class="bi bi-dot"></i> <span class="view">${video.views.size() } lượt xem</span>
										</div>
										<div class="description">${video.description}</div>
									</div>
								</div>
							</div>
						</a>
					</div>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
