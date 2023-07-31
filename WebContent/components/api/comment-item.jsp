<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="comment-item">
	<img src="${pageContext.request.contextPath}${comment.user.avatar}"
		alt="" class="avatar" />
	<div class="comment-info">
		<h6 class="owner">
			${comment.user.channelName}<span class="timer ms-2">${comment.getTimeAgo()}</span>
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