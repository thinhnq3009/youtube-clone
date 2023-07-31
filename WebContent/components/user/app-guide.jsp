<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- mini-guide -->
<div toggle-guide='true' class="AppGuide  d-none d-md-flex">
    <div class="logo-container">
        <i class="menu-icon bi bi-list"></i>
        <a href="${pageContext.request.contextPath}/Home">
            <div class="logo-wrapper" nation="VN">
                <img src="${pageContext.request.contextPath}/assets/image/yt-logo.svg" alt="Logo" />
            </div>
        </a>
    </div>
    <div class="item-container">
        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Home">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-house-door-fill"></i>
                </span>
                <span class="content">Trang chủ</span>
                <span class="right-icon"> </span>
            </div>
        </a>

        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Trending">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-fire"></i>
                </span>
                <span class="content">Thịnh hành</span>
                <span class="right-icon"> </span>
            </div>
        </a>
        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Subcribed">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-collection-play"></i>
                </span>
                <span class="content">Kênh đăng ký</span>
                <span class="right-icon"> </span>
            </div>
        </a>
    </div>

    <div class="item-container">
        <!-- <p class="title">Kênh đăng ký</p> -->
        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Library">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-card-text"></i>
                </span>
                <span class="content">Thư viện</span>
                <span class="right-icon"> </span>
            </div>
        </a>

        <!-- Item -->
        <a href="${pageContext.request.contextPath}/History">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-arrow-clockwise"></i>
                </span>
                <span class="content">Video đã xem</span>
                <span class="right-icon"> </span>
            </div>
        </a>

        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Channel/@${sessionScope.userLogin.channelId}">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-caret-right-square"></i>
                </span>
                <span class="content">Video của bạn</span>
                <span class="right-icon"> </span>
            </div>
        </a>
        <!-- Item -->
        <a href="${pageContext.request.contextPath}/WatchLater">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-clock"></i>
                </span>
                <span class="content">Xem sau</span>
                <span class="right-icon"> </span>
            </div>
        </a>
        <!-- Item -->
        <a href="${pageContext.request.contextPath}/Liked">
            <div class="item-wrapper">
                <span class="left-icon">
                    <i class="bi bi-hand-thumbs-up"></i>
                </span>
                <span class="content">Đã thích</span>
                <span class="right-icon"> </span>
            </div>
        </a>
    </div>
</div>
