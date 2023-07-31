$.validator.addMethod("checkUsername", (value, element) => {
    $.ajax({
        url: projectName + "/CheckUsername",
        method: "GET", data: { username: value },
        success: function (response) {
            console.log(response);
            try {
                const json = JSON.parse(response)
                callback(!json.value);
            }
            catch (e) {
                console.error("Data is bad")
                callback(false);
            }
        }
    })
})