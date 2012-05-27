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
import static org.fest.assertions.Fail.fail;

import org.junit.Test;

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
