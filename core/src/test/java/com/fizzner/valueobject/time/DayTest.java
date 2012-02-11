package com.fizzner.valueobject.time;

import org.junit.Test;

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
}
