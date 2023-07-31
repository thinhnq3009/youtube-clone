<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="AppLogin d-flex align-items-center">
    <div class="container">
        <div class="row pt-5">
            <div class="col-md-6 d-flex align-items-center">
                <!-- chèn thẻ svg src="${pageContext.request.contextPath}/assets/image/yt-logo.svg" -->
                <img class="banner d-none d-md-block" src="${pageContext.request.contextPath}/assets/image/yt-logo-dark.svg" alt="" />
            </div>
            <div class="col-md-6">
                <form method="post">
                <input type="hidden" name="token" value="${token}" />
                    <div class="form-container">
                        <h1 class="mb-3 text-center font-weight-bolder">Create new password</h2>
                            <p class="message">Create new password for <strong>${channelName }</strong></p>
                        <div class="input-block">
                            <label for="password">Password</label>
                            <i class="left-icon bi bi-person"></i>
                            <input
                                class="input-control"
                                type="password"
                                name="password"
                                id="password"
                                placeholder="Password"
                            />
                            <i class="right-icon bi bi-eye"></i>
                        </div>
                        <div class="input-block toggle-password">
                            <label for="confirmPassword">Confirm password</label>
                            <i class="left-icon bi bi-lock"></i>
                            <input
                                class="input-control"
                                type="password"
                                name="confirmPassword"
                                id="confirmPassword"
                                placeholder="Confirm password"
                            />
                            <i class="right-icon bi bi-eye"></i>
                        </div>
    
                        <div class="input-block d-flex justify-content-center mt-2">
                            <button type="submit">Create</button>
                        </div>

                        <div class="input-block text-center mb-2">
                           Don't have an account <a class=" text-primary" href="${pageContext.request.contextPath}/SignUp">Register now!</a>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div> 


<script src="${pageContext.request.contextPath}/assets/script/togglePasswordField.js"></script>  