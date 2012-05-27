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

import static com.fizzner.valueobject.time.Day.today;
import static com.fizzner.valueobject.time.Day.withDate;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class DayTest {
	@Test
	public void shouldPrintDayInProperForm() throws Exception {
		// given
		Day day = withDate(2012, Month.JANUARY, 23);

		// when
		String print = day.print();

		// then
		assertThat(print).isEqualTo("2012-01-23");
	}

	@Test
	public void shouldPrintDayNoWithZeroAtFirstIfDayIsOneNumber() throws Exception {
		// given
		int dayWithOneNumber = 3;
		Day day = withDate(2012, Month.JANUARY, dayWithOneNumber);

		// when
		String print = day.print();

		// then
		assertThat(print).isEqualTo("2012-01-03");
	}

	@Test
	public void shouldCreateDayWithZeroedTimeForGivenMillis() {
		//given
		Calendar cal = Calendar.getInstance();
		int notZeroedHour = 4;
		int notZeroedMinute = 5;
		int notZeroedSecond = 6;
		cal.set(2011, 11, 1, notZeroedHour, notZeroedMinute, notZeroedSecond);
		Date dateWithNotZeroedTime = cal.getTime();
		long time = dateWithNotZeroedTime.getTime();

		//when
		Day day = Day.fromMillis(time);

		//then
		long dayAsMillis = day.asMilliseconds();
		cal.setTimeInMillis(dayAsMillis);
		assertThat(cal.get(Calendar.HOUR_OF_DAY)).isZero();
		assertThat(cal.get(Calendar.MINUTE)).isZero();
		assertThat(cal.get(Calendar.SECOND)).isZero();
		assertThat(cal.get(Calendar.MILLISECOND)).isZero();
	}

	@Test
	public void shouldCalculateDayDifferenceBetweenSameDay() {
		//given
		Day day = withDate(2012, Month.JANUARY, 15);
		Day sameDay = withDate(2012, Month.JANUARY, 15);

		//when
		int numberDaysBetween = day.differenceWith(sameDay);

		//then
		assertThat(numberDaysBetween).isZero();
	}

	@Test
	public void shouldCalculateDayDifferenceBetweenNextDay() {
		//given
		Day day = withDate(2012, Month.JANUARY, 15);
		Day nextDay = withDate(2012, Month.JANUARY, 16);

		//when
		int numberDaysBetween = day.differenceWith(nextDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(1);
	}

	@Test
	public void shouldCalculateDayDifferenceBetween10DaysForward() {
		//given
		Day day = withDate(2012, Month.JANUARY, 15);
		Day nextDay = withDate(2012, Month.JANUARY, 25);

		//when
		int numberDaysBetween = day.differenceWith(nextDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(10);
	}

	@Test
	public void shouldCalculateDayDifferenceBetweenPreviousDay() {
		//given
		Day day = withDate(2012, Month.JANUARY, 15);
		Day prevDay = withDate(2012, Month.JANUARY, 14);

		//when
		int numberDaysBetween = day.differenceWith(prevDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(-1);
	}

	@Test
	public void shouldIncreaseDay() {
		//given
		int dayNo = 15;
		Day day = withDate(2012, Month.FEBRUARY, dayNo);
		int oneDay = 1;

		//when
		day.plusDays(oneDay);

		//then
		Day expectedDay = withDate(2012, Month.FEBRUARY, dayNo + oneDay);
		assertThat(day).isEqualTo(expectedDay);
	}

	@Test
	public void shouldDecreaseDay() {
		//given
		int dayNo = 15;
		Day day = withDate(2012, Month.FEBRUARY, dayNo);
		int oneDay = 1;

		//when
		day.minusDays(oneDay);

		//then
		Day expectedDay = withDate(2012, Month.FEBRUARY, dayNo - oneDay);
		assertThat(day).isEqualTo(expectedDay);
	}

	@Test
	public void shouldCreateYesterday() {
		//given

		//when
		Day yesterday = Day.yesterday();

		//then
		assertThat(yesterday).isEqualTo(today().minusDays(1));
	}

	@Test
	public void shouldCreateTomorrow() {
		//given

		//when
		Day tomorrow = Day.tomorrow();

		//then
		assertThat(tomorrow).isEqualTo(today().plusDays(1));
	}
}
