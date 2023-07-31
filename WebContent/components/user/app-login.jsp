<%@page import="handler.SessionManager"%>
<%@page import="handler.MessagePrinter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<form method="post">
					<div class="form-container">
						<h1 class="mb-3 text-center font-weight-bolder">
							Sign In
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
							<div class="input-block toggle-password mb-2">
								<label for="password">Password</label> <i
									class="left-icon bi bi-lock"></i> <input class="input-control"
									type="password" name="password" id="password"
									placeholder="Password" /> <i class="right-icon bi bi-eye"></i>
							</div>


							<div
								class="input-block d-flex justify-content-between mb-0 text-primary px-3 mb-2">

								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" name="remember"
										id="remember"> <label class="custom-control-label"
										for="remember">Remember me.</label>
								</div>

								<a href="ResetPassword">Forget password ?</a>
							</div>

							<div class="input-block d-flex justify-content-center mt-2">
								<button type="submit">Sign In</button>
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
	src="${pageContext.request.contextPath}/assets/script/togglePasswordField.js"></script>