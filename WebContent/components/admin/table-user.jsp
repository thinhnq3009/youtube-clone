<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container p-5 Table">
	<div class="content-box pb-4">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="ps-4" scope="col">Channel</th>
								<th scope="col">Email</th>
								<th scope="col">Subscriber</th>
								<th scope="col">Video count</th>
								<th scope="col">Total view</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user">
								<tr>
									<th>
										<div class="d-flex align-items-center">
											<img class="avatar me-3"
												src="${pageContext.request.contextPath}${user.avatar}"
												alt="" />
											<p class="channel-name">${user.channelName}</p>
										</div>
									</th>
									<td>${user.email}</td>
									<td>${user.listSubcriber.size()}</td>
									<td>${user.videos.size()}</td>
									<td>
										<div class="d-flex justify-content-between icon-wrapper">
											<span>${user.getTotalViews()}</span>
											<button class="button" data-bs-toggle="collapse"
												data-bs-target="#row_${user.id}" aria-expanded="true">
												<i class="bi bi-three-dots-vertical poiter"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr id="row_${user.id}" class="collapse">
									<td class="AppProfile" colspan="6">
										<header
											class="d-flex justify-content-between align-items-center px-4">
											<div class="info-container mb-0">
												<div class="avatar-container">
													<img src="${pageContext.request.contextPath}${user.avatar}"
														alt="Avatar" />
												</div>
												<div class="info-wrapper">
													<h1 class="channel-name">
														${user.channelName}
														<span
															class='${user.isVerified ? "" : "d-none"} verify-icon'>
															<i class="bi bi-check-circle-fill"></i>
														</span>
													</h1>
													<h6 class="channel-id">@${user.channelId}</h6>
													<h6 class="subscriber-counter">${user.listSubcriber.size()}
														người đăng kí</h6>
												</div>
											</div>
											<div class="info-container mb-0">
												<div class="info-wrapper text-wrapper">
													<h2>
														Trạng thái:
														<span class="active-message">${user.isActive ? "Hoạt động" : "Tạm khoá"}</span>
													</h2>
													<h2>
														Xát thực:
														<span class="verify-message">${user.isVerified ? "Đã xát thực" : "Chưa xát thực"}</span>
													</h2>
													<h2>
														Ngày tham gia:
														<span>
															<fmt:formatDate value="${user.dateJoin}"
																pattern="dd/MM/yyyy" />
														</span>
													</h2>
												</div>
											</div>
											<div>
												<button btn-verify="${user.channelId}"
													class="btn-subscriber bg-blue">
													<c:if test="${!user.isVerified}">
														<i class="bi bi-shield-check me-2"></i>
														<span>Xát thực</span>
													</c:if>
													<c:if test="${user.isVerified}">
														<i class="bi bi-shield-x me-2"></i>
														<span>Huỷ xát thực</span>
													</c:if>
												</button>
												<a
													href="${pageContext.request.contextPath}/VideosManagement?channelCode=${user.channelId}"
													class="btn-subscriber bg-red">
													<i class="bi bi-youtube  me-2"></i>Video
												</a>
												<button btn-block="${user.channelId}" class="btn-subscriber">
													<c:if test="${user.isActive}">
														<i class="bi bi-lock-fill me-2"></i>
														<span class="active-message">Khoá</span>
													</c:if>
													<c:if test="${!user.isActive}">
														<i class="bi bi-unlock-fill me-2"></i>
														<span >Mở khoá</span>
													</c:if>
												</button>
											</div>
										</header>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/assets/script/ajax/verify-user.js"></script>
