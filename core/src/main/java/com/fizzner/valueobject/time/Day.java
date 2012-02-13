package com.fizzner.valueobject.time;

import com.fizzner.valueobject.Displayable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class Day implements Displayable {

	public static final String PROPER_FORMAT = "yyyy-MM-dd";

	private static final SimpleDateFormat yyyyMMdd =
			new SimpleDateFormat(PROPER_FORMAT);

	private Date value;

	public Day(long millis) {
		this(new Date(millis));

	}

	public Day() {
		this(new Date());
	}

	private Day(Date value) {
		this.value = asDateWithResetTime(value);
	}

	public Day(int year, Month month, int day) {
		value = asDateWithResetTime(year, month, day);
	}

	private Date asDateWithResetTime(int year, Month month, int day) {
		Calendar instance = Calendar.getInstance();
		instance.set(year, month.getMonthNumberForCalendar(), day,0,0,0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime();
	}
	
	private Date asDateWithResetTime(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE,0);
		instance.set(Calendar.SECOND,0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime();
	}

	public Date getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Day{" +
				"value=" + value +
				'}';
	}

	/**
	 * Used for cxf parsing
	 */
	public static Day fromString(String value) throws ParseException {
		Date parsed = yyyyMMdd.parse(value);
		return new Day(parsed);
	}

	@Override
	public String print() {
		return yyyyMMdd.format(value);
	}

	public long asMilliseconds() {
		return value.getTime();
	}
}
