$(document).ready(function() {

	$("button[btn-verify]").click(function() {

		const btn = $(this)
		const parent = $(this).parent().parent()
		console.log(parent)
		const channelId = btn.attr("btn-verify")
		$.ajax({
			url: projectName + "/VerifyUser",
			method: "POST",
			data: { channelId },
			success: (resp) => {

				const json = JSON.parse(resp);

				if (json.isVerify === true) {
					btn.find(".i").addClass("bi-shield-x").removeClass("bi-shield-check");
					btn.find("span").html("Huỷ xát thực");
					parent.find(".verify-icon").removeClass("d-none")
					parent.find(".verify-message").html("Đã xát thực")
				} else if (json.isVerify === false) {
					btn.find(".i").removeClass("bi-shield-x").addClass("bi-shield-check")
					btn.find("span").html("Xát thực");
					parent.find(".verify-icon").addClass("d-none")
					parent.find(".verify-message").html("Chưa xát thực")

				}


			}

		})
		console.log(channelId)
	})

	
	$("button[btn-block]").click(function() {
		
		const channelId = $(this).attr("btn-block")
		const parent = $(this).parent().parent()
		const btn = $(this)
		$.ajax({
			url: projectName + "/ToggleBlockUser",
			method: "POST",
			data: {channelId},
			success: (resp) => {
				const json = JSON.parse(resp);
				
				if (json.isActive === true) {
					parent.find(".active-message").html("Hoạt động")
					btn.find("i").addClass("bi-lock-fill").removeClass("bi-unlock-fill")
					btn.find("span").html("Khoá")
				} else if (json.isActive === false) {
					parent.find(".active-message").html("Tạm khoá")
					btn.find("i").addClass("bi-unlock-fill").removeClass("bi-lock-fill")
					btn.find("span").html("Mở khoá")
				}
				
			}
			
		})
			
		
	})

})