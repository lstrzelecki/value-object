package com.fizzner.valueobject.time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class DayUtil {
	/**
	 *
	 *
	 * @param year
	 * @param month starts from 1
	 * @param day
	 * @return
	 */
	public static Date asDate(int year, Month month, int day) {
		Calendar instance = Calendar.getInstance();
		instance.set(year, month.getMonthNumberForCalendar(), day,0,0,0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime();
	}
}
