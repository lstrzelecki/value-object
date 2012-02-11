package com.fizzner.valueobject.time;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public enum Month {
	JANUARY(1),
	FEBRUARY(2),
	MARCH(3),
	APRIL(4),
	MAY(5),
	JUNE(6),
	JULY(7),
	AUGUST(8),
	SEPTEMBER(9),
	OCTOBER(10),
	NOVEMBER(11),
	DECEMBER(12);

	private int monthNumber;

	private Month(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public int getMonthNumberForCalendar() {
		return monthNumber - 1;
	}

	boolean match(int monthNumber) {
		return this.monthNumber == monthNumber;
	}

	public static Month matchMonth(int monthNumber) {
		for (Month month : values()) {
			if (month.match(monthNumber))
				return month;
		}
		throw new MonthOutOfRangeException(monthNumber);
	}
}
