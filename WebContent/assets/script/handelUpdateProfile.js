$(document).ready(function() {
	$('#avatar-input').change(() => {
		const file = $('#avatar-input').prop('files')[0];
		const url = URL.createObjectURL(file);
		$('#avatar-preview').attr('src', url);
	});



});



