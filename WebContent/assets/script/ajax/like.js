$(document).ready(function() {

	$("#btn-like").click(function() {

		const videoCode = $(this).attr("video-code")
		const isLike = true

		$.ajax({

			url: projectName + "/Like",
			method: "POST",
			data: { videoCode, isLike },
			success: (resp) => {
				const json = JSON.parse(resp);

				if (json.isRemove) {
					$("#btn-like .bi").removeClass("bi-hand-thumbs-up-fill").addClass("bi-hand-thumbs-up")
				} else {
					$("#btn-dislike .bi").removeClass("bi-hand-thumbs-down-fill").addClass("bi-hand-thumbs-down")
					$("#btn-like .bi").removeClass("bi-hand-thumbs-up").addClass("bi-hand-thumbs-up-fill")
				}

			}
		})

	})
	$("#btn-dislike").click(function() {

		const videoCode = $(this).attr("video-code")
		const isLike = false

		$.ajax({

			url: projectName + "/Like",
			method: "POST",
			data: { videoCode, isLike },
			success: (resp) => {
				const json = JSON.parse(resp);

				if (json.isRemove) {
					$("#btn-dislike .bi").removeClass("bi-hand-thumbs-down-fill").addClass("bi-hand-thumbs-down")
				} else {
					$("#btn-dislike .bi").removeClass("bi-hand-thumbs-down").addClass("bi-hand-thumbs-down-fill")
					$("#btn-like .bi").removeClass("bi-hand-thumbs-up-fill").addClass("bi-hand-thumbs-up")
				}

			}
		})

	})

})