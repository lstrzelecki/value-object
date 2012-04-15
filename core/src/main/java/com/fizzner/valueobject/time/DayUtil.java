package com.fizzner.valueobject.time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class DayUtil {

	private static final int MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

	/**
	 * @param year
	 * @param month starts from 1
	 * @param day
	 * @return
	 */
	public static Date asDate(int year, Month month, int day) {
		Calendar instance = Calendar.getInstance();
		instance.clear();
		instance.set(year, month.getMonthNumberForCalendar(), day);
		return instance.getTime();
	}

	static int diffDay(Day source, Day targe) {
		long currentMillis = source.asMilliseconds();
		long anotherMillis = targe.asMilliseconds();
		long diffMillis = anotherMillis - currentMillis;

		long diffDays = diffMillis / MILLIS_PER_DAY;
		return (int) diffDays;
	}

	static Day addDays(Day source, int daysToAdd) {
		long addedDayInMillis = source.asMilliseconds() + daysToAdd * MILLIS_PER_DAY;
		source.getValue().setTime(addedDayInMillis);
		return source;
	}
}
