$(document).ready(function() {
	//	$('#video-input').change(function() {
	//		$('#preview-container').show();
	//
	//		// Lấy tệp đã chọn
	//		var file = this.files[0];
	//
	//		var fileName = file.name;
	//		// Tạo đối tượng FileReader
	//		var reader = new FileReader();
	//		// Đọc tệp
	//		reader.readAsDataURL(file);
	//		// Xử lý khi đọc xong tệp
	//		reader.onload = function() {
	//			// Lấy đường dẫn của tệp
	//			var url = reader.result;
	//			// Hiển thị đường dẫn vào thẻ video
	//			$('#preview-container video')
	//				.attr('src', url);
	//			$('#preview-container video').on("loadedmetadata", function() {
	//				const duration = this.duration;
	//				$('#timer').html(formatTime(duration));
	//				$("#title-input").val(fileName);
	//				$("#title-length").html(fileName.length);
	//				$("#title-preview").html(fileName);
	//				$("#secondLength").val(Math.floor(duration))
	//			});
	//			$('#input-container').hide()
	//		}
	//	});

	$('#video-input').change(function() {
		$('#preview-container').show();

		// Lấy tệp đã chọn
		var file = this.files[0];

		// Hiển thị video xem trước từ tệp
		var video = document.getElementById('preview-container').querySelector('video');
		video.src = URL.createObjectURL(file);

		video.onloadedmetadata = function() {
			// Cập nhật thời lượng video
			const duration = this.duration;
			$('#timer').html(formatTime(duration));
			// Cập nhật tiêu đề video
			const fileName = file.name;
			$("#title-input").val(fileName);
			$("#title-length").html(fileName.length);
			$("#title-preview").html(fileName);
			// Cập nhật độ dài video
			$("#secondLength").val(Math.floor(duration));
		}

		$('#input-container').hide();
	});


	$('#preview-container button').click(() => {
		console.log("Ckicked")
		$('#preview-container').hide();
		$('#input-container').show();
	})


	$('#poster-input').change(() => {
		const file = $('#poster-input').prop('files')[0];
		const url = URL.createObjectURL(file);
		$('#poster-preview').attr('src', url);
	});


	$("#title-input").on("input", function() {
		const value = $(this).val();
		$("#title-length").html(value.length);
		$("#title-preview").html(value);
	})

	$("#description-input").on("input", function() {
		const value = $(this).val();
		$("#description-length").html(value.length);
		$("#description-preview").html(value);
	})

});



