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
