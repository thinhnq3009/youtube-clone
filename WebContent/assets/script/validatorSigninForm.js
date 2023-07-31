$(document).ready(function() {

	$("#input-block_username").find("input").blur(function() {
		const input = $(this);
		$("#input-block_username .right-icon").addClass("is-loading bi-arrow-clockwise")
			.removeClass("bi-check-circle")
			.removeClass("bi-x-circle");
		$.ajax({
			url: projectName + "/CheckUsername",
			method: "GET",
			data: { username: input.val() },
			success: function(response) {

				try {
					const json = JSON.parse(response)
					if (json.value == "true") {
						$("#input-block_username .right-icon").addClass("bi-x-circle").removeClass("bi-arrow-clockwise");

					} else {
						console.log("Có thể dùng")
						$("#input-block_username .right-icon")
							.addClass("bi-check-circle").
							removeClass("bi-arrow-clockwise")
							.parent().removeClass("invalid").find("#username-error").hide();
					}
				} catch (e) {
					console.error("Data is bad")

				}

			},
			complete: function() {
				$("#input-block_username").find(".right-icon").removeClass("is-loading");
			}
		});
	});


	$.validator.addMethod("checkUsername", function(value, element) {
		if ($(element).next(".right-icon").hasClass('bi-x-circle')) {
			return false;
		}
		return true;
	});


	$.validator.addMethod(
		"alphanumeric",
		function(value, element) {
			return this.optional(element) || /^\w+$/i.test(value);
		}
	);



	$("#signIn").validate({
		onfocusout: false,
		onkeyup: false,
		rules: {
			username: {
				required: true,
				checkUsername: true,
				alphanumeric: true,
				minlength: 5
			},
			channelName: {
				required: true,
				minlength: 5
			},
			email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 6
			},
			repeatPassword: {
				required: true,
				equalTo: "#password"
			}
		},
		messages: {
			username: {
				required: "Please enter your username",
				checkUsername: "This username is have been used",
				alphanumeric: "Username must include (A-Z, a-z, 0-9)",
				minlength: "Your username must be at least 5 characters long",
			},
			channelName: {
				required: "Please enter your channel name",
				minlength: "Your channel name must be at least 5 characters long"
			},
			email: {
				required: "Please enter your email address",
				email: "Please enter a valid email address"
			},
			password: {
				required: "Please enter your password",
				minlength: "Your password must be at least 6 characters long"
			},
			repeatPassword: {
				required: "Please repeat your password",
				equalTo: "Your passwords do not match"
			}
		},
		errorPlacement: function(error, element) {
			error.insertAfter(element.next(".right-icon"));
		},
		highlight: function(element) {
			$(element).parent().addClass("invalid");
		},
		unhighlight: function(element) {
			$(element).parent().removeClass("invalid");
		},
		submitHandler: function(form) {
			$("#loading-wrapper").show();
			form.submit()
		}

	});
});
