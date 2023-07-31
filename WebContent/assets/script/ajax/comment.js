$(document).ready(function() {

	$("#btn-cmt-submit").click(function() {
		const content = $("#input-cmt").val()
		const videoId = $("#videoId").val();
		if (!content) return

		$.ajax({

			type: "POST",
			url: projectName + "/Comment",
			data: { content, videoId },
			success: function(response) {
				var oldHtml = $("#comment-block").html();
				$("#comment-block").html(response + oldHtml);
				$("#input-cmt").val("");
			}

		})
	})

})