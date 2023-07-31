<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="AppLogin AppSignup d-flex align-items-center">
	<div class="container">
		<div class="row pt-5">
			<div class="col-md-6 d-flex align-items-center">
				<!-- chèn thẻ svg src="${pageContext.request.contextPath}/assets/image/yt-logo.svg" -->
				<img class="banner d-none d-md-block"
					src="${pageContext.request.contextPath}/assets/image/yt-logo-dark.svg"
					alt="" />
			</div>
			<div class="col-md-6">
				<form id="signIn" action="SignUp" method="post">
					<div class="form-container">
						<h1 class="mb-3 text-center font-weight-bolder">
							Sign Up
							</h1>
							<c:if test="${not empty errorMessage }">
								<div class="alert alert-danger text-center mb-3">
									${errorMessage}</div>
								<%
								session.removeAttribute("errorMessage");
								%>
							</c:if>
							<div class="input-block" id="input-block_username">
								<label for="username">Username</label>
								<i class="left-icon bi bi-person"></i>
								<input class="input-control" type="text" name="username"
									id="username" placeholder="Username" />
								<i class="right-icon bi bi-arrow-clockwise"></i>
							</div>
							<div class="input-block">
								<label for="fullname">Channel name</label>
								<i class="left-icon bi bi-person-bounding-box"></i>
								<input class="input-control" type="text" name="channelName"
									id="channelName" placeholder="Your channel name" />
								<i class="right-icon"></i>
							</div>
							<div class="input-block">
								<label for="email">Email</label>
								<i class="left-icon bi bi-envelope"></i>
								<input class="input-control" type="text" name="email" id="email"
									placeholder="Email" />
								<i class="right-icon"></i>
							</div>
							<div class="input-block toggle-password">
								<label for="password">Password</label>
								<i class="left-icon bi bi-lock"></i>
								<input class="input-control" type="password" name="password"
									id="password" placeholder="Password" />
								<i class="right-icon bi bi-eye"></i>
							</div>
							<div class="input-block toggle-password">
								<label for="re-password">Repeat password</label>
								<i class="left-icon bi bi-lock"></i>
								<input class="input-control" type="password"
									name="repeatPassword" id="repeatPassword"
									placeholder="Repeat password" />
								<i class="right-icon bi bi-eye"></i>
							</div>
							<div class="input-block d-flex justify-content-center mt-2">
								<button type="submit">Sign In</button>
							</div>
							<div class="input-block text-center mb-2">
								Do you have an account?
								<a class="text-primary" href="SignIn">Log in now!</a>
							</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/assets/script/validatorSigninForm.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/script/togglePasswordField.js"></script>
