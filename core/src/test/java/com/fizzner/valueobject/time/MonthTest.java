package com.fizzner.valueobject.time;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class MonthTest {
	@Test
	public void shouldMatchMonthForNumber() {
		//given
		int januaryNumber = 1;

		//when
		Month january = Month.matchMonth(januaryNumber);

		//then
		assertThat(january).isEqualTo(Month.JANUARY);
	}

	@Test
	public void shouldThrowExceptionWhenMonthNumberIsTooHigh() {
		//given
		int invalidTooHighMonthNumber = 13;

		try {
			//when
			Month.matchMonth(invalidTooHighMonthNumber);

			//then
			fail("Expected: " + MonthOutOfRangeException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(MonthOutOfRangeException.class);
			assertThat(e.getMessage()).isNotEmpty();
		}
	}

	@Test
	public void shouldThrowExceptionWhenMonthNumberIsTooLow() {
		//given
		int invalidTooLowMonthNumber = 0;

		try {
			//when
			Month.matchMonth(invalidTooLowMonthNumber);

			//then
			fail("Expected: " + MonthOutOfRangeException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(MonthOutOfRangeException.class);
			assertThat(e.getMessage()).isNotEmpty();
		}
	}
}
