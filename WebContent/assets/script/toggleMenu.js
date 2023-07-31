

$(document).ready(() => {
	
	// Click bên ngoài thì ẩn menu nổi
	$("#popup-guide").click(() => {
		$("#popup-guide").removeClass("d-block")

	});
	
	
	// Nếu đã có menu rồi thì chỉ thu nhỏ phóng to, còn chưa có thì show menu nổi lên
	$("#btn-show-guide").click(() => {
		if ($(".guide-container").length == 2) {
			$("div[toggle-guide='true']").toggleClass("mini-guide");
		} else {
			console.log('show guide')
			$("#popup-guide").toggleClass("d-block");
		}
		
		
	}) 
}
)