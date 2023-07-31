<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container AppDashboard p-5">
	<div class="content-box px-5 ">
		<div class="row card-container">
			<div class="col-md-3">
				<div class="item">
					<div class="wrapper">
						<div class="title">Tổng lượt xem</div>
						<div class="content">
							${viewCount}
							<span>lượt xem</span>
						</div>
					</div>
					<div class="icon">
						<i class="bi bi-aspect-ratio"></i>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="item">
					<div class="wrapper">
						<div class="title">Video mới</div>
						<div class="content">
							${videoCount}
							<span>Video</span>
						</div>
					</div>
					<div class="icon">
						<i class="bi bi-youtube"></i>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="item">
					<div class="wrapper">
						<div class="title">Người dùng mới</div>
						<div class="content">
							${userCount}
							<span>Tài khoản</span>
						</div>
					</div>
					<div class="icon">
						<i class="bi bi-person-plus-fill"></i>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="item">
					<div class="wrapper">
						<div class="title">Số người online</div>
						<div class="content">
							${applicationScope.userOnlineCounter}
							<span>Người</span>
						</div>
					</div>
					<div class="icon">
						<i class="bi bi-broadcast"></i>
					</div>
				</div>
			</div>
		</div>
		<div class="row chart-container">
			<div class="col-md-6">
				<div class="chart">
					<div class="title">Người xem trong tuần qua</div>
					<div class="content">
						<canvas id="myChart"></canvas>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="chart">
					<div class="title">Người truy cập hôm nay</div>
					<div class="content">
						<canvas id="myChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
