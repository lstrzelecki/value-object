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
