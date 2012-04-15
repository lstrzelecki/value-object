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

	public static Day today() {
		return new Day();
	}

	public static Day yesterday() {
		return today().minusDays(1);
	}

	public static Day tomorrow() {
		return today().plusDays(1);
	}

	public static Day fromMillis(long dayAsMillis) {
		return new Day(dayAsMillis);
	}

	public static Day fromDate(Date date) {
		return new Day(date);
	}

	public static Day withDate(int year, Month month, int day) {
		return new Day(year, month, day);
	}

	private Day() {
		this(new Date());
	}

	private Day(long millis) {
		this(new Date(millis));
	}

	private Day(Date value) {
		this.value = asDateWithResetTime(value);
	}

	private Day(int year, Month month, int day) {
		value = asDateWithResetTime(year, month, day);
	}

	private Date asDateWithResetTime(int year, Month month, int day) {
		return DayUtil.asDate(year, month, day);
	}

	private Date asDateWithResetTime(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance.getTime();
	}

	public Date getValue() {
		return value;
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

	/**
	 * @param another Day with which is calculated difference
	 * @return number of days between current object day and given as argument. May return:
	 *         <ul>
	 *         <li>0 - when day are same</li>
	 *         <li>positive number of days param another is greater</li>
	 *         <li>negative number of days param another is lower</li>
	 *         </ul>
	 */
	public int differenceWith(Day another) {
		return DayUtil.diffDay(this, another);
	}

	public Day minusDays(int numberOfDays) {
		DayUtil.addDays(this, -numberOfDays);
		return this;
	}

	public Day plusDays(int numberOfDays) {
		DayUtil.addDays(this, numberOfDays);
		return this;
	}

	@Override
	public String toString() {
		return "Day{" +
			   "value=" + value +
			   '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Day day = (Day) o;

		if (value != null ? !value.equals(day.value) : day.value != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
