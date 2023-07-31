$(document).ready(function() {
	$('button[btn-sub][subscribed]')
		.html("Đã đăng ký")
		.css({
			"background": "#e5e5e5",
			color: "#0f0f0f"
		})

	$("button[btn-sub]").click(function() {
		var data = $(this).attr("btn-sub");
		$.ajax({
			type: "POST",
			url: projectName + "/Subscribe",
			data: { channelId: data },
			success: function(response) {
				try {
					const json = JSON.parse(response);
					if (json.value === true) {

						$("button[btn-sub]")
							.html("Đã đăng ký")
							.css({
								"background": "#e5e5e5",
								color: "#0f0f0f"
							})

					} else if (json.value === false) {
						$("button[btn-sub]")
							.html("Đăng ký")
							.removeAttr("style");
					}
				} catch (e) {
					console.error(e)
				}
			}
		});
	});
});
