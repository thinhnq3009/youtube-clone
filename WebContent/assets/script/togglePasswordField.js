$("input[type='password']").parent().find('.right-icon').click((event) => {
	const parent = $(event.target).parent();
	parent.find('input').attr("type", (index, currentValue) => {
		const newValue = currentValue == "text" ? "password" : "text";

		if (newValue === "text") {
			parent.find(".right-icon").addClass('bi-eye-slash').removeClass('bi-eye')
		} else {
			parent.find(".right-icon").removeClass('bi-eye-slash').addClass('bi-eye')
		}
		
		return newValue;
	})
})