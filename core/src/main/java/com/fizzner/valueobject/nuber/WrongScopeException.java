package com.fizzner.valueobject.nuber;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.4
 */
public class WrongScopeException extends RuntimeException {
	public WrongScopeException(Scope scope) {
		super("Given scope: " + scope + " has wrong min max values");
	}
}
