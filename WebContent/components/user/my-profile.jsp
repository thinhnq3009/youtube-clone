<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="MyProfile">
	<div class="container pt-5 px-5">
		<div class="row">
			<div class="col-12 profile-container">
				<form method="post" enctype="multipart/form-data">
					<header>
						<h4 class="title">Chỉnh sửa thông tin</h4>
					</header>

					<div class="form-wrapper">
						<div class="profile-item">
							<div class="title">
								<h6>Avatar</h6>
							</div>
							<div
								class="content avatar d-flex justify-content-center hover-owner">
								<img
									src="${pageContext.request.contextPath}${sessionScope.userLogin.avatar}"
									id="avatar-preview" alt="Avatar" /> <input type="file"
									accept="image/*" name="avatar" id="avatar-input" name="avatar" />
								<div class="coating icon-wrapper">
									<i class="bi bi-file-image"></i>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="profile-item">
									<div class="title">
										<h6>Channel Name</h6>
									</div>
									<div class="content">
										<input type="text" name="channelName"
											value="${sessionScope.userLogin.channelName}" />
									</div>
								</div>

								<div class="profile-item">
									<div class="title">
										<h6>Channel ID</h6>
									</div>
									<div class="content">
										<input type="text" name="channelId"
											value="${sessionScope.userLogin.channelId}" />
									</div>
								</div>
								<div class="profile-item">
									<div class="title">
										<h6>Email</h6>
									</div>
									<div class="content">
										<input type="text" name="email"
											value="${sessionScope.userLogin.email}" />
									</div>
								</div>
							</div>
							<div class="col-md-6 mb-3">
								<div class="profile-item h-100 mb-0">
									<div class="title">
										<h6>Mô tả kênh</h6>
									</div>
									<div class="content">
										<textarea rows="3" name="story" type="text">${sessionScope.userLogin.story}</textarea>
									</div>
								</div>
							</div>
						</div>

						<div class="w-100 px-3">
							<button class="save" type="submit">
								<i class="bi bi-save-fill me-2"></i> Update
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/assets/script/handelUpdateProfile.js"></script>