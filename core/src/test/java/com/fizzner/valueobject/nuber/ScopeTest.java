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
