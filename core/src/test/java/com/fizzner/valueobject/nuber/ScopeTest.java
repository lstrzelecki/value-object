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

package com.fizzner.valueobject.nuber;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.then;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

import org.junit.Test;

public class ScopeTest {

	public static final Scope<Integer> INTEGER_SCOPE = new IntegerScope(1, 2);

	@Test
	public void shouldUnsupportRemoveOperation() {
		//given

		//when
		when(INTEGER_SCOPE).remove();

		//then
		then(caughtException()).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	public void shouldNotAllowCreateScopeWithMinGreaterThanMax() {
		//given
		int tooBigMin = 100;
		int max = 1;
		try {
			//when
			new IntegerScope(tooBigMin, max);

			//then
			fail("Expected " + WrongScopeException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(WrongScopeException.class);
		}
	}
}

class IntegerScope extends Scope<Integer> {

	public IntegerScope(Integer min, Integer max) {
		super(min, max);
		if (minIsGreaterThanMax()) {
		}
	}

	@Override
	protected boolean minIsGreaterThanMax() {
		return min > max;
	}
}
