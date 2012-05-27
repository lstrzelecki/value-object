/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
			if (month.match(monthNumber)) {
				return month;
			}
		}
		throw new MonthOutOfRangeException(monthNumber);
	}
}
