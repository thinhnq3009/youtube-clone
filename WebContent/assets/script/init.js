const projectName = "/YoutubeClone";
function formatTime(duration) {
	const hours = Math.floor(duration / 3600);
	const minutes = Math.floor((duration - hours * 3600) / 60);
	const seconds = Math.floor(duration - hours * 3600 - minutes * 60);

	const parts = [hours, minutes, seconds].map(part => {
		if (part < 10) {
			return `0${part}`;
		}
		return `${part}`;
	});

	if (hours === 0) {
		return parts.slice(1).join(":");
	} else {
		return parts.join(":");
	}
}

