<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-404">
	<div class='c mt-2'>
		<div class='_404'>404</div>
		<hr>
		<div class='_1 my-3'>Không tìm thấy trang</div>
		<div class='_2 mb-3'>${message404 == null ? "Chúng tôi không tìm thấy trang bạn yêu cầu" : message404 }</div>
		<a class='btn' href="${pageContext.request.contextPath}/Home">
			Quay về trang chủ </a>
	</div>
</div>