package com.fizzner.valueobject.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class DayUtilTest {
	@Test
	public void shouldTimeElementsSetToZero() throws Exception {
		// given

		// when
		Date day = DayUtil.asDate(2012, Month.JANUARY, 1);

		// then
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		assertThat(calendar.get(Calendar.HOUR_OF_DAY)).isZero();
		assertThat(calendar.get(Calendar.MINUTE)).isZero();
		assertThat(calendar.get(Calendar.SECOND)).isZero();
		assertThat(calendar.get(Calendar.MILLISECOND)).isZero();
	}

	@Test
	public void shouldNumberingMonthsStartFromOne() throws Exception {
		// given
		Month january = Month.JANUARY;

		// when
		Date day = DayUtil.asDate(2012, january, 1);

		// then
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		assertThat(calendar.get(Calendar.MONTH)).isEqualTo(Calendar.JANUARY);
	}


}
