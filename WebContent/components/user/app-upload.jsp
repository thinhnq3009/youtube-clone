<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="upload" action="${pageContext.request.contextPath}/Upload" method="post" enctype="multipart/form-data">
	<div class="AppUpload">
		<div class="container">
			<div class="box row">
				<h3 class="box-header">Đăng video</h3>
	
				<div class="col-md-5 ps-md-5">
					<div class="preview-container" id="preview-container"
						style="display: none;">
						<button type="reset">
							<i class="bi bi-x-circle-fill"></i>
						</button>
						<video
							src="${pageContext.request.contextPath}/assets/image/video.mp4"
							controls></video>
					</div>
					<div id="input-container" class="input-container mb-4 ">
						<i class="bi bi-cloud-arrow-up"></i>
						<h5 class="mb-0">Chọn video để tải lên</h5>
						<p class="mb-0">Hoặc kéo và thả video để tải lên</p>
						<h6 class="mb-0">Chỉ hỗ trợ file .mp4</h6>
						<input id="video-input" type="file" name="video" accept="video/mp4" required/>
					</div>
	
					<h6>Poster preview</h6>
	
					<div class="poster-preview pt-4">
						<!-- 1 Cái video -->
						<div class="video-item col-6 mx-auto">
							<div class="video-cover-image">
								<img
									src="${pageContext.request.contextPath}/assets/image/video.png"
									alt="Poster" id="poster-preview" />
								<div id="timer" class="time">12:12</div>
							</div>
							<div class="detail-container">
								<div class="detail">
									<h6 id="title-preview" class="title">Video's title</h6>
									<div class="channel-name">
										${sessionScope.userLogin.channelName} <span><i class="bi bi-check-circle-fill"></i></span>
									</div>
									<div class="data">
										<span class="view">1,2 Triệu lượt xem</span> <i
											class="bi bi-dot"></i> <span class="time">1 phút trước</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7 pe-md-5">
	
					<div class="form-container">
						<!-- Hide filed-->
						<input type="hidden" id="secondLength" name="secondLength" />
					
						<!-- One filed -->
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="title-input" name="title"
							 maxlength="120" required /> <label
								for="floatingInput">Tiêu đề (<span id="title-length">0</span>/120)
							</label>
						</div>
						<!-- One filed -->
						<div class="form-floating mb-3">
							<textarea class="form-control" placeholder="Leave a comment here" name="description"
								id="description-input" style="height: 130px"></textarea>
							<label for="floatingTextarea" style="opacity: 1;"> <span
								class="px-2 py-1 rounded bg-light"> Mô tả (<span
									id="description-length">0</span>/5000)
							</span>
							</label>
						</div>
	
						<!-- One filed -->
						<div class="row mb-3">
							<h6>Quyền riêng tư:</h6>
							<div class="d-flex">
								<div class="form-check ms-3">
									<input class="form-check-input" type="radio" name="isPublic"
										id="only-me" value="false" /> <label class="form-check-label"
										for="only-me"> Chỉ mình tôi </label>
								</div>
								<div class="form-check ms-3">
									<input class="form-check-input" type="radio" name="isPublic"
										id="public" value="true" checked /> <label
										class="form-check-label" for="public"> Công khai </label>
								</div>
							</div>
						</div>
	
						<!-- One filed -->
						<div class="mb-3">
							<label for="poster-input" class="form-label"><h6>Ảnh
									bìa video</h6></label> <input class="form-control form-control-sm" name="poster"
								id="poster-input" type="file" accept="image/jpg, image/png" required/>
						</div>
	
						<button class="btn btn-danger w-100" type="submit">Đăng
							video</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<script
	src="${pageContext.request.contextPath}/assets/script/handel-upload.js"></script>
