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
		Day day = Day.withDate(2012, Month.JANUARY, 23);

		// when
		String print = day.print();

		// then
		assertThat(print).isEqualTo("2012-01-23");
	}

	@Test
	public void shouldPrintDayNoWithZeroAtFirstIfDayIsOneNumber() throws Exception {
		// given
		int dayWithOneNumber = 3;
		Day day = Day.withDate(2012, Month.JANUARY, dayWithOneNumber);

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
		Day day = Day.withDate(2012, Month.JANUARY, 15);
		Day sameDay = Day.withDate(2012, Month.JANUARY, 15);

		//when
		int numberDaysBetween = day.differenceWith(sameDay);

		//then
		assertThat(numberDaysBetween).isZero();
	}

	@Test
	public void shouldCalculateDayDifferenceBetweenNextDay() {
		//given
		Day day = Day.withDate(2012, Month.JANUARY, 15);
		Day nextDay = Day.withDate(2012, Month.JANUARY, 16);

		//when
		int numberDaysBetween = day.differenceWith(nextDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(1);
	}

	@Test
	public void shouldCalculateDayDifferenceBetween10DaysForward() {
		//given
		Day day = Day.withDate(2012, Month.JANUARY, 15);
		Day nextDay = Day.withDate(2012, Month.JANUARY, 25);

		//when
		int numberDaysBetween = day.differenceWith(nextDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(10);
	}

	@Test
	public void shouldCalculateDayDifferenceBetweenPreviousDay() {
		//given
		Day day = Day.withDate(2012, Month.JANUARY, 15);
		Day prevDay = Day.withDate(2012, Month.JANUARY, 14);

		//when
		int numberDaysBetween = day.differenceWith(prevDay);

		//then
		assertThat(numberDaysBetween).isEqualTo(-1);
	}

	@Test
	public void shouldIncreaseDay() {
		//given
		int dayNo = 15;
		Day day = Day.withDate(2012, Month.FEBRUARY, dayNo);
		int oneDay = 1;

		//when
		day.plusDays(oneDay);

		//then
		Day expectedDay = Day.withDate(2012, Month.FEBRUARY, dayNo + oneDay);
		assertThat(day).isEqualTo(expectedDay);
	}

	@Test
	public void shouldDecreaseDay() {
		//given
		int dayNo = 15;
		Day day = Day.withDate(2012, Month.FEBRUARY, dayNo);
		int oneDay = 1;

		//when
		day.minusDays(oneDay);

		//then
		Day expectedDay = Day.withDate(2012, Month.FEBRUARY, dayNo - oneDay);
		assertThat(day).isEqualTo(expectedDay);
	}
}
