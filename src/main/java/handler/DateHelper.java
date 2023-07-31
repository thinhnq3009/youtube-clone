package handler;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static Date now() {
		return new Date();
	}
	
	public static Date getDate(int far) {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, far);

		// Đặt giờ, phút, giây và mili giây về 0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 1);

		
		
		return calendar.getTime();
	}
}
