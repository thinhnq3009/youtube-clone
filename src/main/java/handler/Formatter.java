package handler;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class Formatter {
	public static String formatTime(long l) {
		long hours = l / 3600;
		long minutes = (l - hours * 3600) / 60;
		long seconds = l - hours * 3600 - minutes * 60;

		String[] parts = { String.format("%02d", hours), String.format("%02d", minutes),
				String.format("%02d", seconds) };

		if (hours == 0) {
			return String.join(":", Arrays.copyOfRange(parts, 1, 3));
		} else {
			return String.join(":", parts);
		}
	}

	public static String getTimeAgo(Date date) {

		LocalDateTime now = LocalDateTime.now();

		Instant instant = date.toInstant();

		ZoneId zoneId = ZoneId.systemDefault();

		LocalDateTime datePost = instant.atZone(zoneId).toLocalDateTime();

		Duration duration = Duration.between(datePost, now);

		long s = duration.toSeconds();

		if (s < 60) {
			return s + " giây trước";
		} else if (s < 60 * 60) {
			return (int) Math.floor(s / 60) + " phút trước";
		} else if (s < 60 * 60 * 24) {
			return (int) Math.floor(s / (60 * 60)) + " giờ trước";
		} else if (s < 60 * 60 * 24 * 30) {
			int day = (int) Math.floor(s / (60 * 60 * 24));
			if (day % 7 == 0) {
				return (int) (day / 7) + " tuần trước";
			} else {
				return day + " ngày trước";
			}
		} else if (s < 60 * 60 * 24 * 30 * 12) {
			return (int) Math.floor(s / (60 * 60 * 24 * 30)) + " tháng trước";
		} else {
			return (int) Math.round(s / (60 * 60 * 24 * 30 * 12)) + " năm trước";
		}

	}

}
