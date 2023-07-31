<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container p-5 Table">
	<div class="content-box pb-3">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="ps-4" scope="col">Tiêu đề</th>
								<th scope="col">Chủ sở hữu</th>
								<th scope="col">Trạng thái</th>
								<th scope="col">Lượt xem</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${videos}" var="video">

								<tr>
									<th class="poster-wrapper"><a
										href="${pageContext.request.contextPath}/Watch?v=${video.code}"
										target="_blank">
											<div class="d-flex align-items-center">
												<img class="poster me-3"
													src="${pageContext.request.contextPath}${video.poster}"
													alt="" />
												<p class="title">${video.title}</p>
											</div>
									</a></th>
									<td>
										<div class="d-flex">
											<img class="avatar me-3"
												src="${pageContext.request.contextPath}${video.user.avatar}"
												alt="" />
											<p class="channel-name">${video.user.channelName}</p>
										</div>
									</td>
									<td class='${video.isActive ? "text-success" : "text-danger"}'><i
										class='bi ${video.isActive ? "bi-check-circle-fill" : "bi-x-circle-fill"}'></i>
										${video.isActive ? "Hoạt động" : "Tạm khoá"}</td>
									<td>
										<div class="d-flex justify-content-between icon-wrapper">
											<span>${video.views.size()}</span>
											<button class="button" data-bs-toggle="collapse"
												data-bs-target="#row_${video.id}" aria-expanded="true">
												<i class="bi bi-three-dots-vertical poiter"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr id="row_${video.id}" class="collapse">
									<td class="AppProfile" colspan="6"><header
											class="d-flex justify-content-between align-items-center px-4">

											<div class="info-container mb-0">
												<div class="info-wrapper text-wrapper">
													<h2>
														Trạng thái: <span>Hoạt động</span>
													</h2>
													<h2>
														Ngày đăng: <span> <fmt:formatDate
																value="${video.datePost }" pattern="dd/MM/yyyy" />
														</span>
													</h2>
													<h2>
														Like: <span>${video.getLikeCount()}</span>
													</h2>
													<h2>
														Dislike: <span>${video.getDislikeCount()}</span>
													</h2>
													<h2>
														Thời lượng: <span>${video.getDuration()}</span>
													</h2>
													<h2>
														Bình luận: <span>${video.comments.size() }</span>
													</h2>
												</div>
											</div>

											<div>
												<a class="btn-subscriber bg-blue"
													href="${pageContext.request.contextPath}/Admin/Video/Edit?code=${video.code}"
													target="_blank"> <i class="bi bi-card-text me-2"></i>Chỉnh
													sửa
												</a> <a class="btn-subscriber bg-red"> <i
													class="bi bi-file-earmark-x me-2"></i>Xoá
												</a> <a class="btn-subscriber"> <i
													class="bi bi-file-lock me-2"></i>Khoá
												</a>
											</div>
										</header></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="w-100 text-primary icon-wrapper justify-content-center">
			<a href="" class="link"> <span class="mb-0 fw-bold">Tải
					thêm <i class="bi bi-cloud-arrow-down"></i>
			</span>
			</a>
		</div>
	</div>
</div>
