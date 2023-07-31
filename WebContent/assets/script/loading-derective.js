$("form[loading-on-submit]").submit(() => {
	$("#loading-wrapper").show()
})

$("button[loading-on-click]").click(() => {
	$("#loading-wrapper").show()
})