<%@page import="handler.SessionManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="AppLogin d-flex align-items-center">
	<div class="container">
		<div class="row pt-5">
			<div class="col-md-6 d-flex align-items-center">
				<!-- chèn thẻ svg src="${pageContext.request.contextPath}/assets/image/yt-logo.svg" -->
				<img class="banner d-none d-md-block"
					src="${pageContext.request.contextPath}/assets/image/yt-logo-dark.svg"
					alt="" />
			</div>
			<div class="col-md-6">
				<form method="post" loading-on-submit>
					<div class="form-container">
						<h1 class="mb-3 text-center font-weight-bolder">
							Reset password
							</h2>

							<c:if test="${not empty sessionScope.message}">
								<div class="alert alert-success border-0 text-center">
									${sessionScope.message}</div>
								<%
								 SessionManager.removeMessage(session);
								%>
							</c:if>

							<c:if test="${not empty sessionScope.errorMessage}">
								<div class="alert alert-danger border-0 text-center">
									${sessionScope.errorMessage}</div>
								<%
								 SessionManager.removeErrorMessage(session);
								%>
							</c:if>

							<div class="input-block">
								<label for="username">Username</label> <i
									class="left-icon bi bi-person"></i> <input
									class="input-control" type="text" name="username" id="username"
									placeholder="Username" /> <i
									class="right-icon bi bi-person"></i>
							</div>

							<div class="input-block message">The link reset password
								will be sent to the email address you have registered an
								account.</div>

							<div class="input-block d-flex justify-content-center mt-2">
								<button type="submit">Send</button>
							</div>

							<div class="input-block text-center mb-2">
								Don't have an account <a class=" text-primary" href="SignUp">Register
									now!</a>
							</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script
	src="${pageContext.request.contextPath}/assets/script/loading-derective.js"></script>