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

import com.fizzner.valueobject.Displayable;
import java.io.Serializable;
import java.util.Iterator;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.4
 */
public abstract class Scope<T> implements Iterator<T>, Serializable, Displayable {
	protected final T min;

	protected final T max;

	public Scope(T min, T max) {
		this.min = min;
		this.max = max;

		if (minIsGreaterThanMax()) {
			throw new WrongScopeException(this);
		}
	}

	protected abstract boolean minIsGreaterThanMax();

	@Override
	public boolean hasNext() {
		// todo implement
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public T next() {
		// todo implement me
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Cannot change scope");
	}

	@Override
	public String print() {
		return "[" + min + " , " + max + "]";
	}

	@Override
	public String toString() {
		return print();
	}
}
