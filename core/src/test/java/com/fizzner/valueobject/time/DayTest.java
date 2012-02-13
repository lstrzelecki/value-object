package com.fizzner.valueobject.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class DayTest {
	@Test
	public void shouldPrintDayInProperForm() throws Exception {
		// given
		Day day = new Day(2012, Month.JANUARY, 23);

		// when
		String print = day.print();

		// then
		assertThat(print).isEqualTo("2012-01-23");
	}

	@Test
	public void shouldPrintDayNoWithZeroAtFirstIfDayIsOneNumber() throws Exception {
		// given
		int dayWithOneNumber = 3;
		Day day = new Day(2012, Month.JANUARY, dayWithOneNumber);

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
		Day day = new Day(time);

		//then
		long dayAsMillis = day.asMilliseconds();
		cal.setTimeInMillis(dayAsMillis);
		assertThat(cal.get(Calendar.HOUR_OF_DAY)).isZero();
		assertThat(cal.get(Calendar.MINUTE)).isZero();
		assertThat(cal.get(Calendar.SECOND)).isZero();
		assertThat(cal.get(Calendar.MILLISECOND)).isZero();

	}
}
