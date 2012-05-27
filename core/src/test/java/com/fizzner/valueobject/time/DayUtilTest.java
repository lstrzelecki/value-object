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

import static org.fest.assertions.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

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
